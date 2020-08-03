package com.rama.hellocontroller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[] {"studentMobile"});
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyy");
        binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
    }

    @RequestMapping(value = "/AdmissionFrom.html", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() throws Exception {

        String exceptionOccured = "ARITHMETIC_EXCEPTION";

        if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
            throw new NullPointerException("Null Pointer Exception");
        } else if (exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
            throw new IOException("IO_EXCEPTION");
        } else if (exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
            throw new ArithmeticException("ARITHMETIC_EXCEPTION");
        }

        ModelAndView model = new ModelAndView("AdmissionForm");
        return model;
    }

    @ModelAttribute
    public void addingCommonObjects(Model model) {
        model.addAttribute("msg", "Federation University ");
    }

    @RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("AdmissionForm");

            return model;

        }
        ModelAndView model = new ModelAndView("AdmissionSuccess");

        return model;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointException(Exception e) {

        System.out.println("Null Pointer Exception Occurred:" + e);
        return "NullPointerException";
    }

    @ExceptionHandler(value = IOException.class)
    public String handleIOException(Exception e) {

        System.out.println("IO Exception Occurred:" + e);
        return "IOException";
    }

    @ExceptionHandler(value = Exception.class)
    public String Exception(Exception e) {

        System.out.println("Unknown Exception Occurred:" + e);
        return "Exception";
    }
}
