import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
public class Quiz implements ActionListener 
{ 
    String[] questions = { 
        "Which company created Java?", 
        "Which year was Java created?", 
        "What was Java originally called?", 
        "Who is credited with creating Java?", 
        "Total JDBC drivers available is____", 
        "TCP, FTP, SMTP, Telnet are examples of?", 
        "String class is defined in which package?", 
        "Which institute is best for java coaching?", 
        "Which one among these is not a keyword?", 
        "Which one among these is not a class? " 
    }; 
    String[][] options = { 
        {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"}, 
        {"1989","1996","1972","1492"}, 
        {"Apple","Latte","Oak","Koffing"}, 
        {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerburg"}, 
        {"Two","Four","Three","Five"}, 
        {"IP Address","Socket","Protocol","MAC Address"}, 
        {"lang","Swing","Applet","awt"}, 
        {"Utek","Aptech","SSS IT","jtek"}, 
        {"class","int","get","if"}, 
        {"Swing","Actionperformed","ActionEvent","Button"} 
    }; 
    char[] answers = { 'A', 'B', 'C', 'C', 'B', 'C', 'D', 'A', 'C', 'C' }; 
    char guess; 
    char answer; 
    int index; 
    int correct_guesses =0; 
    int total_questions = questions.length; 
    int result; 
    int seconds=10; 
    JFrame f= new JFrame(); 
    JTextField textfield = new JTextField(); 
    JTextArea textarea = new JTextArea(); 
    JButton bA = new JButton(); 
    JButton bB = new JButton();  	 	
    JButton bC = new JButton();  	 	
    JButton bD = new JButton();  	 	
    JLabel ansA = new JLabel(); 
    JLabel ansB = new JLabel();  	 	
    JLabel ansC = new JLabel(); 
    JLabel ansD = new JLabel(); 
    JLabel time = new JLabel(); 
    JLabel seconds_left = new JLabel(); 
    JTextField number_right = new JTextField(); 
    JTextField percentage = new JTextField(); 
    Timer timer = new Timer(1000, new ActionListener() 
    { 
        @Override 
        public void actionPerformed(ActionEvent e) 
        { 
            seconds--; 
            seconds_left.setText(String.valueOf(seconds)); 
            if(seconds<=0) 
            { 
                displayAnswer();
            } 
        } 
    }); 
    public Quiz() { 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setSize(650,650); 
        f.getContentPane().setBackground(new Color(255,255,255)); 
        f.setLayout(null); 
        f.setResizable(false); 
        textfield.setBounds(0,0,680,90);  	 	 	
        textfield.setBackground(new Color(0,0,0));  	 	 
        textfield.setForeground(new Color(255,255,255));  	 	 	
        textfield.setFont(new Font("Playfair",Font.BOLD,32));  	 	 	
        textfield.setBorder(BorderFactory.createBevelBorder(1));  	 	 	
        textfield.setHorizontalAlignment(JTextField.CENTER);  	 	 	
        textfield.setEditable(false); 
 	 	textarea.setBounds(0,90,650,50);  	 	 	
        textarea.setLineWrap(true);  	 	 	
        textarea.setWrapStyleWord(true);  	 	 	
        textarea.setBackground(new Color(255,255,255));  	 	 	
        textarea.setForeground(new Color(0,0,204));  	 	 	
        textarea.setFont(new Font("Playfair",Font.BOLD,30));  	 	 	
        textarea.setBorder(BorderFactory.createBevelBorder(1));  	 	 	
        textarea.setEditable(false);  
 	 	bA.setBounds(30,150,100,100);  	 	 	
        bA.setFont(new Font("Playfair",Font.BOLD,30));  	 	 	
        bA.setFocusable(false); 
        bA.addActionListener(this); 
        bA.setText("A"); 
        bB.setBounds(30,250,100,100); 
        bB.setFont(new Font("Playfair",Font.BOLD,30)); 
        bB.setFocusable(false); 
        bB.addActionListener(this); 
 	 	bB.setText("B");  
 	 	bC.setBounds(30,350,100,100);  	 	 	
        bC.setFont(new Font("Playfair",Font.BOLD,30));  	 	 	
        bC.setFocusable(false);  	 	 	
        bC.addActionListener(this);  	 	 	
        bC.setText("C"); 
        bD.setBounds(30,450,100,100);  	 	 	
        bD.setFont(new Font("Playfair",Font.BOLD,30));  	 	 	
        bD.setFocusable(false);  	 	 	
        bD.addActionListener(this);  	 	 	
        bD.setText("D"); 
 	 	ansA.setBounds(175,150,400,100);  	 	 	
        ansA.setBackground(new Color(50,50,50));  	 	 	
        ansA.setForeground(new Color(0,0,0));  	 	 	
        ansA.setFont(new Font("Playfair",Font.PLAIN,30)); 
 	 	ansB.setBounds(175,250,400,100);  	 	 	
        ansB.setBackground(new Color(50,50,50));  	 	 	
        ansB.setForeground(new Color(0,0,0));  	 	 	
        ansB.setFont(new Font("Playfair",Font.PLAIN,30)); 
 	 	ansC.setBounds(175,350,400,100); 
        ansC.setBackground(new Color(50,50,50)); 
        ansC.setForeground(new Color(0,0,0)); 
        ansC.setFont(new Font("Playfair",Font.PLAIN,30)); 
        ansD.setBounds(175,450,400,100); 
        ansD.setBackground(new Color(50,50,50)); 
        ansD.setForeground(new Color(0,0,0)); 
 	 	ansD.setFont(new Font("Playfair",Font.PLAIN,30));  
 	 	seconds_left.setBounds(535,510,100,100);  	 	 	
        seconds_left.setBackground(new Color(255,255,255));  	 	 	
        seconds_left.setForeground(new Color(0,0,204));  	 	 	
        seconds_left.setFont(new Font("Playfair",Font.BOLD,60));  	 	 	
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));  	 	 	
        seconds_left.setOpaque(true); 
        seconds_left.setHorizontalAlignment(JTextField.CENTER);  	 	 	
        seconds_left.setText(String.valueOf(seconds));  
 	 	time.setBounds(535,475,100,25);  	 	 	
        time.setBackground(new Color(50,50,50));  	 	 	
        time.setForeground(new Color(0,0,0));  	 	 	
        time.setFont(new Font("Playfair",Font.PLAIN,16));  	 	 	
        time.setHorizontalAlignment(JTextField.CENTER);  	 	 	
        time.setText("timer >:D"); 
 	 	number_right.setBounds(225,225,200,100);  	 	 	
        number_right.setBackground(new Color(51,204,255));  	 	 	
        number_right.setForeground(new Color(0,0,204));  	 	 	
        number_right.setFont(new Font("Playfair",Font.BOLD,50));  	 	 	
        number_right.setBorder(BorderFactory.createBevelBorder(1));  	 	 	
        number_right.setHorizontalAlignment(JTextField.CENTER);  	 	 	
        number_right.setEditable(false); 
        percentage.setBounds(225,325,200,100); 
        percentage.setBackground(new Color(51,204,255)); 
        percentage.setForeground(new Color(0,0,204)); 
        percentage.setFont(new Font("Playfair",Font.BOLD,50)); 
        percentage.setBorder(BorderFactory.createBevelBorder(1)); 
        percentage.setHorizontalAlignment(JTextField.CENTER); 
 	 	percentage.setEditable(false); 
 	 	f.add(time); 
 	 	f.add(seconds_left); 
 	 	f.add(ansA); 
        f.add(ansB); 
 	 	f.add(ansC); 
 	 	f.add(ansD); 
 	 	f.add(bA); 
 	 	f.add(bB); 
 	 	f.add(bC); 
 	 	f.add(bD); 
 	 	f.add(textarea); 
 	 	f.add(textfield); 
 	 	f.setVisible(true);  	 	 	
        nextQuestion(); 
 	} 
    public void nextQuestion() 
 	{ 
 	 	if(index>=total_questions) 
 	    { 
 	 	    results(); 
 	 	} 
        else 
        { 
            textfield.setText("Question "+(index+1)); textarea.setText(questions[index]); ansA.setText(options[index][0]); ansB.setText(options[index][1]); ansC.setText(options[index][2]); ansD.setText(options[index][3]); timer.start(); 
        } 
    } 
    @Override public void actionPerformed(ActionEvent e) 
    { 
        bA.setEnabled(false);  	
        bB.setEnabled(false);  	
        bC.setEnabled(false);  	
        bD.setEnabled(false);  	
        if(e.getSource()==bA) 
        { 
            answer= 'A'; 
            if(answer == answers[index]) 
            { 
                correct_guesses++; 
            } 
        } 
        if(e.getSource()==bB) 
        { 
            answer= 'B'; 
            if(answer == answers[index]) 
            { 
                correct_guesses++; 
            } 
        } 
        if(e.getSource()==bC) 
        { 
            answer= 'C'; 
            if(answer == answers[index]) 
            { 
                correct_guesses++; 
            } 
        } 
        if(e.getSource()==bD) 
        { 
            answer= 'D'; 
            if(answer == answers[index]) 
            { 
                correct_guesses++; 
            } 
        } 
        displayAnswer(); 
    } 
    public void displayAnswer() 
    { 
     	timer.stop();  	
        bA.setEnabled(false);  	
        bB.setEnabled(false);  	
        bC.setEnabled(false);  	
        bD.setEnabled(false);  	
        if(answers[index] != 'A')  	
        {
            ansA.setForeground(new Color(255,0,0));
        }  	
        if(answers[index] != 'B')  	
        {
            ansB.setForeground(new Color(255,0,0));
        }  
        if(answers[index] != 'C')  	
        {
            ansC.setForeground(new Color(255,0,0));
        }  	
        if(answers[index] != 'D')  	
        {
            ansD.setForeground(new Color(255,0,0));
        } 
        Timer pause = new Timer(2000, new ActionListener() 
        { 
            @Override 
            public void actionPerformed(ActionEvent e) 
            { 
                ansA.setForeground(new Color(0,0,0));  	
                ansB.setForeground(new Color(0,0,0));  	
                ansC.setForeground(new Color(0,0,0));  	
                ansD.setForeground(new Color(0,0,0));  	
                answer = ' ';  	
                seconds=10; 
                seconds_left.setText(String.valueOf(seconds));  	
                bA.setEnabled(true);  	
                bB.setEnabled(true);  	
                bC.setEnabled(true);  	
                bD.setEnabled(true);  	
                index++; 
                nextQuestion(); 
            } 
        }); 
        pause.setRepeats(false); 
        pause.start(); 
    } 
    public void results() 
    { 
        bA.setEnabled(false);  	
        bB.setEnabled(false);  	
        bC.setEnabled(false);  	
        bD.setEnabled(false); 
        result = (int)((correct_guesses/(double)total_questions)*100);  
        textfield.setText("RESULTS!");  	
        textarea.setText("");  	
        ansA.setText("");  	
        ansB.setText(""); 
        ansC.setText("");  	
        ansD.setText(""); 
        number_right.setText("("+correct_guesses+"/"+total_questions+")");  	
        percentage.setText(result+"%"); 
        f.add(number_right); 
        f.add(percentage); 
    } 
    public static void main(String[] args) 
    { 
        new Quiz(); 
    } 
}