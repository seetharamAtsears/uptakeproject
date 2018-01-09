package com.uptake.online.lib.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;


/**
 * Log4J Logger.
 * Logs messages on console and TestNg html reports.
 *
 * @author seethar1
 *
 */
public class ExtLogger  {
    private Logger logger = null;
    private static final Map<?, ?> loggers = new HashMap<Object, Object>();

    private ExtLogger(Class<?> loggingClass) {
        setUpLogger();
        this.logger = Logger.getLogger(loggingClass);
    }

    /**
     *
     * @param loggingClass
     * @return
     */

   public static ExtLogger getLogger(Class<?> loggingClass) {
       String className = loggingClass.getName();
       ExtLogger logger = (ExtLogger) loggers.get(className);
       setUpLogger();
       if (logger == null) {
           synchronized (ExtLogger.class) {
               logger = (ExtLogger) loggers.get(className);
               if (logger == null) {
                   logger = new ExtLogger(loggingClass);
               }
           }
       }
       return logger;
   }

    public void fatal(String message) {
        logger.fatal(message);
        Reporter.log("       "+message);
    }

    public void fatal(String message, Throwable t) {
        logger.fatal(message, t);
        Reporter.log("       "+message);
    }

    public void error(String message) {
        logger.error(message);
        Reporter.log("       "+message);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
        Reporter.log("       "+message);
    }

    public void warn(String message) {
        logger.warn(message);
        Reporter.log("       "+message);
    }

    public void warn(String message, Throwable t) {
        logger.warn(message, t);
        Reporter.log("       "+message);
    }

    public void info(String message) {
        logger.info(message);
        Reporter.log("       "+message);
    }

    public void debug(String message) {
        logger.debug(message);
        Reporter.log("       "+message);
    }

    public void trace(String message) {
        logger.trace(message);
        Reporter.log("       "+message);
    }

    /**
     *  Logging the message based on the level
     * @param level
     * @param logMsg
     */
    public void log(Level level, String logMsg) {
        if(level.toString().equalsIgnoreCase("info")){
            info(logMsg);
        }
        if(level.toString().equalsIgnoreCase("warn")){
            warn(logMsg);

        }
        if(level.toString().equalsIgnoreCase("error")){
            error(logMsg);

        }
        if(level.toString().equalsIgnoreCase("fatal")){
            fatal(logMsg);

        }
        if(level.toString().equalsIgnoreCase("debug")){
            debug(logMsg);

        }
        if(level.toString().equalsIgnoreCase("trace")){
            trace(logMsg);
        }
    }

    /**
     * Overloaded method to Log the message based on the level with Exception
     * @param level
     * @param logMsg
     * @param exception
     */
    public void log(Level level, String logMsg, Throwable exception) {
        if(level.toString().equalsIgnoreCase("warn")){
            warn(logMsg,exception);

        }
        if(level.toString().equalsIgnoreCase("error")){
            error(logMsg,exception);

        }
        if(level.toString().equalsIgnoreCase("fatal")){
            fatal(logMsg,exception);
        }
    }

    /**
     * Log the message
     * @param level
     * @param logMsg
     */
    public void testLog(Level level, String logMsg) {
        //To Log On Console and HTML
        log(level, logMsg);
    }
    /**
     *  Log the message with exceptions
     * @param level
     * @param logMsg
     * @param exception
     */
    public void testLog(Level level, String logMsg, Throwable exception) {
        //To Log On Console and HTML
        log(level, logMsg, exception);
    }
    

    /**
     * This is to log the testcase stpes with boarders
     * @param logMsg
     */
    public void testStepLog(String logMsg) {

        testLog(Level.INFO,"==================================================================");
        testLog(Level.INFO,"=====>     " + logMsg);
        testLog(Level.INFO,"==================================================================");
   }

    /**
     * This is to log testcase names with boarders
     * @param logMsg
     */
    public void testCaseLog(String logMsg) {

        testLog(Level.INFO,"##################################################################");
        testLog(Level.INFO,"#####>     " + logMsg);
        testLog(Level.INFO,"##################################################################");
    }



    /**
     * Configure the logger with properties
     */
    private static void setUpLogger() {
        Properties properties = new Properties();
        properties.put("log4j.rootLogger", "TRACE,Console");
        properties.put("log4j.appender.Console", "org.apache.log4j.ConsoleAppender");
        properties.put("log4j.appender.Console.layout", "org.apache.log4j.PatternLayout");
        //properties.put("log4j.appender.Console.layout.ConversionPattern", "%-4r [%d] [%-5p] [%c %x] - %m%n");
        properties.put("log4j.appender.Console.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{2}:%L - %m%n");

        PropertyConfigurator.configure(properties);
    }

}
