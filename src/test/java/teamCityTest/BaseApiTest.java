package teamCityTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import teamCityProject.api.generators.TestDataStorage;
import teamCityProject.api.requests.CheckedRequests;
import teamCityProject.api.requests.UncheckedRequests;
import teamCityProject.api.spec.Specifications;


/**
 * There is we initialize creating a test data before each test and deleting the data after each test
 */
public class BaseApiTest extends BaseTest{

    public TestDataStorage testDataStorage;
    public CheckedRequests checkedWithSuperUser = new CheckedRequests(Specifications.getSpec().superUserSpec());
    public UncheckedRequests uncheckedWithSuperUser= new UncheckedRequests(Specifications.getSpec().superUserSpec());

    @BeforeMethod
    public void setupTest() {
        testDataStorage = TestDataStorage.getStorage();
    }

    @AfterMethod
    public void cleanTest() {
        testDataStorage.delete();
    }
}
