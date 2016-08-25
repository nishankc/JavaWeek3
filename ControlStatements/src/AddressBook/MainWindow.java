package AddressBook;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import static AddressBook.generateContact.contacts;

/**
 * Created by student on 25/08/2016.
 */
public class MainWindow implements ActionListener {
    //set labels
    private JLabel lblFirstName, lblLastName, lblDob, lblHouseNumber, lblStreetName, lblCity, lblTown, lblPostCode, lblPhoneNumber, lblEmail;
    //set text fields
    private JTextField txtFirstName, txtLastName, txtDob, txtHouseNumber, txtStreetName, txtCity, txtTown, txtPostCode, txtPhoneNumber, txtEmail;
    //set buttons
    private JButton btnUpdate, btnRemove;
    //menu bar
    private JMenuBar menuBar;
    //menus for the menu bar
    private JMenu fileMenu, editMenu;
    //create menu items for new, exit and search
    private JMenuItem newMenuItem, exitMenuItem, indexMenuItem;
    //create the panels for the different elements
    private JPanel content, listPanel, fieldPanel, inputPanel, btnPanel;
    //create the list for Contacts
    private JList contactsList;

    private JList contactList;

    //temp value for the employee index in the list
    private int contactIndex = -1;
    //boolean to check if you want to create new employees or not
    private boolean createNew;


    public MainWindow() {

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(800, 400);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        WindowListener listener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(mainFrame, "Are you sure you want to exit", "Exit confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);

                if (confirm == 0) {

                    mainFrame.dispose();
                    System.exit(0);
                }

            }

        };

        //add the event listener for the pop up exit window for the mainframe
        mainFrame.addWindowListener(listener);

        //add the menu bar to the mainframe
        mainFrame.setJMenuBar(createMenu());

        //creating the panels
        content = (JPanel) mainFrame.getContentPane();
        content.setLayout(new GridLayout(1, 2, 5, 5));


        prepareJList();
        //creating the panels inside the main panels
        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createContactList());
        scrollPane.setPreferredSize(new Dimension(380, 335));
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
        mainFrame.setLocation(di.width / 2 - mainFrame.getWidth() / 2, di.height / 2 - mainFrame.getHeight() / 2);


    }

    private JMenuBar createMenu() {
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

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if("New".equals(action)){
            clearTxtFields();
            if(contactIndex < 0) {
                createNew = true;
            }
            listPanel.setVisible(true);
            fieldPanel.setVisible(true);

        } else if ("Exit".equals(action)){
            System.exit(0);
        } else if ("Search".equals(action)){
            String fnSearch = JOptionPane.showInputDialog("Enter first Name: ");
            contactIndex = TaskProcessing.searchFirstName(fnSearch);
            listPanel.setVisible(true);
            fieldPanel.setVisible(true);
            if(contactIndex != -1) {
                loadEmployeeFields(contactIndex);
            } else {
                JOptionPane.showMessageDialog(null,"Cannot find the Employee");
            }
        }

    }


    private JPanel createFieldsPanel() {

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 5, 5));

        lblFirstName = new JLabel("First Name:");
        inputPanel.add(lblFirstName);
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        lblLastName = new JLabel("Last Name:");
        inputPanel.add(lblLastName);
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        lblDob = new JLabel("Date of Birth(YYYY/MM/DD)::");
        inputPanel.add(lblDob);
        txtDob = new JTextField();
        inputPanel.add(txtDob);

        lblHouseNumber = new JLabel("Enter House Number");
        inputPanel.add(lblHouseNumber);
        txtHouseNumber = new JTextField();
        inputPanel.add(txtHouseNumber);

        lblStreetName = new JLabel("Enter a street Name:");
        inputPanel.add(lblStreetName);
        txtStreetName = new JTextField();
        inputPanel.add(txtStreetName);

        lblCity = new JLabel("Enter city: ");
        inputPanel.add(lblCity);
        txtCity = new JTextField();
        inputPanel.add(txtCity);

        lblTown = new JLabel("Enter Town: ");
        inputPanel.add(lblTown);
        txtTown = new JTextField();
        inputPanel.add(txtTown);

        lblPostCode = new JLabel("Enter PostCode");
        inputPanel.add(lblPostCode);
        txtPostCode = new JTextField();
        inputPanel.add(txtPostCode);

        lblEmail = new JLabel("Enter Email");
        inputPanel.add(lblEmail);
        txtEmail = new JTextField();
        inputPanel.add(txtEmail);

        lblPhoneNumber = new JLabel("Enter Phone Number");
        inputPanel.add(lblPhoneNumber);
        txtPhoneNumber = new JTextField();
        inputPanel.add(txtPhoneNumber);


        return inputPanel;

    }


    private void prepareJList() {

        contactList = new JList();
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                contactIndex = contactList.getSelectedIndex();
                if (contacts.size() > 0 && contactIndex != -1) {
                    loadEmployeeFields(contactIndex);
                } else {
                    clearTxtFields();
                }
            }
        });


    }

    private JList createContactList(){

        DefaultListModel listModel = new DefaultListModel();

        if(contacts.size() > 0){

            for(Contact e: contacts){
                listModel.addElement(e);
            }
        }

        contactList.setModel(listModel);



        return contactList;

    }

    private JPanel createButtonPanel(){

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(createNew && contactList.isSelectionEmpty()){
                    TaskProcessing.createContact(getFieldInfo());
                    createContactList();
                    createNew = false;
                    clearTxtFields();
                } else{
                    TaskProcessing.editDetails(contactIndex,getFieldInfo());
                    createContactList();
                }
                createNew = false;
                contactIndex = -1;


            }
        });

        btnPanel.add(btnUpdate);

        //btnPanel = new JPanel();
        //btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(contactIndex >= 0) {
                    TaskProcessing.removeContact(contactIndex);
                    createContactList();
                    contactIndex = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "No Employee Selected");
                }
            }
        });
        btnPanel.add(btnRemove);

        return btnPanel;

    }

    private void clearTxtFields(){

        txtFirstName.setText("");
        txtLastName.setText("");
        txtDob.setText("");
        txtHouseNumber.setText("");
        txtStreetName.setText("");
        txtCity.setText("");
        txtTown.setText("");
        txtPostCode.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");

    }

    private void loadEmployeeFields(int index){

        txtFirstName.setText(contacts.get(index).getPerson().getFirstName());
        txtLastName.setText(contacts.get(index).getPerson().getLastName());
        txtDob.setText(contacts.get(index).getPerson().getBirthDate().toString());
        txtHouseNumber.setText(Integer.toString(contacts.get(index).getPerson().getAddress().getHouseNumber()));
        txtStreetName.setText(contacts.get(index).getPerson().getAddress().getStreetName());
        txtCity.setText(contacts.get(index).getPerson().getAddress().getCity());
        txtTown.setText(contacts.get(index).getPerson().getAddress().getTown());
        txtPostCode.setText(contacts.get(index).getPerson().getAddress().getPostcode());
        txtEmail.setText(contacts.get(index).getEmail());
        txtPhoneNumber.setText(contacts.get(index).getPhoneNumber());


    }

    private List<String> getFieldInfo(){
        List<String> data = new ArrayList<>();

        data.add(txtFirstName.getText());
        data.add(txtLastName.getText());

        String[] stringDob = txtDob.getText().split("-");
        data.add(stringDob[0]);
        data.add(stringDob[1]);
        data.add(stringDob[2]);

        data.add(txtHouseNumber.getText());
        data.add(txtStreetName.getText());
        data.add(txtCity.getText());
        data.add(txtTown.getText());
        data.add(txtPostCode.getText());
        data.add(txtEmail.getText());
        data.add(txtPhoneNumber.getText());




        return data;
    }

}
