package rama.springdemo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

    public static void main(String args[]){

//        Triangle triangle = new Triangle();
//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//        Triangle triangle = (Triangle) factory.getBean("triangle");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) context.getBean("triangle-alias");
        triangle.draw();


    }
}
