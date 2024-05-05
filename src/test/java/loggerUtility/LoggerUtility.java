package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger = LogManager.getLogger();

    public static void startTestCase(String testCase) {
        logger.info("****** Test Execution Started: {} ******", testCase);
    }

    public static void finishTestCase(String testCase) {
        logger.info("****** Test Execution Finished: {} ******", testCase);
    }

    public static void infoTest(String message) {
        logger.info("Info Message: {}", message);
    }

    public static void errorTestCase(String message) {
        logger.error("Error message: {}", message);
    }

}
