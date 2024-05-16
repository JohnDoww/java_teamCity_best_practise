package teamCityTest;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * There is we store actions which we will while running tests
 */
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
