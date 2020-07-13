package aspect;

import model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Before("allGetters()&& allCircleMethods())")
    public void LoggingAdvice(JoinPoint joinPoint){
//        System.out.println(joinPoint.toString());
//        System.out.println(joinPoint.getTarget());
//        Circle circle = (Circle) joinPoint.getTarget();



    }


    @Before("args(name)")
    public void stringArgumentMethods( String name) {

        System.out.println("A method that takes String arguments has been called. The value is "+ name);
    }

//    @Before("allGetters())")
//    public void secondAdvices(){
//        System.out.println("Second Advice Executed");
//    }

    @Pointcut("execution(* get*())")
    public void allGetters(){

    }



//    @Pointcut("execution(* model.Circle.*(..))")
//    public void allCircleMethods(){
//
//    }

    @Pointcut("within(model.Circle)")
        public void allCircleMethods(){

        }




}
