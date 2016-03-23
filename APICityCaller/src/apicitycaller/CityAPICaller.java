package apicitycaller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is main class , which is used to call web service for searching
 * about city details.
 *
 * @author Mustafa Othman
 */
public class CityAPICaller {

    /**
     * @param args the command line arguments : first argument as city name , if
     * use enter more that city name , only first one will be considered.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage :java -jar  GoEuroTest.jar CITY_NAME \nExample: java -jar GoEuroTest.jar Berlin");
            System.exit(1);
        }
        String cityName = args[0];
        CityAPICaller caller = new CityAPICaller();
        caller.excutePost(cityName);
    }

    /**
     * Search for city details by calling web service api and create csv file
     * contains city details (id , name , type , latitude , longitude) It
     * convert json objects (array) to POJO and retrieve object properties to be
     * saved in csv file.
     *
     * @param cityName : city name to be search for.
     */
    public void excutePost(String cityName) {
        HttpURLConnection connection = null;
        try {
            System.out.println("Calling service for : " + cityName);
            URL url = new URL("http://api.goeuro.com/api/v2/position/suggest/en/" + cityName);
            URLConnection urlc = url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            // read web service response
            while ((line = bfr.readLine()) != null) {
                JSONArray json = (JSONArray) new JSONParser().parse(line);
                if (json.size() == 0) {
                    System.out.println("No data found for this city :[" + cityName + "]");
                    System.exit(0);
                }
                // creating cvs file content
                StringBuilder cvsFile = new StringBuilder();
                cvsFile.append("_id").append(",");
                cvsFile.append("name").append(",");
                cvsFile.append("type").append(",");
                cvsFile.append("latitude").append(",");
                cvsFile.append("latitude").append("\n");
                // loop over retrieved json response.
                for (int i = 0; i < json.size(); i++) {
                    JSONObject object = (JSONObject) json.get(i);
                    cvsFile.append(object.get("_id")).append(",");
                    cvsFile.append(object.get("name")).append(",");
                    cvsFile.append(object.get("type")).append(",");
                    JSONObject geo = (JSONObject) object.get("geo_position");
                    cvsFile.append(geo.get("latitude")).append(",");
                    cvsFile.append(geo.get("longitude")).append("\n");
                }

                String fileName = cityName + ".csv";
                // wirte data to csv file
                boolean sucess = writeFile(fileName, cvsFile.toString());
                if (sucess) {
                    System.out.println("CVS file created successfully : " + fileName);
                } else {
                    System.out.println("Error occured while writing data to file : " + fileName);
                }
            }

        } catch (MalformedURLException ex) {
            System.out.println("Opps , Something went wrong while calling service \nDetails :");
            Logger.getLogger(CityAPICaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Opps , Something went wrong while calling \nDetails :");
            Logger.getLogger(CityAPICaller.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ParseException ex) {
            System.out.println("Opps , Something went wrong while reading data \nDetails :");
            Logger.getLogger(CityAPICaller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 
     * @param fileName 
     * @param data to be written to file.
     * @return boolean , true if file created success , or false if something
     * went wrong.
     */
    private boolean writeFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Opps , Something went wrong while calling \nDetails :");
            Logger.getLogger(CityAPICaller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
