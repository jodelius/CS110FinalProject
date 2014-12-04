/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Jacob Odelius
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck extends CardPile
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The super's shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
      freshDeck();
   }
   
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      for(int s=Card.SPADES;s<=Card.HEARTS;s++)
      {
         for(int r=Card.ACE;r<=Card.KING;r++)
         {
           super.add(new Card(r,s));
         }
      }
   }
   
   public MyResult splitDeck()
   {
      CardPile playerHand = new CardPile();
      CardPile computerHand = new CardPile();
      for(int i=0;i<CARDS_IN_DECK/2;i++)
      {
         playerHand.add(drawCard());
         computerHand.add(drawCard());
      }
      return new MyResult(playerHand,computerHand);
   } 
}



