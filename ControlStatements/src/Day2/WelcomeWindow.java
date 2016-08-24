package Day2;

import javafx.scene.paint.ColorBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by student on 24/08/2016.
 */
public class WelcomeWindow extends JFrame {

    private JPanel contentPane;
    private  JButton btnEnter;
    private  JLabel lblWelcome;
    public MainWindow mainFrame;

    public WelcomeWindow(){

        setTitle("Welcome Frame");
        setSize(800,400);
        setResizable(false);

        //centre the frame
        //setLocationRelativeTo(null); easy method not recommended


        Dimension di = getToolkit().getScreenSize();
        setLocation(di.width/2 - getWidth()/2, di.height/2-getHeight()/2);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnEnter = new JButton("Enter");
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //load MainFrame
                MainWindow mainFrame = new MainWindow();
            }
        });

        btnEnter.setBounds(360,200,70,25);
        contentPane.add(btnEnter);

        lblWelcome = new JLabel("Welcome to Employee Program");
        lblWelcome.setForeground(Color.BLUE);
        lblWelcome.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
        lblWelcome.setBounds(220,80,400,100);
        contentPane.add(lblWelcome);

        setVisible(true);

    }


}
