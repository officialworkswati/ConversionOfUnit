package com.example.ConversionOfUnit.Utils;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component("UnitChecker")
public class UnitChecker {

    //list of temperature units
    List<String> unitsOfTemperature =Arrays.asList("CELSIUS","KELVIN","RANKINE","FAHRENHEIT");

    //list of volume units
    List<String> unitsOfVolume = Arrays.asList("LITERS","TABLESPOONS","CUBIC-INCHES","CUPS","CUBIC-FEET","GALLONS");

    // to check input unit and target unit are both units of temperature
    public boolean checkTemperatureUnits(String inputUnit,String targetUnit){

        if(unitsOfTemperature.contains(inputUnit.toUpperCase()) && unitsOfTemperature.contains(targetUnit.toUpperCase()))
            return true;

        else return false;
    }

    // to check input unit and target unit are both units of volume
    public boolean checkVolumeUnits(String inputUnit,String targetUnit){

        if (unitsOfVolume.contains(inputUnit.toUpperCase()) && unitsOfVolume.contains(targetUnit.toUpperCase()))
            return true;

        else return false;
    }
}
