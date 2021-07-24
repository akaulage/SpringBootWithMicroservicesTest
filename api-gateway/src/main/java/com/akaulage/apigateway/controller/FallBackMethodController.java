package com.akaulage.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String UserServiceFallBackMethod()
    {
        return "User Service is taking loger than Expected.."+ "Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String DepartmentServiceFallBackMethod()
    {
        return "Department Service is taking loger than Expected.."+ "Please try again later";
    }
}
