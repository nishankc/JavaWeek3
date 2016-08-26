package Day2;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

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

    //temp value for the employee index in the list
    private int employeeIndex = -1;
    //boolean to check if you want to create new employees or not
    private boolean createNew;

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


        prepareJList();
        //creating the panels inside the main panels
        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createEmployeeList());
        scrollPane.setPreferredSize(new Dimension(380,335));
        listPanel.add(scrollPane);
        listPanel.setVisible(false);
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

    //create list
    private void prepareJList(){

        employeeList = new JList();
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                employeeIndex = employeeList.getSelectedIndex();
                if(employees.size() > 0 && employeeIndex != -1){
                    loadEmployeeFields(employeeIndex);
                } else {
                    clearTxtFields();
                }
            }
        });


    }

    //reload list to make it dynamic
    private JList createEmployeeList(){

        DefaultListModel listModel = new DefaultListModel();

        if(employees.size() > 0){

            for(Employee e: employees){
                listModel.addElement(e);
            }
        }

        employeeList.setModel(listModel);



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

                if(createNew && employeeList.isSelectionEmpty()){
                    try {
                        //TaskProcessing.createEmployee(getFieldInfo());
                        TaskProcessing.newEmployee(getFieldInfo());

                        createEmployeeList();
                        clearTxtFields();
                    } catch (SQLException createEx){
                        JOptionPane.showMessageDialog(null, "ERROR ADDING EMPLOYEE" + System.lineSeparator() + createEx);
                    }
                } else{
                    TaskProcessing.editDetails(employeeIndex,getFieldInfo());
                    createEmployeeList();
                }
                createNew = false;//new
                employeeIndex = -1;

            }
        });

        btnPanel.add(btnUpdate);

        //btnPanel = new JPanel();
        //btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(employeeIndex >= 0) {
                    TaskProcessing.removeEmployee(employeeIndex);
                    createEmployeeList();
                    employeeIndex = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "No Employee Selected");
                }

            }
        });
        btnPanel.add(btnRemove);

        return btnPanel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if("New".equals(action)){
            clearTxtFields();
            if(employeeIndex < 0) {
                createNew = true;
            }
            listPanel.setVisible(true);
            fieldPanel.setVisible(true);

        } else if ("Exit".equals(action)){
            System.exit(0);
        } else if ("Search".equals(action)){
            String fnSearch = JOptionPane.showInputDialog("Enter first Name: ");
            employeeIndex = TaskProcessing.searchFirstName(fnSearch);
            listPanel.setVisible(true);
            fieldPanel.setVisible(true);
            if(employeeIndex != -1) {
                loadEmployeeFields(employeeIndex);
            } else {
                JOptionPane.showMessageDialog(null,"Cannot find the Employee");
            }
        }

    }

    private void clearTxtFields(){

        txtFirstName.setText("");
        txtLastName.setText("");
        txtHeight.setText("");
        txtWeight.setText("");
        txtBirthDate.setText("");
        txtSex.setText("");
        txtPosition.setText("");
        txtHireDate.setText("");

    }

    private void loadEmployeeFields(int index){

        txtFirstName.setText(employees.get(index).getFirstName());
        txtLastName.setText(employees.get(index).getLastName());
        txtHeight.setText(Short.toString(employees.get(index).getHeight()));
        txtWeight.setText(Double.toString(employees.get(index).getWeight()));
        txtBirthDate.setText(employees.get(index).getBirthDate().toString());
        txtSex.setText(employees.get(index).getSex().toString());
        txtPosition.setText(employees.get(index).getPosition());
        txtHireDate.setText(employees.get(index).getHireDate().toString());


    }

    private List<String> getFieldInfo(){
        List<String> data = new ArrayList<>();

        data.add(txtFirstName.getText());
        data.add(txtLastName.getText());
        data.add(txtHeight.getText());
        data.add(txtWeight.getText());

//        String[] stringDob = txtBirthDate.getText().split("-");
//        data.add(stringDob[0]);
//        data.add(stringDob[1]);
//        data.add(stringDob[2]);

        data.add(txtBirthDate.getText());

        data.add(txtSex.getText());
        data.add(txtPosition.getText());

//        String[] stringHireDate = txtBirthDate.getText().split("-");
//        data.add(stringHireDate[0]);
//        data.add(stringHireDate[1]);
//        data.add(stringHireDate[2]);

        data.add(txtHireDate.getText());

        return data;
    }
}
