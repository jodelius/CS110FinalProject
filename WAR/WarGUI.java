import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   
   private WarGame war; // the guts
   
   //Panels
   private JPanel titlePanel;
   private JPanel gamePanel;
   private JPanel menuPanel;
   
   private JPanel playerPanel;
   private JPanel computerPanel;
   private JPanel playerLabelPanel;
   
   //Labels 
   private JLabel title;
   private JLabel status;
   private JLabel playerCardsPic;
   private JLabel playerHandLabel;
   private JLabel playerDrawCardPic;
   private JLabel playerDrawCardLabel;
   private JLabel playerWarCardPic;
   private JLabel computerCardsPic;
   private JLabel computerHandLabel;
   private JLabel computerDrawCardPic;
   private JLabel computerDrawCardLabel;
   private JLabel computerWarCardPic;
   private JLabel warCardsLabel;
   private JLabel blankLabel;
   
   //Image Icons
   private ImageIcon playerDrawCardIcon;
   private ImageIcon playerWarCardIcon;
   private ImageIcon computerDrawCardIcon;
   private ImageIcon computerWarCardIcon;
   private ImageIcon backIcon;
   //Buttons
   private JButton quitButton;
   private JButton newGameButton;
   private JButton drawButton;   
   
   private boolean displayWar;
   private boolean roundStatus;
   
   public WarGUI(String s)
   {
      super(s);
      setLayout(new BorderLayout());
      Dimension d = new Dimension(800,780);
      setSize(d);
      setResizable(false);
      
      war = new WarGame();
      playerDrawCardIcon = null;
      playerWarCardIcon = null;
      computerDrawCardIcon = null;
      computerWarCardIcon = null;
      backIcon = new ImageIcon("cardPics/back.jpg");
     
      //Title Panel
      titlePanel = new JPanel(new GridLayout(3,1));
         title = new JLabel("Jacob's War Game");
         title.setFont(new Font("HELVETICA",Font.BOLD,36));
         title.setHorizontalAlignment(SwingConstants.CENTER);
      titlePanel.add(title);
         status = new JLabel("Press 'New Game' to begin.");
         status.setFont(new Font("HELVETICA",Font.PLAIN,18));
         status.setHorizontalAlignment(SwingConstants.CENTER);
      titlePanel.add(status);
         playerLabelPanel = new JPanel(new GridLayout(1,2));
            playerDrawCardLabel = new JLabel("Player's Cards");
            playerDrawCardLabel.setFont(new Font("HELVETICA",Font.PLAIN,16));
            playerDrawCardLabel.setHorizontalAlignment(SwingConstants.LEFT);
         playerLabelPanel.add(playerDrawCardLabel);
            computerDrawCardLabel = new JLabel("Computer's Cards");
            computerDrawCardLabel.setFont(new Font("HELVETICA",Font.PLAIN,16));
            computerDrawCardLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         playerLabelPanel.add(computerDrawCardLabel);
      titlePanel.add(playerLabelPanel);
         Dimension titleSize = new Dimension(1760,200);
      titlePanel.setSize(titleSize);
       
      //Game Panel
      gamePanel = new JPanel(new BorderLayout());
         playerPanel = new JPanel(new GridLayout(2,2,50,10));
            playerCardsPic = new JLabel(backIcon);
         playerPanel.add(playerCardsPic);
            playerDrawCardPic = new JLabel(playerDrawCardIcon);
         playerPanel.add(playerDrawCardPic);
            drawButton = new JButton("Draw");
            drawButton.addActionListener(new ButtonListener());
         playerPanel.add(drawButton);
            playerWarCardPic = new JLabel(playerWarCardIcon);
         playerPanel.add(playerWarCardPic);    
      gamePanel.add(playerPanel,BorderLayout.WEST);
         computerPanel = new JPanel(new GridLayout(2,2,50,10));
            computerDrawCardPic = new JLabel(computerDrawCardIcon);
         computerPanel.add(computerDrawCardPic);
            computerCardsPic = new JLabel(backIcon);
         computerPanel.add(computerCardsPic);
            computerWarCardPic = new JLabel(computerWarCardIcon);
         computerPanel.add(computerWarCardPic);
            blankLabel = new JLabel();
         computerPanel.add(blankLabel);
      gamePanel.add(computerPanel,BorderLayout.EAST);
         warCardsLabel = new JLabel("War Cards");
         warCardsLabel.setVisible(false); 
      gamePanel.add(warCardsLabel,BorderLayout.SOUTH);
      
      //Menu Panel
      menuPanel = new JPanel(new GridLayout(1,2));
         newGameButton = new JButton("New Game");
         newGameButton.addActionListener(new ButtonListener());
      menuPanel.add(newGameButton, BorderLayout.WEST);
         quitButton = new JButton("Quit");
         quitButton.addActionListener(new ButtonListener());
      menuPanel.add(quitButton, BorderLayout.EAST);
         Dimension menuSize = new Dimension(1760,200);
      menuPanel.setSize(menuSize);

      //Add Panels to Frame
      add(titlePanel,BorderLayout.NORTH);
      add(gamePanel);
      add(menuPanel,BorderLayout.SOUTH);
   }
   
   public static void main(String [] args)
   {
  
      JFrame frame = new WarGUI("WAR GAME");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.pack();
      frame.setVisible(true);
   }
   
   // gets the card image when needed
   private ImageIcon getImage(String card) 
   {
		ImageIcon cardIcon = new ImageIcon("cardPics/" + card + ".jpg");
		return cardIcon;
	}
   
   
   //class to handle button press
   public class ButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == quitButton)
            System.exit(0);
         else if (e.getSource() == drawButton)
         {
            do
            {
               
               war.drawCards();
               war.compareCards();
               status.setText(war.getMsg());
               playerDrawCardPic.setIcon(getImage(war.getCard(1).toString()));
               computerDrawCardPic.setIcon(getImage(war.getCard(2).toString()));
               if(status.getText().equals("War!"))
               {
                  playerWarCardPic.setIcon(backIcon);
                  computerWarCardPic.setIcon(backIcon);
                  status.setText("War! ");                 
               }
               else
               {
                  playerWarCardPic.setIcon(null);
                  computerWarCardPic.setIcon(null);
               }
            }while(war.gameOver());
  
         }
         else
         {
            war.reset();
            playerDrawCardPic.setIcon(null);
            computerDrawCardPic.setIcon(null);
            playerWarCardPic.setIcon(null);
            computerWarCardPic.setIcon(null);
            status.setText(war.getMsg());
         }
       
         
      }
   }
   
}
  