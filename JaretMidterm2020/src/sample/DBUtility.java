package sample;

/*
Shen Han 100088024
 */
import java.sql.*;

public class DBUtility {

   Connection connection = null;

    /**
     * Might need to change dbName to F20COMP1011Test1 instead, see if this works
     */
     String dbName = "F20COMP1011Test1";
   //String dbName = "raceResults";
    /** Might need to change this to the username set in the sql "student" or "student@localhost, see if this works
     */
     String user = "student";
    //String dbUser = "root";
    /** Might need to change this to the password set in the sql "student", see if this works
     */
   String password = "student";

    public Connection getConnection() {

        try {

            // connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/TESTING1", user,password);

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/F20COMP1011Test1" , user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
