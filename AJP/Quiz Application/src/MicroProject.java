import java.awt.*;
import java.awt.event.*;
//import javax.swing.JOptionPane; 
class QuizLog extends Frame implements ActionListener 
{ 
    Font titleFont     = new Font("Times new roman",Font.BOLD|Font.ITALIC,35);
	Font otherTextFont = new Font("Times new roman",Font.BOLD,20);
    Font buttonFont    = new Font("Times new roman",Font.BOLD|Font.ITALIC,20);
	
	Color bgColor = new Color(13, 13, 12);
	Color txtColor = new Color(201, 55, 6);
	Color titleColor = new Color(214, 57, 4);
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	Label title = new Label("Quiz Login",Label.CENTER);
	Label uName = new Label("Enter user name :",Label.RIGHT);
	Label pass  = new Label("Enter password :",Label.RIGHT);
	
	TextField uNameTxt = new TextField(20);
	TextField passTxt  = new TextField(20);
	
	Button submit = new Button("Let's Go !!!!");
	
	QuizLog(String titleName){
        setSize(600,400);
        setVisible(true);
        setTitle(titleName);
		setLayout(new GridBagLayout());
		title.setFont(titleFont);
		setFont(otherTextFont);
		title.setForeground(titleColor);
		setBackground(bgColor);
		setForeground(txtColor);
		submit.setForeground(titleColor);
        submit.setFont(buttonFont);
		
		passTxt.setEchoChar('*');
		
		gbc.insets = new Insets(50,50,50,50);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		add(title,gbc);
		
		gbc.insets = new Insets(0,0,20,0);//TOP LEFT BOTTOM RIGHT
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(uName,gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(uNameTxt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(pass,gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(passTxt,gbc);
		
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		add(submit,gbc);

        submit.addActionListener(this);
	}
    public void actionPerformed(ActionEvent e) { 
 	    //if(uNameTxt.getText()=="Admin"&&passTxt.getText()=="admin123"){
            new Quiz();
        //}
        //else{
            //JOptionPane.showMessageDialog(null,"Please Enter Correct Username or Password!!!"); 
            //System.out.println(uNameTxt.getText());
            //System.out.println(passTxt.getText());
 	 	 	//passTxt.setText(""); 
            //uNameTxt.setText("");
        //}
    } 
    public static void main(String args[]) 
    { 
 	    new QuizLog("Quiz Login"); 
    }
}
