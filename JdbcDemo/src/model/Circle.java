package model;

import javax.persistence.Entity;

@Entity
public class Circle {

    @id
    private int id;
    private String name;

    public Circle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Circle(int circleId, String name){
        setId(circleId);
        setName(name);
    }
}
