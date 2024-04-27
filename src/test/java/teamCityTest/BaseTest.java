package teamCityTest;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.ref.SoftReference;

public class BaseTest {
    protected SoftAssertions softAssert;

    @BeforeMethod
    public void beforeTest(){
        softAssert = new SoftAssertions();
    }

    @AfterMethod
    public void afterTest(){
        softAssert.assertAll();
    }

}
