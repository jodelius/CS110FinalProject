public final class MyResult
{
   private final CardPile hand1;
   private final CardPile hand2;

   public MyResult(CardPile first,CardPile second)
   {
      hand1 = first;
      hand2 = second;
   }

   public CardPile getHand1()
   {
      return hand1;
   }

   public CardPile getHand2()
   {
      return hand2;
   }
}