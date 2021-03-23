package com.example.ConversionOfUnit.Utils;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

//Utility Class
@Component("TemperatureConversion")
public class TemperatureConversion {

    // to return the actual converted value of inputValue into targetUnit
    public double getConvertedValue(double inputValue,String inputUnit,String targetUnit)
    {
        /*
        conditions to check which conversion to perform on the inputValue based on inputUnit and targetUnit
        Units {Rankine, Celsius, Kelvin, Fahrenheit}
         */
        if(inputUnit.equals("CELSIUS"))
        {
            if(targetUnit.equals("RANKINE"))
            {
                return celsiustoRankine(inputValue);
            }
            else if(targetUnit.equals("KELVIN"))
            {
                return celsiustoKelvin(inputValue);
            }
            else
            {
                return celsiustoFahrenheit(inputValue);
            }
        }
        else if(inputUnit.equals("RANKINE"))
        {
            double temp = rankinetoCelsius(inputValue);

            if(targetUnit.equals("KELVIN"))
            {
                return celsiustoKelvin(temp);
            }
            else if(targetUnit.equals("FARHENHEIT"))
            {
                return celsiustoFahrenheit(temp);
            }
            else return  temp;
        }
        else if(inputUnit.equals("KELVIN"))
        {
            double temp = kelvintoCelsius(inputValue);
            if(targetUnit.equals("RANKINE"))
            {
                return celsiustoRankine(temp);
            }
            else if(targetUnit.equals("FARHENHEIT"))
            {
                return celsiustoFahrenheit(temp);
            }
            else  return temp;
        }
        else
        {
            double temp = fahrenheittoCelsius(inputValue);
            if(targetUnit.equals("KELVIN"))
            {
                return celsiustoKelvin(temp);
            }
            else if(targetUnit.equals("RANKINE"))
            {
                return celsiustoRankine(temp);
            }
            else return  temp;
        }
    }

    //method to convert celsius to kelvin
    public double celsiustoKelvin(double inputValue)
    {
        return (inputValue + 273.15);
    }

    //method to convert celsius to fahrenheit
    public double celsiustoFahrenheit(double inputValue)
    {
        return (inputValue*9/5)+32;
    }

    //method to convert celsius to rankine
    public double celsiustoRankine(double inputValue)
    {
        return inputValue*9/5+491.67;
    }

    //kelvin to celsius
    public double kelvintoCelsius(double inputValue)
    {
        return (inputValue - 273.15);
    }

    //fahrenheit to celsius
    public double fahrenheittoCelsius(double inputValue)
    {
        return (inputValue - 32)*5/9;
    }

    //rankine to celsius
    public double rankinetoCelsius(double inputValue)
    {
        return (inputValue -491.67)*5/9;
    }
}
