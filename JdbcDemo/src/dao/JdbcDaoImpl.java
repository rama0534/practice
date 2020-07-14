package dao;

import model.Circle;
import org.apache.derby.client.am.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
        public int getCircleCount(){
        String sql = "SELECT COUNT(*) FROM CIRCLE";
//        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate.queryForObject(sql, Integer.class);
        }


        public String getCircleName(int circleId){

            String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
            return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);


        }

//        public Circle getCircleforId(int circleId){
//
//            String sql = "SELECT * FROM CIRCLE WHERE ID=?";
//             jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
//
//
//        }


    }



