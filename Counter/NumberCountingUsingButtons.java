import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberCountingUsingButtons{
	public static void main(String args[]){
		SampleFrame sf= new SampleFrame();
		sf.setVisible(true);
		sf.setDefaultCloseOperation(3);	
	}
}

class SampleFrame extends JFrame{
	public SampleFrame(){
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension srcSize= kit.getScreenSize();
		int w= srcSize.width;
		int h= srcSize.height;
		setSize(300,400);
		setLocation(w/6, h/5);
		setResizable(false);
		setTitle("Counter");
		FramePanel fp = new FramePanel();
        add(fp);
	}
}

class FramePanel extends JPanel implements ActionListener {
	public void paintComponent(Graphics g){
        		super.paintComponent(g);
          		setBackground(new Color(255, 144, 255));
          	}

	JLabel title1, title2, label1, label2;
	JButton increase, decrease, exit;
	int count=0;	
	FramePanel(){
		setLayout(null);
		title1=new JLabel("Press Increase button value is increase");
		title2=new JLabel("Press Decrease button value is decrease");
		title1.setBounds(10,20,250,30);
		title2.setBounds(20,20,250,30);
		add(title1);
		add(title2);

		label1=new JLabel("Your value is: ");
		label1.setBounds(30,50,300,30);
		add(label1);

		label2=new JLabel("");
		label2.setBounds(30,50,400,30);
		label2.setText(String.valueOf(count));
		add(label2);

		increase= new JButton("Increase");
		increase.setBounds(30,400,100,45);
		add(increase);

		decrease= new JButton("Decrease");
		decrease.setBounds(150,400,100,45);
		add(decrease);

		exit= new JButton("Exit");
		exit.setBounds(100,450,65,45);
		add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
				}
		});
	
		increase.addActionListener(this);
		decrease.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae){
		//int n=Integer.parseInt(no);
		if(ae.getSource()==increase){
			count++;
			label2.setText(String.valueOf(count));
		}
		if(ae.getSource()==decrease){
			count--;
			label2.setText(String.valueOf(count));
		}
	}
    
}

// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;
// import java.util.Random;

// public class GuessNumberWithHistory {

//     public static void main(String args[]) {

//         FrameTest ft = new FrameTest();
//         ft.setVisible(true);
//         ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
// }

// class FrameTest extends JFrame {

//     public FrameTest() {

//         Toolkit kit = Toolkit.getDefaultToolkit();
//         Dimension scrsize = kit.getScreenSize();

//         int w = scrsize.width;
//         int h = scrsize.height;

//         setSize(500, 500);
//         setLocation(w / 6, h / 6);

//         setTitle("Number Guess Game");

//         setResizable(false);

//         FramePanels fp = new FramePanels();

//         add(fp);
//     }
// }

// class FramePanels extends JPanel implements ActionListener {

//     JLabel title, label, result;

//     JTextField numberField;

//     JButton clickButton, restartButton, exitButton;

//     JTextArea historyArea;

//     int number;

//     int attempts = 0;

//     int maxAttempts = 5;

//     FramePanels() {

//         setLayout(null);

//         setBackground(new Color(240, 248, 255));

//         title = new JLabel("Guess The Number");

//         title.setHorizontalAlignment(JLabel.CENTER);

//         title.setFont(new Font("Segoe UI", Font.BOLD, 24));

//         title.setForeground(new Color(0, 70, 140));

//         title.setBounds(70, 20, 280, 30);

//         add(title);

//         label = new JLabel("Enter Number:");

//         label.setFont(new Font("Segoe UI", Font.BOLD, 15));

//         label.setBounds(30, 80, 120, 25);

//         add(label);

//         numberField = new JTextField();

//         numberField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

//         numberField.setBounds(160, 80, 150, 30);

//         add(numberField);

//         clickButton = new JButton("Click Me!");

//         clickButton.setBounds(30, 130, 110, 45);

//         clickButton.setBackground(new Color(0, 120, 215));

//         clickButton.setForeground(Color.WHITE);

//         add(clickButton);

//         restartButton = new JButton("Restart");

//         restartButton.setBounds(160, 130, 100, 45);

//         add(restartButton);

//         exitButton = new JButton("Exit");

//         exitButton.setBounds(280, 130, 80, 45);

//         exitButton.setBackground(Color.BLACK);

//         exitButton.setForeground(Color.WHITE);

//         add(exitButton);

//         result = new JLabel("Result:");

//         result.setFont(new Font("Segoe UI", Font.BOLD, 14));

//         result.setBounds(30, 190, 350, 25);

//         add(result);

//         historyArea = new JTextArea();

//         historyArea.setEditable(false);

//         historyArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

//         JScrollPane sp = new JScrollPane(historyArea);

//         sp.setBounds(30, 230, 450, 200);

//         add(sp);

//         clickButton.addActionListener(this);

//         restartButton.addActionListener(this);

//         exitButton.addActionListener(new ActionListener() {

//             public void actionPerformed(ActionEvent ae) {

//                 System.exit(0);
//             }
//         });

//         startGame();
//     }

//     public void startGame() {

//         number = new Random().nextInt(100) + 1;

//         attempts = 0;

//         numberField.setText("");

//         historyArea.setText(
//                 "Attempts Left 5 -> New Game Start\n\n");

//         result.setText("Enter Number");

//         numberField.setEnabled(true);

//         clickButton.setEnabled(true);
//     }

//     public void checkGuess() {

//         try {

//             int guess = Integer.parseInt(
//                     numberField.getText());

//             attempts++;

//             int left = maxAttempts - attempts;

//             if (guess < number) {

//                 historyArea.append(
//                         "Attempts Left " + left +
//                         " -> Too Low! Your entered number is: "
//                         + guess + "\n");
//             }

//             else if (guess > number) {

//                 historyArea.append(
//                         "Attempts Left " + left +
//                         " -> Too High! Your entered number is: "
//                         + guess + "\n");
//             }

//             else {

//                 historyArea.append(
//                         "Attempts Left " + left +
//                         " -> Correct! Number is: "
//                         + guess + "\n");

//                 result.setText("You Win!");

//                 clickButton.setEnabled(false);

//                 numberField.setEnabled(false);

//                 return;
//             }

//             if (attempts >= maxAttempts) {

//                 historyArea.append(
//                         "\nAttempts Left 0 -> Game Over. " +
//                         "Correct Number was "
//                         + number);

//                 result.setText("Game Over!");

//                 clickButton.setEnabled(false);

//                 numberField.setEnabled(false);
//             }

//             numberField.setText("");
//         }

//         catch (Exception ex) {

//             result.setText("Enter Valid Number!");
//         }
//     }

//     public void actionPerformed(ActionEvent ae) {

//         if (ae.getSource() == clickButton) {

//             checkGuess();
//         }

//         if (ae.getSource() == restartButton) {

//             startGame();
//         }
//     }
// }

// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

// public class CountWordCharacterAndIncludingSpaces{
// 	public static void main(String args[]){
// 		FrameTest ft= new FrameTest();
// 		ft.setVisible(true);
// 		ft.setDefaultCloseOperation(3);   	
// 	} 
// }   
    
// class FrameTest extends JFrame{
// 	public FrameTest(){
// 		Toolkit kit = Toolkit.getDefaultToolkit();
// 		Dimension scrsize = kit.getScreenSize();
// 		int w = scrsize.width;
// 		int h = scrsize.height;
// 		setSize(600,500);
// 		setLocation(w/6, h/6);
// 		setTitle("Game");
// 		setResizable(false);
// 		FramePanels fp = new FramePanels();
// 		add(fp);
// 	}
// } 
    
// class FramePanels extends JPanel implements ActionListener{
// 	JLabel label1, label2, label3;
// 	JTextArea area;
// 	JButton n1, n2, n3, exit;
// 	FramePanels(){
// 		setLayout(null);
// 		label1=new JLabel("Label1");
// 		label2=new JLabel("Label2");
// 		label3=new JLabel("Label3");

// 		label1.setBounds(20,10,180,25);
// 		label2.setBounds(20,30,250,25);
// 		label3.setBounds(20,50,450,25);

// 		add(label1);
// 		add(label2);
// 		add(label3);

// 		area= new JTextArea();
// 		area.setBounds(20,90,450,300);
// 		add(area);

// 		n1= new JButton("Word count");
// 		n1.setBounds(10,400,100,50);
// 		add(n1);
		
// 		n2= new JButton("Character count");
// 		n2.setBounds(120,400,130,50);
// 		add(n2);

// 		n3= new JButton("Character count with spaces");
// 		n3.setBounds(260,400,170,50);
// 		add(n3);
		
// 		exit= new JButton("Exit");
// 		exit.setBounds(450,400,90,50);
// 		add(exit);

// 		exit.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent av){
// 				System.exit(0);
// 			}
// 		});
		
// 		n1.addActionListener(this);
// 		n2.addActionListener(this);
// 		n3.addActionListener(this);
// 	}

// 	public void actionPerformed(ActionEvent av){
// 		String s=area.getText();
// 		String words[]=s.split("\\s");

// 		int letters=s.replace(" ","").length();
// 		int spaces=s.length()-letters;

// 		if(area.equals("")){
// 			label1.setText("Plz enter text");
// 			label2.setText("Plz enter text");
// 			}
		
// 		if(av.getSource()==n1){
// 			label1.setText("The number of words is: "+words.length);
// 			}
// 		if(av.getSource()==n2){
// 			label2.setText("The number of characters is: "+s.length());
// 			}
// 		if(av.getSource()==n3){
// 			label3.setText("The number of characters with spaces is: "+letters+" (letters) + "+spaces+" (spaces) = " +s.length());
// 			}
// 	}
// }
