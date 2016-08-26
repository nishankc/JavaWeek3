package Day2;
import AddressBook.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 25/08/2016.
 */
public class employeeDB {

    List<Employee> employees = new ArrayList<>();
    List<String> data = new ArrayList<>();

    static Connection con;
    static Statement statement = null;
    static ResultSet rs = null;
    static ResultSetMetaData metaData;
    static int rowCount = 0;

    String userName = "root";
    String password = "Password100";
    String url = "jdbc:mysql://localhost:3306/augustdpp?UseSSL=false";

    public  employeeDB() throws Exception{
        //load driver
        Class.forName("com.mysql.jdbc.Driver");

        //connect to augustdpp
        con = DriverManager.getConnection(url,userName,password);


    }

    public void queryAll() throws SQLException{

        statement = con.createStatement();
        rs = statement.executeQuery("SELECT * from employee");
        metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()){
            for(int i = 2; i <= columnCount; i++){
                data.add(rs.getString(i));

            }
            TaskProcessing.createEmployee(data);
            data.clear();
            rowCount++;

        }
    }

    public void addEmployee(List<String> data) throws SQLException{

        PreparedStatement statement = con.prepareStatement("INSERT INTO employee(firstname,lastname,height,weight,birthday,sextype,position,hiredate) VALUES (?,?,?,?,?,?,?,?)");

        statement.setString(1,data.get(0));
        statement.setString(2,data.get(1));
        statement.setInt(3,Integer.parseInt(data.get(2)));
        statement.setDouble(4,Double.parseDouble(data.get(3)));
        statement.setDate(5,Date.valueOf(data.get(4)));
        statement.setString(6,data.get(5));
        statement.setString(7,data.get(6));
        statement.setDate(8,Date.valueOf(data.get(7)));

        statement.executeUpdate();
        statement.close();

    }

}
