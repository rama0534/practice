package dao;

import model.Circle;
import org.apache.derby.client.am.SqlException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDaoImpl {


    public Circle getCircle(int circlId) throws ClassNotFoundException, SQLException, IllegalAccessException,
            InstantiationException {


        Connection conn = null;
        String  driver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(("jdbc:derby://localhost:1527/db"));
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id=?");
        ps.setInt(1,circlId);

        Circle circle = null;
        ResultSet rs= ps.executeQuery();
        if(rs.next()){
            circle = new Circle(circlId, rs.getString("name"));
        }

        rs.close();
        ps.close();
        return circle;




        }


    }



