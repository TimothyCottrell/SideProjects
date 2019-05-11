package Package1;

/**
 * This is a Deck class that holds an array of Card objects.
 * 
 * @author Timothy Cottrell
 * @version v1
 */
class Deck
{
    Card[][] cards = new Card[13][4];
    Card[][] topHalf = new Card[13][2];
    Card[][] bottomHalf = new Card[13][2];
    int top;
    /**
     * Constructor method that creates a blank deck of all 52 playing cards.
     */
    public Deck()
    {
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<4;t++)
            {
                cards[i][t] = new Card();
                cards[i][t].setValue((t*13)+(i+1));
                if(t==0)
                {
                    cards[i][t].setSuit("Spades");
                }else if(t==1)
                {
                    cards[i][t].setSuit("Hearts");
                }else if(t==2)
                {
                    cards[i][t].setSuit("Clubs");
                }else
                {
                    cards[i][t].setSuit("Dimonds");
                }
                if(i==0)
                {
                    cards[i][t].setFace("Ace");
                    cards[i][t].setWarValue(14);
                }else if(i==1)
                {
                    cards[i][t].setFace("Jack");
                    cards[i][t].setWarValue(11);
                }else if(i>=2&&i<=10)
                {
                    cards[i][t].setFace(String.valueOf(i));
                    cards[i][t].setWarValue(i);
                }else if(i==11)
                {
                    cards[i][t].setFace("Queen");
                    cards[i][t].setWarValue(12);
                }else if(i==12)
                {
                    cards[i][t].setFace("King");
                    cards[i][t].setWarValue(13);
                }
            }
        }
        top = ((int)(Math.random()*52)+1);
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<2;t++)
            {
            	topHalf[i][t] = new Card();
            	bottomHalf[i][t] = new Card();
            }
        }
    }
    /**
     * A method that gets whatever the top card object is.
     * 
     * @return A card object that is at the "top" of the deck.
     */
    public Card getTopCard()
    {
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<4;t++)
            {
                if(cards[i][t].getValue()==top)
                {
                    return cards[i][t];
                }
            }
        }
        return cards[0][0];
    }
    /**
     * Changes the top card of the deck to a given card.
     * 
     * @param card A Card object that has all the values of the card that you want to be the top card of the deck.
     */
    public void setTopCard(Card card)
    {
        for(int i=0;i<13;i++)
        {
            for(int t=0;i<4;t++)
            {
                if(cards[i][t].getValue()==card.getValue())
                {
                    this.getTopCard().copyCard(cards[i][t]);
                }
            }
        }
        for(int i=0;i<13;i++)
        {
            for(int t=0;i<4;t++)
            {
                if(cards[i][t].getValue()==this.getTopCard().getValue())
                {
                    card.copyCard(cards[i][t]);
                }
            }
        }
    }
    /**
     * sets the top card of the deck by using a number between 1 and 52.
     * @param cardNum a number that you want the top card to have for its value.
     */
    public void setTopCard(int cardNum)
    {
        top = cardNum;
    }
    /**
     * Returns a string value of the deck.
     * @return A String value of every card in the deck.
     */
    public String toString()
    {
        StringBuilder everything = new StringBuilder("");
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<4;t++)
            {
                everything.append(cards[i][t].toString()+"\n");
            }
        }
        return everything.toString();
    }
    /**
     * gets the card object that is any amount of cards down from the "top".
     * 
     * @param orderNum the place in the deck from the top that you want the card object of.
     * @return the Card object that is orderNum from the top.
     */
    public Card getCardInOrder(int orderNum)
    {
        int count = 0;
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<4;t++)
            {
                count++;
                if(count==orderNum)
                {
                    return cards[i][t];
                }
            }
        }
        return cards[0][0];
    }
    /**
     * gets a Card object location from the deck based on its value between 1 and 52.
     * 
     * @param val the value you want the card object that will be returned to have.
     * @return a Card object within the deck being called that has the same value as val.
     */
    public Card getCardUsingValue(int val)
    {
        if(val>52)
        {
            val=52;
        }else if(val<1)
        {
            val=1;
        }
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<4;t++)
            {
                if(cards[i][t].getValue()==val)
                {
                    return cards[i][t];
                }
            }
        }
        return cards[0][0];
    }
    /**
     * shuffles the order of all the cards in the array 1000 times.
     */
    public void shuffle()
    {
        for(int times=0;times<1000;times++)
        {
            this.getTopCard().switchCards(cards[((int)(Math.random()*13))][((int)(Math.random()*4))]);
        }
    }
    /**
     * This is a method that takes the deck and splits it in half, putting the top half in the topHalf array and the bottom half in the bottomHalf array.
     */
    public void splitDeck()
    {
    	for(int i=0;i<13;i++)
        {
        	cards[i][0].copyCard(topHalf[i][0]);
        	cards[i][1].copyCard(topHalf[i][1]);
        	cards[i][2].copyCard(bottomHalf[i][0]);
        	cards[i][3].copyCard(bottomHalf[i][1]);
        }
    }
    /**
     * This method returns a String value of all cards in either the top of bottom of the deck.
     * @param topOrBottom This decides either or not you want the top or bottom half of the deck.
     * @return A string value of every card in the deck of choice.
     */
    public String halfToString(boolean topOrBottom)
    {
    	StringBuilder everything = new StringBuilder("");
        for(int i=0;i<13;i++)
        {
            for(int t=0;t<2;t++)
            {
                if(topOrBottom)
                {
                	everything.append(topHalf[i][t].toString()+"\n");
                }else
                {
                	everything.append(bottomHalf[i][t].toString()+"\n");
                }
            }
        }
        return everything.toString();
    }
    /**
     * This method returns a Card from any of either the top or bottom of the deck.
     * @param place The number of cards down from the top that you want (Starting with 1)
     * @param topOrBottom If you want top or not (top = true, bottom = false)
     * @return A Card object of the Card you wanted.
     */
    public Card getCardInOrderOfHalfDeck(int place, boolean topOrBottom)
    {
    	int count = 0;
    	for(int i=0;i<13;i++)
        {
            for(int t=0;t<2;t++)
            {
            	count++;
            	if(count == place)
            	{
            		if(topOrBottom)
	            	{
	            		return topHalf[i][t];
	            	}else
	            	{
	            		return bottomHalf[i][t];
	            	}
            	}
            	
            }
        }
    	return topHalf[0][0];
    }
}
