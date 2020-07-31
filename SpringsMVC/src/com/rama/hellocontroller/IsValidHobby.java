package com.rama.hellocontroller;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {

    String message() default "Please provide a valid Hobby:" + "Accepeted hobbies are - Music, Football, Cricket and " +
            "Hockey  (choose anyone)";
    Class<?> [] groups() default{};
    Class<? extends Payload>[] payload() default {};
}






