package SimpleQuery;

import org.postgresql.Driver;

import java.sql.*;

public class SimpleQueryMethod {
    public Connection connecting_to_db(String dbname, String user, String pass){
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
            if(con!=null){
                System.out.println("Connection established");
            }else{
                System.out.println("connection failed");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }


    //creating a database

    public void create_table(Connection con, String table_name) {
        PreparedStatement statement = null;
        try {
            String query = "CREATE TABLE " + table_name + " (empid SERIAL, name VARCHAR(20), address VARCHAR(100), PRIMARY KEY(empid))";
            statement = con.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Table created");

        }catch (Exception e){
            System.out.println(e);
        }

    }

    //insert values
    public void insert_row(Connection con, String table_name, String name, String address){
        PreparedStatement statement=null;
        try {
            String query = String.format("insert into %s(name, address) values('%s', '%s')",table_name, name, address);
            statement = con.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("row inserted");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    //fetching data

    public void select_data(Connection con, String table_name){
        PreparedStatement statement=null;
        ResultSet rs=null;
        try{
            String query=String.format("select * from %s",table_name);
            statement=con.prepareStatement(query);
            rs=statement.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
