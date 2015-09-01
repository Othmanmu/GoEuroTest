/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.gui;

import com.flaregames.task.core.Card;
import com.flaregames.task.core.Deck;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * GUI representation of PokerDeck , contains 52 cards.
 *
 * @author mustafa
 */
public class PokerDeck extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form PokerDeck
     *
     * @param deck to be used.
     */
    public PokerDeck(Deck deck) {
        initComponents();

        for (Card c : deck.getCards()) {
            JButton button = new JButton();
            button.setName(c.getValue() + "-" + c.getSuite());
            button.setSize(71, 96);
            ImageIcon image = new ImageIcon(getClass().getResource("/com/flaregames/task/gui/icons/" + c.getValue() + c.getSuite() + ".png"));

            button.setIcon(image);
            button.addActionListener(PokerDeck.this);
            add(button);

        }
    }

    private int cardCount = 0;

    //  reset values of all cards , (Enable all buttons)
    public void reset() {
        for (Component comp : getComponents()) {
            comp.setEnabled(true);
        }
        cardCount = 0;
    }

    public final static String CARD_VALUE = "CARD_VALUE";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(8, 7));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && cardCount < 10) {
            JButton button = (JButton) e.getSource();
            StringTokenizer token = new StringTokenizer(button.getName(), "-");
            Integer value = Integer.valueOf(token.nextElement().toString());
            Object suite = token.nextElement();
            Card card = new Card(value, suite.toString());
            firePropertyChange(CARD_VALUE, null, card);

            button.setEnabled(false);
            cardCount++;
        }
    }
}
