package com.rama.hellocontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

    private String ListofValidHobees;

    @Override
    public void initialize(IsValidHobby isValidHobby){

        this.ListofValidHobees = isValidHobby.ListofValidHobbies();
    }

    public boolean isValid(String studentHobby, ConstraintValidatorContext ctx){

        if (studentHobby == null){
            return false;

        }
        if (studentHobby.matches("Music|Football|Cricket|Hockey")){
            return true;
        }else {
            return false;
        }

    }

}
