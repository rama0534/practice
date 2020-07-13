package rama;

import dao.JdbcDaoImpl;
import model.Circle;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException,
            IllegalAccessException {


        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());

    }
}
