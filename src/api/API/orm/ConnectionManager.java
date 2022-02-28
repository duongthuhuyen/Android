package api.API.orm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/beanikaa", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getCause().toString());
            return null;
        }
    }
}
