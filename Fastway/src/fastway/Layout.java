package fastway;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


 
class Layout {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Layout(){
      prepareGUI();
   }


   private void prepareGUI(){
      mainFrame = new JFrame("Fastway");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   void showTextFieldDemo(){
      headerLabel.setText("MODE 1: TIME 2: SPEED"); 
      
      JLabel  startLabel= new JLabel("Start: ", JLabel.RIGHT);
      JLabel  endLabel = new JLabel("End: ", JLabel.CENTER);
      JLabel  modeLabel = new JLabel("MODE: ", JLabel.RIGHT);
      final JTextField startText = new JTextField(6);
      final JTextField endText = new JTextField(6);
      final JTextField modeText = new JTextField(2);

      JButton submitButton = new JButton("Submit");
      submitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {  
        	Graph g = new Graph();
        	String gStart = startText.getText();
        	String gEnd = endText.getText();
        	int Gmode = Integer.parseInt(modeText.getText());
        	if(Gmode==1) {
        		g.shortestway(Graph.MODE.SPEED, gStart, gEnd);
        	}
        	else if(Gmode==2){
        		g.shortestway(Graph.MODE.TIME, gStart, gEnd);
        	}
        	mainFrame.dispose();
         }
        
      }); 

      controlPanel.add(startLabel);
      controlPanel.add(startText);
      controlPanel.add(endLabel);       
      controlPanel.add(endText);
      controlPanel.add(modeLabel);
      controlPanel.add(modeText);
      controlPanel.add(submitButton);
      mainFrame.setVisible(true);  
   }
}
