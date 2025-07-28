package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger = LogManager.getLogger();

    //Start test
    public static void startTest (String testName){
        logger.info(Thread.currentThread().getName() + "===== Execution started: " + testName + " =====");
    }
    //Info step
    public static void infoStep (String message){
        logger.info(message);
    }
    //Error step
    public static void errorLog (String message){
        logger.error(message);
    }
    //Finish test
    public static void finishTest (String testName){
        logger.info(Thread.currentThread().getName() +"===== Execution finished: " + testName + " =====");
    }

}
