
import java.sql.*;

public class databaseConnection {
    public static void main(String args[]) throws Exception{

        //System.out.println("hi");

//        String url= "jdbc:mysql://localhost:3306/gymtraining";
        String url = "jdbc:mysql://localhost:3306/gymtraining?useSSL=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "Rama1234";
        String query = "select emailid from gymtraining.users";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        String name = rs.getString("emailid");
        System.out.println(name);

        st.close();
        con.close();



    }
}
