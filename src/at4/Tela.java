package at4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;


public class Tela extends JFrame {    
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel labelContador1;
    public JLabel labelContador2;
    private Thread t1;
    private Thread t2;

    public Tela() {
    	setTitle("Tela com Contador Thread");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(contentPane);

        labelContador1 = new JLabel("Contador 1: 0");
        
        Counter counter1 = new Counter(0, labelContador1);
        t1 = new Thread(counter1);

        JButton btnIniciar1 = new JButton("Iniciar 1");
        btnIniciar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.isAlive()) {
                    counter1.counter = 0;
                    t1 = new Thread(counter1);
                } 
                    
                t1.start();
            }
        });
        contentPane.add(btnIniciar1);

        JButton btnPausar1 = new JButton("Pausar 1");
        btnPausar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter1.pause();
            }
        });
        contentPane.add(btnPausar1);

        JButton btnEncerrar1 = new JButton("Encerrar 1");
        btnEncerrar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter1.stop();
            }
        });
        contentPane.add(btnEncerrar1);
        contentPane.add(labelContador1);


        // Nova linha para o segundo contador
        labelContador2 = new JLabel("Contador 2: 0");
        
        Counter counter2 = new Counter(0, labelContador2);
        t2 = new Thread(counter2);

        JButton btnIniciar2 = new JButton("Iniciar 2");
        btnIniciar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t2.isAlive()) {
                    counter2.counter = 0;
                    t2 = new Thread(counter2);
                } 
                    
                t2.start();
            }
        });
        contentPane.add(btnIniciar2);

        JButton btnPausar2 = new JButton("Pausar 2");
        btnPausar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter2.pause();
            }
        });
        contentPane.add(btnPausar2);

        JButton btnEncerrar2 = new JButton("Encerrar 2");
        btnEncerrar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter2.stop();
            }
        });
        contentPane.add(btnEncerrar2);
        contentPane.add(labelContador2);
    }
}
