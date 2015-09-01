How to run application  ?
- Download jar file "PokerHand.jar" then run below command:
 java -jar PokerHand.jar

How to Assign cards to player ?
- Just start choose cards for first player , after the 5th card , the game automatically will assign cards to second player.

How to Rank player hands ?
- After assign last card to second playe , the game will automatically calculate players rank and update log table.

How to Start new Game ?
- Click on "Game" - > "New".

What are technologies / languages used ?
- Java (1.8)
- GUI : Swing

Technical notes:
- No performance profiling were run on this application.
- Ranking algorithm could be changes to consider probabilities of different ranks.
- Some codes could be replaced by using third parties libraries.
- Some test cases where not implemented because it will test out of the box java functions such as :
	compareRank method in PokerManager as it depends on .ordinal() method of java Enum.





