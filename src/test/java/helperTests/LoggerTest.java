package helperTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    private static final Logger logger = LogManager.getLogger(LoggerTest.class.getName());

    public static void main(String[] args) {
        logger.debug("Hello from Log4j 2");
        logger.debug("This is a Debug Message!");
        logger.info("This is an Info Message!");
        try {
            System.out.println(100 / 0);
        } catch (Exception e) {
            // to print stacktrace
            logger.error("Error Occured", e);
            logger.fatal("Fatal error");
        }
    }
}
