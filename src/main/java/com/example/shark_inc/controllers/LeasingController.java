package com.example.shark_inc.controllers;


import com.example.shark_inc.models.leasing.CustomerData;
import com.example.shark_inc.services.InternalSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LeasingController {

    @Autowired
    private InternalSales services;

    @PostMapping("/leasing/sendForm")
    public void startLeasingProcess(@RequestBody CustomerData data) {
        services.startsTheLeasingApplicationProcess(data);
    }

}
