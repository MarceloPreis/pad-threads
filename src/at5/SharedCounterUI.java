package at5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SharedCounterUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel counterLabel;
    private SharedCounter sharedCounter;

    public SharedCounterUI() {
        setTitle("Contador Compartilhado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(contentPane);

        sharedCounter = new SharedCounter();
        counterLabel = new JLabel("Contador: " + sharedCounter.getCounter());
        contentPane.add(counterLabel);

        JButton incrementButton = new JButton("Incrementar");
        incrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sharedCounter.increment();
                counterLabel.setText("Contador: " + sharedCounter.getCounter());
            }
        });
        contentPane.add(incrementButton);

        JButton decrementButton = new JButton("Decrementar");
        decrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sharedCounter.decrement();
                counterLabel.setText("Contador: " + sharedCounter.getCounter());
            }
        });
        contentPane.add(decrementButton);
    }

}
