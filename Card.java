package Package1;

/**
 * This is a class that creates a card object that holds the suit and face.
 * 
 * @author Timothy Cottrell
 * @version v1
 */
public class Card
{
    private int value;
    private int warValue;
    private String suit;
    private String face;
    /**
     * This constructor that creat's a blank card.
     */
    public Card()
    {
        value = 0;
        warValue = 0;
        suit = "unknown";
        face = "unknown";
    }
    /**
     * This constructor sets the value of any given card in a deck.
     * @param defValue the new value you would like the card to have.
     * @param defSuit the new suit name you would like it to have.
     * @param defFace the new face name that you would like it to have.
     * @param defWarValue the new warValue that you would like the card to have.
     */
    public Card(int defValue, String defSuit, String defFace, int defWarValue)
    {
        value = defValue;
        suit = defSuit;
        face = defFace;
        warValue = defWarValue;
    }
    /**
     * retrieves the value of the card being called.
     * @return the field variable value that the card being called has.
     */
    public int getValue()
    {
        return value;
    }
    /**
     * retrieves the suit name.
     * @return the suit variable suit value that the card being called has.
     */
    public String getSuit()
    {
        return suit;
    }
    /**
     * retrieves the face name.
     * @return the face variable face value that the card being called has.
     */
    public String getFace()
    {
        return face;
    }
    /**
     * retrieves the int value of the card based on the game war.
     * @return The value of a card based on the game of war.
     */
    public int getWarValue()
    {
    	return warValue;
    }
    /**
     * Changes the value of warValue of a card
     * @param defWarValue the new war value of a card.
     */
    public void setWarValue(int defWarValue)
    {
    	warValue = defWarValue;
    }
    /**
     * sets the value of a card.
     * @param defValue the new value of the card being called.
     */
    public void setValue(int defValue)
    {
        value = defValue;
    }
    /**
     * sets the suit of a card.
     * @param defSuit the new String value of the card being called.
     */
    public void setSuit(String defSuit)
    {
        suit = defSuit;
    }
    /**
     * sets the face of a card.
     * @param defFace the new String value of the card being called.
     */
    public void setFace(String defFace)
    {
        face = defFace;
    }
    /**
     * returns a String of all the fields of a card.
     * @return A neat string value of all the field for a card object.
     */
    public String toString()
    {
        return face + " of " + suit + " - " + value;
    }
    /**
     * @return returns a positive number if the card in the parameter has a smaller value. returns a negative number if the card being called has a smaller value. returns a zero if they are the same.
     */
    public int compareTo(Card Card)
    {
        if(this.getValue()>Card.getValue())
        {
            return 1;
        }else if(this.getValue()<Card.getValue())
        {
            return -1;
        }else
        {
            return 0;
        }
    }
    /**
     * @return returns true if the card in the paramitor and the card being called have the same suit and face.
     * @param card another card object.
     */
    public boolean equals(Card card)
    {
        if(this.getFace()==card.getFace()&&this.getSuit()==card.getSuit())
        {
            return true;
        }else
        {
            return false;
        }
    }
    /**
     * takes the values of the card being called and gives them to the card in the parameter.
     * @param A card object that will soon have all of the values of the card being called.
     */
    public void copyCard(Card card)
    {
        card.setValue(this.getValue());
        card.setSuit(this.getSuit());
        card.setFace(this.getFace());
        card.setWarValue(this.getWarValue());
    }
    /**
     * takes the values of the card being called and the card in the parameter and switch them.
     * @param card another card object that will soon switch all the value of all the field with the card being called.
     */
    public void switchCards(Card card)
    {
        Card def = new Card();
        this.copyCard(def);
        card.copyCard(this);
        def.copyCard(card);
    }
    public int war(Card card)
    {
	    
    	if(this.getFace() == card.getFace())
	    {
	    	return 0;
	    }
    	if(this.getWarValue()>card.getWarValue())
    	{
    		return 1;
    	}
    	if(this.getWarValue()<card.getWarValue())
    	{
    		return -1;
    	}
    	return 0;
    }
}
