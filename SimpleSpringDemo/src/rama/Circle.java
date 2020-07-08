package rama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
//import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {


    private Point center;

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle: Point is: ( "+ center.getX()+","+center.getY()+")");


    }

    public Point getCenter() {
        return center;
    }


    @Resource
    public void setCenter(Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initializeCircle(){

        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroyCircle(){

        System.out.println("Destroy of Circle");
    }


}
