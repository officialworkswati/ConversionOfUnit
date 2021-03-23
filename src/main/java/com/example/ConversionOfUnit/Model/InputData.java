package com.example.ConversionOfUnit.Model;

import javax.validation.constraints.NotNull;
/*
Container class to store the data from request body
 */
public class InputData {
    @NotNull
    private double inputValue;

    @NotNull
    private String inputUnit;

    @NotNull
    private String targetUnit;

    @NotNull
    private String studentResponse;

    public InputData(double inputValue, String inputUnit, String targetUnit, String studentResponse) {
        this.inputValue = inputValue;
        this.inputUnit = inputUnit;
        this.targetUnit = targetUnit;
        this.studentResponse = studentResponse;
    }


    /*
     to convert the object into a json String.....
     */
    @Override
    public String toString() {
        return "{\"inputValue\":\"" + inputValue +
                "\",\"inputUnit\":\"" + inputUnit +
                "\",\"targetUnit\":\""+ targetUnit +
                "\",\"studentResponse\":\""+ studentResponse + "\"}";
    }

    //Default Constructor
    public InputData() {
    }

    //Getters and Setters
    public double getInputValue() {
        return inputValue;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(String inputUnit) {
        this.inputUnit = inputUnit;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    public String getStudentResponse() {
        return studentResponse;
    }

    public void setStudentResponse(String studentResponse) {
        this.studentResponse = studentResponse;
    }

}
