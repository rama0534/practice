package rama.springdemo;

public class Triangle {


    private Point pointA;
    private Point pointb;
    private Point pointc;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointb() {
        return pointb;
    }

    public void setPointb(Point pointb) {
        this.pointb = pointb;
    }

    public Point getPointc() {
        return pointc;
    }

    public void setPointc(Point pointc) {
        this.pointc = pointc;
    }

    public void draw(){

        System.out.println("Point A = (" +getPointA().getX()+","+getPointA().getY()+")");
        System.out.println("Point B = (" +getPointb().getX()+","+getPointb().getY()+")");
        System.out.println("Point C = (" +getPointc().getX()+","+getPointc().getY()+")");

}






}
