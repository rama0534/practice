package rama;

import dao.HibernateDaoImpl;
import dao.JdbcDaoImpl;
import dao.SimpleJdbcDaoImpl;
import model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

//        Circle circle = null;
//        try {
//            circle = dao.getCircle(1);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//        System.out.println(circle.getName());
//       dao.insertCircle(new Circle(5,"Fifth Circle"));
//        System.out.println(dao.getAllCircles().size());
//        dao.createTraiangleTable();
        System.out.println(dao.getCircleCount());

    }
}
