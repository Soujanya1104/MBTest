package com.mb.uk.web.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="buildCars")
    public Object[][] buildCars(){
        return new Object[][]{{"A-Class Hatchback"}};
    }
}