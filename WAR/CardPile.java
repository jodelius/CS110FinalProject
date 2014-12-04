/**
 * Representation of a CardPile.  
 *
 * @author Jacob Odelius
 */

import java.util.*;

public class CardPile
{
	/** The collection of Cards */
	private ArrayList<Card> pile;

	/**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
 	public CardPile()
	{
		pile = new ArrayList<Card>();
	}

   /** 
    * Add a Card to the bottom the CardPile
    */
	public void add(Card aCard)
	{
		pile.add(aCard);
	}
   
   /** 
    * Add multiple Cards to the bottom the CardPile
    */
   public void getCards(CardPile p)
   {
      while(p.getCardsRemaining()>0)
         pile.add(p.drawCard());
   }
   

	/** 
    * Remove and return the top Card on the CardPile
    * @return A reference to a Card that was top on the CardPile
    */
   public Card drawCard()
	{
      Card c = pile.remove(0);
		return c;
  	}

	/** 
    * Return current number of Cards in the CardPile
    * @return number of Cards in the CardPile
    */
  	public int getCardsRemaining()
	{
		return pile.size();
	}
   
   /** 
    * Determine if CardPile is empty
    * @return true if there are no more cards, false otherwise  
    */
   public boolean isEmpty()
   {
      return (pile.size() == 0);
   }

	/** 
    * Clear the CardPile of all Cards 
    */
 	public void clear()
	{
		pile.clear();
	}

	/** 
    * Randomize the order of Cards in the CardPile
    */
  	public void shuffle()
	{
      int randNum;
      Card temp;
		Random r = new Random();
      for (int i=0;i<pile.size();i++)
		{
			if(!isEmpty())			 
        	{
            randNum = r.nextInt(pile.size());
            temp = pile.get(i);
            pile.set(i,pile.get(randNum));
            pile.set(randNum,temp);
			}
		}
	}
   
   public Card highCard(Card...cards)
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}
   

