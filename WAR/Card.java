public class Card
{
   final public static int ACE = 1;
   final public static int JACK = 11;
   final public static int QUEEN = 12;
   final public static int KING = 13;
   
   final public static int SPADES = 0;
   final public static int DIAMONDS = 1;
   final public static int CLUBS = 2;
   final public static int HEARTS = 3;

   private int rank;
   private int suit;
   
   public Card(int rank, int suit)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   public Card(Card c)
   {
      this.rank = c.rank;
      this.suit = c.suit;
   }
   
   public int getSuit()
   {
      return suit;
   }
   
   public int getRank()
   {
      return rank;
   }
   
   public String toString()
   {
      String name;
      switch(rank)
      {
         case ACE:
            //name = "Ace";
            name = "ace";
            break;
         case JACK:
            //name = "Jack";
            name = "jack";
            break;
         case QUEEN:
            //name = "Queen";
            name = "queen";
            break;
         case KING:
            //name = "King";
            name = "king";
            break;
         default:
            name = "" + rank;
            break;
      }

      //name += " of ";

      switch(suit)
      {
         case HEARTS:
            //name += "Hearts";
            name += "h";
            break;
         case DIAMONDS:
            //name += "Diamonds";
            name += "d";
            break;
         case CLUBS:
            //name += "Clubs";
            name += "c";
            break;
         case SPADES:
            //name += "Spades";
            name += "s";
            break;
      }
      
      return name;
   }
   
   public int compareTo(Card c)
   {
      int thisRank = this.getRank();
      int otherRank = c.getRank();
      if (thisRank == 1) thisRank = 14;// make aces high
      if (otherRank == 1) otherRank = 14;
      
      return thisRank - otherRank;
   }
   
   public boolean equals(Card c)
   {
      if(this.rank == c.rank)
         return true;
      return false;
   }
}
