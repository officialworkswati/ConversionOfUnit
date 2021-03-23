package com.example.ConversionOfUnit.Controller;

import com.example.ConversionOfUnit.Model.InputData;
import com.example.ConversionOfUnit.Services.CheckConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

//controller class for api creation
@RestController
@CrossOrigin
public class ConversionController {

    //to create instance of CheckConversion class
    @Autowired
    private CheckConversion checkConversion;
    
    @PostMapping(path = "/conversion" , consumes = "application/json", produces = "application/json")
    // method contains the response body for the post api
    public ResponseEntity<Map> convertUnit(@RequestBody InputData inputData )
    {
        // result variable used to store the output of the calculation(correct, incorrect or invalid)
        String result =  checkConversion.UnitsValidation(inputData);

        //Response return
        return ResponseEntity.ok(Collections.singletonMap("result",result));
    }
}
