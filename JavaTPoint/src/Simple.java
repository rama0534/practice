import java.util.Scanner;

// Creating Simple class
class Simple {

    //Creating main method in Simple class
    public static void main(String args[]) {
        //Creating an objector instance
        Scanner myObj = new Scanner(System.in);
        Student S1 = new Student();
        String name;
        System.out.println("please enter name");
        name = myObj.nextLine();
        System.out.println(name);
        //Printing Values of the Object
        S1.display();
        //Initializing object through reference
        S1.studentId = 1;
        S1.studentName = "Rama";
        S1.display();
        S1.insertRecord(2, "Rama.N.S");
        S1.display();
    }

}
class Student{

    int studentId;//data members
    String studentName;
    // Object initialization through method
    void insertRecord(int id, String name){
        studentId = id;
        studentName = name;
    }
    void display(){
        System.out.println("Id: "+studentId+" Name: "+studentName);
    }

}

