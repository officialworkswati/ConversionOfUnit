package com.example.ConversionOfUnit.Services;

import com.example.ConversionOfUnit.Model.InputData;
import com.example.ConversionOfUnit.Utils.TemperatureConversion;
import com.example.ConversionOfUnit.Utils.UnitChecker;
import com.example.ConversionOfUnit.Utils.VolumeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("CheckConversion")
public class CheckConversion {
    /*
    to create instance UnitChecker, TemperatureConversion, and VolumeConversion...
     */
    @Autowired
    private UnitChecker unitChecker;

    @Autowired
    private TemperatureConversion temperatureConversion;

    @Autowired
    private VolumeConversion volumeConversion;

    //to store the float value of studentReponse
    double studentResponse;

    // method to round of the floating value to tenth places.
    public BigDecimal round(double d)
    {
        BigDecimal bd = new BigDecimal(d);
        bd=bd.setScale(1,BigDecimal.ROUND_HALF_DOWN);
        return bd;
    }


    public String studentResponseParser(String response)
    {
        try
        {
            // to parse studentResponse into floating value
            studentResponse = Double.parseDouble(response);
        }
        catch(Exception e)
        {
            return "incorrect";
        }

        return "correct";
    }

    // to validated the input and target units.
    public String UnitsValidation(InputData inputData)
    {

        //true if input and target units are both units of temperature
        if(unitChecker.checkTemperatureUnits(inputData.getInputUnit(),inputData.getTargetUnit()))
        {
            if(studentResponseParser(inputData.getStudentResponse()).equals("incorrect"))
                return "incorrect";

            // stores the result 0 if inputvalue and student Response is same else stores 1
            int res =round(studentResponse).compareTo(round(temperatureConversion.getConvertedValue(inputData.getInputValue(), inputData.getInputUnit().toUpperCase(), inputData.getTargetUnit().toUpperCase())));

            if(res==0)
             {
                 return "correct";
             }

             else return  "incorrect";
        }

        //true if input and target units are both units of volume
        else if(unitChecker.checkVolumeUnits(inputData.getInputUnit(),inputData.getTargetUnit()))
        {

            if(studentResponseParser(inputData.getStudentResponse()).equals("incorrect"))
                return "incorrect";

            // stores the result 0 if inputvalue and student Response is same else stores 1
            int res =round(studentResponse).compareTo(round(volumeConversion.getConvertedValue(inputData.getInputValue(), inputData.getInputUnit().toUpperCase(), inputData.getTargetUnit().toUpperCase())));
            if(res==0)
            {
                return "correct";
            }
            else return  "incorrect";
        }

        /*
         return invalid, if any input value inside request body is not correct ....
         */
        else return"invalid";
    }
}
