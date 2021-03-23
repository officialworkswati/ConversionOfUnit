package com.example.ConversionOfUnit.Utils;

import org.springframework.stereotype.Component;


//Utility Class
@Component("VolumeConversion")
public class VolumeConversion {

    public double getConvertedValue(double inputValue,String inputUnit,String targetUnit)
    {
         /*
        conditions to check which conversion to perform on the inputValue based on inputUnit and targetUnit
        Units {cups, gallons, liters, cubic-inches, cubic-feet, tablespoons}
         */
        if(inputUnit.equals("CUPS"))
        {
            double temp = cupstoLiters(inputValue);
            if(targetUnit.equals("GALLONS"))
                return literstoGallons(temp);

            else if(targetUnit.equals("CUBIC-INCHES"))
                return literstoCubicInches(temp);

            else if(targetUnit.equals("CUBIC-FEET"))
                return literstoCubicFeet(temp);

            else if(targetUnit.equals("TABLESPOONS"))
                return literstoTablespoons(temp);

            else{System.out.println(temp);
                return temp;
            }
        }

        else if(inputUnit.equals("GALLONS"))
        {

            double temp = gallonstoLiters(inputValue);

            if(targetUnit.equals("CUPS"))
                return literstoCups(temp);

            else if(targetUnit.equals("CUBIC-INCHES"))
                return literstoCubicInches(temp);

            else if(targetUnit.equals("CUBIC-FEET"))
                return literstoCubicFeet(temp);

            else if(targetUnit.equals("TABLESPOONS"))
                return literstoTablespoons(temp);

            else return temp;

        }

        else if(inputUnit.equals("TABLESPOONS"))
        {

            double temp = tablespoonstoLiters(inputValue);

            if(targetUnit.equals("GALLONS"))
                return literstoGallons(temp);

            else if(targetUnit.equals("CUBIC-INCHES"))
                return literstoCubicInches(temp);

            else if(targetUnit.equals("CUBIC-FEET"))
                return literstoCubicFeet(temp);

            else if(targetUnit.equals("CUPS"))
                return literstoCups(temp);

            else return temp;

        }

        if(inputUnit.equals("CUBIC-INCHES"))
        {
            double temp = cubicInchestoLiters(inputValue);

            if(targetUnit.equals("GALLONS"))
                return literstoGallons(temp);

            else if(targetUnit.equals("CUPS"))
                return literstoCups(temp);

            else if(targetUnit.equals("CUBIC-FEET"))
                return literstoCubicFeet(temp);

            else if(targetUnit.equals("TABLESPOONS"))
                return literstoTablespoons(temp);

            else return temp;

        }

        if(inputUnit.equals("CUBIC-FEET"))
        {

            double temp = cubicFeettoLiters(inputValue);

            if(targetUnit.equals("GALLONS"))
                return literstoGallons(temp);

            else if(targetUnit.equals("CUBIC-INCHES"))
                return literstoCubicInches(temp);

            else if(targetUnit.equals("CUPS"))
                return literstoCups(temp);

            else if(targetUnit.equals("TABLESPOONS"))
                return literstoTablespoons(temp);

            else return temp;

        }

        else {

            if(targetUnit.equals("GALLONS"))
                return literstoGallons(inputValue);

            else if(targetUnit.equals("CUBIC-INCHES"))
                return literstoCubicInches(inputValue);

            else if(targetUnit.equals("CUPS"))
                return literstoCups(inputValue);

            else if(targetUnit.equals("TABLESPOONS"))
                return literstoTablespoons(inputValue);

            else return literstoCubicFeet(inputValue);
        }
    }

    // liters to tablespoons
    public double literstoTablespoons(double inputValue)
    {
        return inputValue*(67.628);
    }

    //liters to cups
    public double literstoCups(double inputValue)
    {
        return inputValue*(4.227);
    }

    //liters to cubic-inches
    public double literstoCubicInches(double inputValue)
    {
        return inputValue*(61.0237);
    }

    //liters to cubic-feet
    public double literstoCubicFeet(double inputValue)
    {
        return inputValue/(28.317);
    }

    //liters to gallons
    public double literstoGallons(double inputValue)
    {
        return inputValue/(3.785);
    }

    //tablespoons to liters
    public double tablespoonstoLiters(double inputValue)
    {
        return inputValue/(67.628);
    }

    //cups to liters
    public double cupstoLiters(double inputValue)
    {
        return inputValue/(4.227);
    }

    //gallons to liters
    public double gallonstoLiters(double inputValue)
    {
        return inputValue*(3.785);
    }

    //cubic-inches to liters
    public double cubicInchestoLiters(double inputValue)
    {
        return inputValue*(61.0237);
    }

    //cubic-feet to liters
    public double cubicFeettoLiters(double inputValue)
    {
        return inputValue*(28.317);
    }
}
