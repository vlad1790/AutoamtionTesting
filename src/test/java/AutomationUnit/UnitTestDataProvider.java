package AutomationUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTesting.Tickets;

public class UnitTestDataProvider {
    @DataProvider(name = "tickets")
    public Object[][] getData(){
        return new Object[][]{
                {1,0.0,1000},
                {5,500.0,1000},
                {19,1000.0,1000},
                {68,800.0,1000},
        };
    }
    @Test (dataProvider = "tickets")
    public void ticketsTest_all_depends(int age, double price, int fare) {
        Tickets adult = new Tickets(age, fare);
        double result = adult.getPrice();
        Assert.assertEquals(result, price);
    }
}
