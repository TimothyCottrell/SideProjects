package Package1;

/**
 * This is the Driver Class to test both the Card and Deck Classes.
 * 
 * @author Timothy Cottrell
 * @version v1
 */
class Driver
{
    /**
     * Tests may of the methods in both the Deck and Card classes.
     */
    public static void main(String[] args)
    {
        Deck cards = new Deck();
        System.out.println(cards.toString());
        System.out.println("-----------------------------------");
        cards.shuffle();
        System.out.println(cards.toString());
        System.out.println("-----------------------------------");
        System.out.println("The top 2 cards are |"+cards.getCardInOrder(1).toString()+"| and |"+ cards.getCardInOrder(2).toString()+"|");
    }
}
