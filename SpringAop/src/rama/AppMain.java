package rama;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FactoryService;
import service.ShapeService;

public class AppMain {

    public static void main(String[]args){

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        FactoryService forctoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) forctoryService.getBean("shapeService");
        shapeService.getCircle();

//        System.out.println(shapeService.getCircle().getName());

    }


}
