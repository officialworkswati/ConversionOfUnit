package com.example.ConversionOfUnit;

import com.example.ConversionOfUnit.Model.InputData;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/*
 Test class to apply junit testing to test api on different inputs.
 */
public class ConversionControllerTests  extends ConversionOfUnitApplicationTests{

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void convertUnitTest() throws Exception
    {
        InputData inputData = new InputData(298.15,"Kelvin","Celsius","25");

        String json = inputData.toString();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/conversion")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals("{\"result\":\"correct\"}",result.getResponse().getContentAsString());

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }

    @Test
    public void convertUnitTest_1() throws Exception
    {
        InputData inputData = new InputData(15,"liter","Celsius","25");

        String json = inputData.toString();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/conversion")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals("{\"result\":\"invalid\"}",result.getResponse().getContentAsString());

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }

    @Test
    public void convertUnitTest_2() throws Exception
    {

        InputData inputData = new InputData(15,"liter","gallons","meters");

        String json = inputData.toString();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/conversion")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals("{\"result\":\"invalid\"}",result.getResponse().getContentAsString());

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
