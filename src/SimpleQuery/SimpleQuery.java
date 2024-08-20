package SimpleQuery;

import java.sql.Connection;

public class SimpleQuery {
    public static void main(String[] args) {
        SimpleQueryMethod sq= new SimpleQueryMethod();
        Connection con=sq.connecting_to_db(" company_db", "postgres", "root");
       // sq.create_table(con, "employees");
        //sq.insert_row(con, "employees", "john", "USA");
        sq.select_data(con,"employees");

    }
}
