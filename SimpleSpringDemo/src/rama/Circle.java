package rama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
//import org.springframework.beans.factory.annotation.Required;
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {


    private Point center;
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private MessageSource messageSource;

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.circle", null,"Default Drawing Greeting", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()},
                "Default point Greeting", null));
//        System.out.println("Circle: Point is: ( "+ center.getX()+","+center.getY()+")");
        System.out.println(this.messageSource.getMessage("greeting", null,"Default Greeting", null));
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);





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


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;

    }
}
