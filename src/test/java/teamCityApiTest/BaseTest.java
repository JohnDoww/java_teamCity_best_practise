package teamCityApiTest;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import teamCityProject.api.generators.TestDataStorage;
import teamCityProject.api.requests.CheckedRequests;
import teamCityProject.api.requests.UncheckedRequests;
import teamCityProject.api.spec.Specifications;

/**
 * There is we store actions which we will while running tests
 */
public class BaseTest {
    public TestDataStorage testDataStorage;
    public CheckedRequests checkedWithSuperUser = new CheckedRequests(Specifications.getSpec().superUserSpec());
    public UncheckedRequests uncheckedWithSuperUser= new UncheckedRequests(Specifications.getSpec().superUserSpec());
    protected SoftAssertions softAssert;

    @BeforeMethod
    public void beforeTest(){
        // initialize soft assertion before the test
        softAssert = new SoftAssertions();
        // get generated data
        testDataStorage = TestDataStorage.getStorage();
    }

    @AfterMethod
    public void afterTest(){
        // clean all test data
        testDataStorage.delete();
        // show all soft assertions
        softAssert.assertAll();
    }

}
