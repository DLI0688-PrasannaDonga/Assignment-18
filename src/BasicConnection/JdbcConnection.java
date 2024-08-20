package BasicConnection;

import com.sun.source.tree.BreakTree;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

    public Connection connect_to_database(String dbname, String username, String password){
        Connection con=null;
        try {
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, username,password);
            if(con!=null){
                System.out.println("connection established");
            }
            else{
                System.out.println("connection failed");
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return con;
    }

}
