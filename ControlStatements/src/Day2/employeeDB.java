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
        Class.forName("come.mysql.jdbc.Driver");

        //connect to augustdpp
        con = DriverManager.getConnection(url,userName,password);


    }

    public List<String> queryAll() throws Exception{

        statement = con.createStatement();
        rs = statement.executeQuery("SELECT * from employee");
        int columnCount = metaData.getColumnCount();

        while (rs.next()){
            for(int i = 1; i <= columnCount; i++){
                data.add(rs.getString(i));

            }
            TaskProcessing.printAll(data);
        }
    }

}
