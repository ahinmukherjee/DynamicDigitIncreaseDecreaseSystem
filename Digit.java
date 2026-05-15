```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuess {

    public static void main(String args[]) {

        FrameTest ft = new FrameTest();
        ft.setVisible(true);
        ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameTest extends JFrame {

    public FrameTest() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension scrsize = kit.getScreenSize();

        int w = scrsize.width;
        int h = scrsize.height;

        setSize(450, 400);
        setLocation(w / 6, h / 6);

        setTitle("Number Guess Game");

        setResizable(false);

        FramePanels fp = new FramePanels();

        add(fp);
    }
}

class FramePanels extends JPanel implements ActionListener {

    JLabel title, label, result;

    JTextField numberField;

    JButton clickButton, restartButton, exitButton;

    JTextArea historyArea;

    int number;

    int attempts = 0;

    int maxAttempts = 5;

    FramePanels() {

        setLayout(null);

        setBackground(new Color(240, 248, 255));

        title = new JLabel("Guess The Number");

        title.setHorizontalAlignment(JLabel.CENTER);

        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        title.setForeground(new Color(0, 70, 140));

        title.setBounds(70, 20, 280, 30);

        add(title);

        label = new JLabel("Enter Number:");

        label.setFont(new Font("Segoe UI", Font.BOLD, 15));

        label.setBounds(30, 80, 120, 25);

        add(label);

        numberField = new JTextField();

        numberField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        numberField.setBounds(160, 80, 150, 30);

        add(numberField);

        clickButton = new JButton("Click Me!");

        clickButton.setBounds(30, 130, 110, 45);

        clickButton.setBackground(new Color(0, 120, 215));

        clickButton.setForeground(Color.WHITE);

        add(clickButton);

        restartButton = new JButton("Restart");

        restartButton.setBounds(160, 130, 100, 45);

        add(restartButton);

        exitButton = new JButton("Exit");

        exitButton.setBounds(280, 130, 80, 45);

        exitButton.setBackground(Color.BLACK);

        exitButton.setForeground(Color.WHITE);

        add(exitButton);

        result = new JLabel("Result:");

        result.setFont(new Font("Segoe UI", Font.BOLD, 14));

        result.setBounds(30, 190, 350, 25);

        add(result);

        historyArea = new JTextArea();

        historyArea.setEditable(false);

        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane sp = new JScrollPane(historyArea);

        sp.setBounds(30, 230, 370, 100);

        add(sp);

        clickButton.addActionListener(this);

        restartButton.addActionListener(this);

        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                System.exit(0);
            }
        });

        startGame();
    }

    public void startGame() {

        number = new Random().nextInt(100) + 1;

        attempts = 0;

        numberField.setText("");

        historyArea.setText(
                "Attempts Left 5 -> New Game Start\n\n");

        result.setText("Enter Number");

        numberField.setEnabled(true);

        clickButton.setEnabled(true);
    }

    public void checkGuess() {

        try {

            int guess = Integer.parseInt(
                    numberField.getText());

            attempts++;

            int left = maxAttempts - attempts;

            if (guess < number) {

                historyArea.append(
                        "Attempts Left " + left +
                        " -> Too Low! Your entered number is: "
                        + guess + "\n");
            }

            else if (guess > number) {

                historyArea.append(
                        "Attempts Left " + left +
                        " -> Too High! Your entered number is: "
                        + guess + "\n");
            }

            else {

                historyArea.append(
                        "Attempts Left " + left +
                        " -> Correct! Number is: "
                        + guess + "\n");

                result.setText("You Win!");

                clickButton.setEnabled(false);

                numberField.setEnabled(false);

                return;
            }

            if (attempts >= maxAttempts) {

                historyArea.append(
                        "\nAttempts Left 0 -> Game Over. " +
                        "Correct Number was "
                        + number);

                result.setText("Game Over!");

                clickButton.setEnabled(false);

                numberField.setEnabled(false);
            }

            numberField.setText("");
        }

        catch (Exception ex) {

            result.setText("Enter Valid Number!");
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clickButton) {

            checkGuess();
        }

        if (ae.getSource() == restartButton) {

            startGame();
        }
    }
}
```
