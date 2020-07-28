package com.rama.hellocontroller;
import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {

    public void setAsText(String studentName)throws IllegalArgumentException{
        if(studentName.contains("Mr.") || studentName.contains("Ms.")  ){
            setValue(studentName);
        }else {
            studentName = "Ms."+studentName;
            setValue(studentName);
        }
    }
}
