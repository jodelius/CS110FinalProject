// the guts of the game 
// user interface independent


import javax.swing.*;

public class Driver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI("WAR");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}