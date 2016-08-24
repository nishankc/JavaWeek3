package Day2;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

import static Day2.generatePeople.employees;


/**
 * Created by student on 24/08/2016.
 */
public class MainWindow implements ActionListener{
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblHeight;
    private JLabel lblWeight;
    private JLabel lblBirthDate;
    private JLabel lblSex;
    private JLabel lblPosition;
    private JLabel lblHireDate;

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JTextField txtBirthDate;
    private JTextField txtSex;
    private JTextField txtPosition;
    private JTextField txtHireDate;

    private JButton btnUpdate;
    private JButton btnRemove;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuItem newMenuItem, exitMenuItem, indexMenuItem;

    private JPanel content, listPanel, fieldPanel, inputPanel, btnPanel;


    private JList employeeList;

    public MainWindow() {

        JFrame mainFrame = new JFrame("Employee Database");
        mainFrame.setSize(800,400);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);





        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int confirm = JOptionPane.showOptionDialog(mainFrame, "Are you sure you want to exit", "Exit confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);

                if(confirm == 0){

                    mainFrame.dispose();
                    System.exit(0);
                }

            }
        };

        mainFrame.addWindowListener(l);

        //add the menu bar
        mainFrame.setJMenuBar(createMenu());

        //creating the panels
        content = (JPanel) mainFrame.getContentPane();
        content.setLayout(new GridLayout(1,2,5,5));

        //creating the panels inside the main panels
        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createEmployeeList());
        scrollPane.setPreferredSize(new Dimension(380,335));
        listPanel.add(scrollPane);
        content.add(listPanel);

        //insert the panel with labels and text fields for user input
        fieldPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Employee Details");
        fieldPanel.setBorder(title);
        fieldPanel.setVisible(false);

        content.add(fieldPanel);
        fieldPanel.add(createFieldsPanel(), BorderLayout.CENTER);

        //adding the buttons to the panel on the right
        fieldPanel.add(createButtonPanel(), BorderLayout.SOUTH);





        mainFrame.setVisible(true);

        Dimension di = mainFrame.getToolkit().getScreenSize();
        mainFrame.setLocation(di.width/2 - mainFrame.getWidth()/2, di.height/2-mainFrame.getHeight()/2);


    }


    private JMenuBar createMenu(){
        menuBar = new JMenuBar();

        //File menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newMenuItem = new JMenuItem("New");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_D);
        indexMenuItem = new JMenuItem("Search");
        indexMenuItem.setMnemonic(KeyEvent.VK_S);
        indexMenuItem.addActionListener(this);
        editMenu.add(indexMenuItem);

        menuBar.add(editMenu);


        return menuBar;
    }

    private JList createEmployeeList(){

        employeeList = new JList(employees.toArray());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return employeeList;

    }

    private JPanel createFieldsPanel(){

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2,5,5));

        lblFirstName = new JLabel("First Name:");
        inputPanel.add(lblFirstName);
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        lblLastName = new JLabel("Last Name:");
        inputPanel.add(lblLastName);
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        lblHeight = new JLabel("Height:");
        inputPanel.add(lblHeight);
        txtHeight = new JTextField();
        inputPanel.add(txtHeight);

        lblWeight = new JLabel("Weight: ");
        inputPanel.add(lblWeight);
        txtWeight = new JTextField();
        inputPanel.add(txtWeight);

        lblBirthDate = new JLabel("Date of Birth(YYYY/MM/DD): ");
        inputPanel.add(lblBirthDate);
        txtBirthDate = new JTextField();
        inputPanel.add(txtBirthDate);

        lblSex = new JLabel("Enter Sex(M/F): ");
        inputPanel.add(lblSex);
        txtSex = new JTextField();
        inputPanel.add(txtSex);

        lblPosition = new JLabel("Enter Position: ");
        inputPanel.add(lblPosition);
        txtPosition = new JTextField();
        inputPanel.add(txtPosition);

        lblHireDate = new JLabel("Hire Date (YYYY/MM/DD): ");
        inputPanel.add(lblHireDate);
        txtHireDate = new JTextField();
        inputPanel.add(txtHireDate);



        return inputPanel;

    }

    private JPanel createButtonPanel(){

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

        btnPanel.add(btnUpdate);

        //btnPanel = new JPanel();
        //btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnPanel.add(btnRemove);

        return btnPanel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if("New".equals(action)){

            fieldPanel.setVisible(true);

        } else if ("Exit".equals(action)){
            System.exit(0);
        }

    }

    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtHeight() {
        return txtHeight;
    }

    public JTextField getTxtWeight() {
        return txtWeight;
    }

    public JTextField getTxtBirthDate() {
        return txtBirthDate;
    }

    public JTextField getTxtSex() {
        return txtSex;
    }

    public JTextField getTxtPosition() {
        return txtPosition;
    }

    public JTextField getTxtHireDate() {
        return txtHireDate;
    }

    public JPanel getInputPanel(){ return inputPanel;}
}
