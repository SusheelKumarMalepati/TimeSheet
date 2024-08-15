package com.in.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TimeSheetException.class)
    public ModelAndView handleTimeSheetException(TimeSheetException ex, HttpServletRequest request) {
        String employeeId = request.getParameter("employeeId");
        ModelAndView modelAndView = new ModelAndView("TimeSheetException");
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.addObject("employeeId", employeeId);
        return modelAndView;
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("EmployeeNotFoundException");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
