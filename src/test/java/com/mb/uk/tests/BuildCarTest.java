package com.mb.uk.tests;

import com.mb.uk.web.pages.HomePage;
import com.mb.uk.web.pages.OverviewPage;
import com.mb.uk.web.pages.VehiclesPage;
import com.mb.uk.web.utils.DataProviders;
import com.mb.uk.web.utils.Utilities;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.mb.uk.tests.Listeners.class)
public class BuildCarTest extends BaseTest{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BuildCarTest.class);
    HomePage homePage=new HomePage();
    OverviewPage overviewPage=new OverviewPage();
    VehiclesPage vehiclesPage=new VehiclesPage();
    Utilities utils=new Utilities();

    @Test(dataProvider = "buildCars", dataProviderClass = DataProviders.class, description = "Build Car")
    public void buildCar(String overviewPageTitle){
        homePage.acceptCookies();
        homePage.selectMenuOptionOurModels();
        homePage.selectModelTypeHatchBacks();
        homePage.selectHatchBacksTypeAClass();
        Assert.assertTrue(overviewPage.getOverviewPageTitle().contains(overviewPageTitle));
        overviewPage.buildYourCar();
        vehiclesPage.filterByFuelTypeDiesel();
        vehiclesPage.sortPriceLowestToHighest();
        utils.createFile();
        log.info("Lowest Price: "+vehiclesPage.getVehiclePrice());
        utils.writeFile("Lowest Price: "+vehiclesPage.getVehiclePrice());
        vehiclesPage.sortPriceHighestToLowest();
        utils.writeFile("Highest Price: "+vehiclesPage.getVehiclePrice());
        log.info("Highest Price: "+vehiclesPage.getVehiclePrice());
        utils.closeFile();
    }
}
