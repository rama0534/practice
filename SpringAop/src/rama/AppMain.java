package rama;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ShapeService;

public class AppMain {

    public static void main(String[]args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        shapeService.getCircle().setName("Dummy name");

//        System.out.println(shapeService.getCircle().getName());

    }


}
