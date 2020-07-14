package dao;

import model.Circle;
import org.apache.derby.client.am.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Circle getCircle(int circleId) throws ClassNotFoundException, SQLException, IllegalAccessException,
            InstantiationException {


        Connection conn = null;


        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id=?");
        ps.setInt(1,circleId);

        Circle circle = null;
        ResultSet rs= ps.executeQuery();
        if(rs.next()){
            circle = new Circle(circleId, rs.getString("name"));
        }

        rs.close();
        ps.close();
        return circle;




        }


    }



