package electricity.billing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
    Connection connection;
    Statement statement;

    DataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system ","root", "Parichay1234");
            statement= connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
