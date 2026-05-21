import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class NumberCountingUsingButtons{
	public static void main(String args[]){
		SampleFrame sf= new SampleFrame();
		sf.setVisible(true);
		sf.setDefaultCloseOperation(0);	
	}
}

class SampleFrame extends JFrame{
	public SampleFrame(){
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension srcSize= kit.getScreenSize();
		int w= srcSize.width;
		int h= srcSize.height;
		setSize(500,300);
		setLocation(w/5, h/8);
		setResizable(false);
		setTitle("Counter");
		FramePanel fp = new FramePanel();
		add(fp);
	}
}

class FramePanel extends JPanel implements ActionListener {
	public void paintComponent(Graphics g){
        		super.paintComponent(g);
          		setBackground(new Color(240, 248, 255));
          	}

	JLabel title1, title2, label1, label2;
	JButton increase, decrease, reset, exit;
	int count=0;	
	FramePanel(){
		setLayout(null);
		Font titleFont=new Font("Segoe UI", Font.BOLD, 18);
		title1=new JLabel("Press Increase button value is increase");
		title2=new JLabel("Press Decrease button value is decrease");

		title1.setFont(titleFont);
		title2.setFont(titleFont);

		title1.setBounds(10,20,400,30);
		title2.setBounds(10,50,400,30);
		add(title1);
		add(title2);

		label1=new JLabel("Your value is: ");
		label1.setFont(new Font("Segoe UI", Font.BOLD, 19));
		label1.setBounds(50,100,150,30);
		add(label1);

		label2=new JLabel("");
		label2.setBounds(190,100,150,30);
		label2.setFont(new Font("Segoe UI", Font.BOLD, 19));
		label2.setText(String.valueOf(count));
		label2.setOpaque(true);
		add(label2);

		increase= new JButton("Increase");
		increase.setFont(new Font("Segoe UI", Font.BOLD, 15));
		increase.setBackground(new Color(0, 153, 76));
		increase.setForeground(Color.WHITE);
		increase.setFocusPainted(false);
		increase.setBounds(20,150,100,45);
		add(increase);

		decrease= new JButton("Decrease");
		decrease.setFont(new Font("Segoe UI", Font.BOLD, 15));
		decrease.setBackground(new Color(220, 53, 69));
		decrease.setForeground(Color.WHITE);
		decrease.setFocusPainted(false);
		decrease.setBounds(140,150,100,45);
		add(decrease);

		reset= new JButton("Reset");
		reset.setFont(new Font("Segoe UI", Font.BOLD, 15));
		reset.setBackground(new Color(255, 193, 7));
		reset.setForeground(Color.BLACK);
		reset.setBounds(260,150,100,45);
		add(reset);
		
		exit= new JButton("Exit");
		exit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		exit.setBackground(new Color(52, 58, 64));
		exit.setForeground(Color.WHITE);
		exit.setBounds(380,150,100,45);
		add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
				}
		});

		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				count = 0;
				label2.setText(String.valueOf(count));
				}
		});
	
		increase.addActionListener(this);
		decrease.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae){
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
