package com.employee.management.system.employee_ms_version_101;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Component;

public class Employee {
    private String fname;

    public String getFname(){
        return fname;
    }

    public void setFname(String fname){
        this.fname = fname;
    }
}



/*
class EmployeeAutoWiredOne{
    @Autowired
    private Operator operator;

    @Autowired
    public String getFname(){
        return fname;
    }

    @Autowired
    public void setFname(String fname){
        this.fname = fname;
    }
}

@Component
class Arithmatic(){
    @Autowired
    private Operator operator;
    //...
}

@Component
class Addition implements Operator {

}

@Component
class Subtraction implements Operator{

}

class Vehicle{
    private Engine engine = new  Engine();
    //...
}

// in spring (inversion of control)
class Vehicle{
    private Engine engine; // engine is taking over vehicle class
}
*/