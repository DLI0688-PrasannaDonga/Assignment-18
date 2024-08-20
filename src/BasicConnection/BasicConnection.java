package BasicConnection;

import java.sql.Connection;

public class BasicConnection {
    public static void main(String[] args) {
 JdbcConnection jb= new JdbcConnection();
        Connection con= jb.connect_to_database("test_db", "postgres","root");

    }
}
