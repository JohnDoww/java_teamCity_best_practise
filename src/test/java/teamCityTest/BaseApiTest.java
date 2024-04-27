package teamCityTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import teamCityProject.api.generators.TestDataStorage;
import teamCityProject.api.requests.CheckedRequests;
import teamCityProject.api.requests.UncheckedRequests;
import teamCityProject.api.spec.Specifications;


public class BaseApiTest extends BaseTest{

    public TestDataStorage testDataStorage;
    public CheckedRequests checkedWithSuperUser = new CheckedRequests(Specifications.getSpec().suerUserSpec());
    public UncheckedRequests uncheckedWithSuperUser= new UncheckedRequests(Specifications.getSpec().suerUserSpec());

    @BeforeMethod
    public void setupTest() {
        testDataStorage = TestDataStorage.getStorage();
    }

    @AfterMethod
    public void cleanTest() {
        testDataStorage.delete();
    }
}
