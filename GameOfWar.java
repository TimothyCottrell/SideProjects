package Package1;
/**
 * This is a class created to run a program that will allow the user to play a game of war with the computer.
 * 
 * @author Timothy Cottrell
 * @version v1
 */
public class GameOfWar
{
	/**
	 * This is the main method that runs and tests many of the methods in both the Card and the Deck class. This also Allows the User to play a game of war (a game of luck) with the computer.
	 * 
	 */
	public static void main(String[] args)
	{
		 Deck cards = new Deck();
		 System.out.println("Lets Play War!!\n");
		 cards.shuffle();
		 cards.splitDeck();
		 int score = 0;
		 boolean war = false;
		 for(int i=0;i<26;i++)
		 {
			 if(!war)
			 {
				 System.out.println("You flipped "+cards.getCardInOrderOfHalfDeck(i,true).toString()+" Your opponent flipped "+cards.getCardInOrderOfHalfDeck(i,false).toString());
				 score += cards.getCardInOrderOfHalfDeck(i,true).war(cards.getCardInOrderOfHalfDeck(i,false));
			 }else
			 {
				 score = score + cards.getCardInOrderOfHalfDeck(i,true).war(cards.getCardInOrderOfHalfDeck(i,false))*3;
			 }
			 if(cards.getCardInOrderOfHalfDeck(i,true).war(cards.getCardInOrderOfHalfDeck(i,false))==0)
			 {
				 i=i+3;
				 if(i>=26)
				 {
					 i=25;
					 war = true;
				 }
			 }
		 }
		 System.out.println("-----------------------------------\n");
		 if(score>0)
		 {
			 System.out.println("You Win!");
		 }else if(score<0)
		 {
			 System.out.println("You Lose!");
		 }else
		 {
			 System.out.println("You Tie!");
		 }
//		 System.out.println(cards.halfToString(true));
//		 System.out.println("-----------------------------------\n");
//		 System.out.println(cards.halfToString(false));
	}
}
