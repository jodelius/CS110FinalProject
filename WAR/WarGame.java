public class WarGame
{

   private Card c1,c2,playerWarCard,computerWarCard,returnCard;
   private CardPile winnings,playerHand,computerHand;
   private Deck d;
   private boolean gameOver;
   private String msg;
   private final int FOR_PLAY = 1;

   public WarGame()
   {
      d = new Deck();
      d.shuffle();
      MyResult playerHands = d.splitDeck();
      playerHand = playerHands.getHand1();
      computerHand = playerHands.getHand2();
      winnings = new CardPile();
   }
   
   public void drawCards()
   {
      if(!enoughCards(FOR_PLAY))
      {
         if(playerHand.getCardsRemaining()<FOR_PLAY)
         {
            msg = "Game Over." + '\n' + "Computer Wins!";  
         }
         else if(computerHand.getCardsRemaining()<FOR_PLAY)
         {
            msg = "Game Over." + '\n' + "Player Win!";
         }
         
         gameOver = true;
      }
      else
      {
         c1 = playerHand.drawCard();
         c2 = computerHand.drawCard();
         winnings.add(c1);
         winnings.add(c2);
      }
   }   
   
   public void compareCards()
   {
      
      if(c1.equals(c2))
      {
         msg = "War!";
         if(!enoughCards(FOR_PLAY))
         {
            if(playerHand.getCardsRemaining()<FOR_PLAY)
            {
               msg = "Game Over." + '\n' + "Computer Wins!";  
            }
            else if(computerHand.getCardsRemaining()<FOR_PLAY)
            {
               msg = "Game Over." + '\n' + "Player Win!";
            }
            
            gameOver = true;
            
         }
         else
         {
            playerWarCard = playerHand.drawCard();
            computerWarCard = computerHand.drawCard();
            winnings.add(playerWarCard);
            winnings.add(computerWarCard);
         }
         
      }
      else if(c1.compareTo(c2)>0)
      {
         playerHand.getCards(winnings);
         msg = "Player Wins Round." + '\n' + "Press Draw";
      }
      else
      {
         computerHand.getCards(winnings);
         msg = "Computer Wins Round." + '\n' + "Press Draw";
      }
   }  
      
   public boolean enoughCards(int n)
   {
      if(playerHand.getCardsRemaining()<n || computerHand.getCardsRemaining()<n)
         return false;
      else
         return true;
   }
   
   public String getMsg()
   {
      return msg;
   }
   
   public boolean gameOver()
   {
      return gameOver;
   }  
   
   public Card getCard(int num)
   {
      if(num == 1)
         returnCard = new Card(c1);
      else if(num == 2)
         returnCard = new Card(c2);
      else if(num == 3)
         returnCard = new Card(playerWarCard);
      else if(num == 4)
         returnCard = new Card(computerWarCard);
      else
         returnCard = null;
      
      return returnCard;   
   }
   
   public void reset()
   {
      playerHand.clear();
      computerHand.clear();
      winnings.clear();
      d.freshDeck();
      d.shuffle();
      MyResult playerHands = d.splitDeck();
      playerHand = playerHands.getHand1();
      computerHand = playerHands.getHand2();      
      msg = "Press Draw";
   }
}         