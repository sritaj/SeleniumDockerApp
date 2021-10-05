package listeners;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import reports.ExtentReportsImp;
import utilities.PropertiesFileImp;

public final class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private int maxAttempt = FrameworkConstants.getRetryCounts();

    @Override
    public boolean retry(ITestResult result) {
        if(PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")){
            if(count<maxAttempt){
                count++;
                return true;
            }else{
                String testName = result.getName();
                ExtentReportsImp.failTest(testName, PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.SCREENSHOTONFAIL));
                ExtentReportsImp.failTestException(result.getThrowable());
            }
        }else{
            String testName = result.getName();
            ExtentReportsImp.failTest(testName, PropertiesFileImp.getDataFromPropertyFile(ConfigProperties.SCREENSHOTONFAIL));
            ExtentReportsImp.failTestException(result.getThrowable());
        }
        return false;
    }

}
