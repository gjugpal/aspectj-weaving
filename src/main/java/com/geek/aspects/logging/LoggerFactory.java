package com.geek.aspects.logging;

import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;

public class LoggerFactory
{

//    private static boolean setProperties = false;
//
//    public synchronized void generateLogger(final String currentlyExecutingTestScript)
//    {
//
//        if (!setProperties)
//        {
//            setDefaultLogProperties();
//        }
//
//        setLogAppenderProperties(currentlyExecutingTestScript);
//
//    }
//
//    /**
//     * Attaches the log4j.properties file to the root logger. This should only
//     * be performed once per test suite execution
//     */
//    private void setDefaultLogProperties()
//    {
//
//        Logger log = Logger.getLogger(Thread.currentThread().getName());
//        final Properties props = new Properties();
//        InputStream configStream = null;
//        try
//        {
//            configStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("log4j.properties");
//            props.load(configStream);
//
//            PropertyConfigurator.configure(props);
//
//            setProperties = true;
//        }
//
//        catch (final IOException ex)
//        {
//            log.severe("error occurred while trying to configure log4j.properties file");
//        }
//        finally
//        {
//            if (configStream != null)
//            {
//                try
//                {
//                    configStream.close();
//                }
//                catch (final IOException e)
//                {
//                    log.severe("error occurred while trying to close log4j.properties stream");
//                }
//            }
//        }
//    }
//
//    /**
//     * Configures a new Log Appender, setting the logger name as the current
//     * Thread name. The appender properties are then added to Log4J
//     *
//     * @param testName - the test script name is used as part of the logger name
//     */
//    private void setLogAppenderProperties(final String testName)
//    {
//        final Properties properties = new Properties();
//
//        final String threadName = Thread.currentThread().getName();
//        final String appender = String.format("log4j.appender.%s_FILE", threadName);
//
//        final String[] tempFilename = testName.split("\\.");
//
//        final String filename = String.format("%s_%s_%s-%s", tempFilename[tempFilename.length - 2], tempFilename[tempFilename.length - 1], Thread
//                .currentThread().getName(), LocalDateTime.now().toString());
//
//        properties.setProperty("log4j.logger.".concat(threadName), "info".concat(",").concat(threadName).concat("_FILE"));
//        properties.setProperty(appender, "org.apache.log4j.FileAppender");
//        properties.setProperty(appender.concat(".Threshold"), "info");
//        properties.setProperty(appender.concat(".layout"), "org.apache.log4j.PatternLayout");
//        properties.setProperty(appender.concat(".ImmediateFlush"), "true");
//        properties.setProperty(appender.concat(".file"), "./target/".concat(filename).concat(".log"));
//        properties.setProperty(appender.concat(".append"), "true");
//        properties.setProperty(appender.concat(".layout.ConversionPattern"), "[%d{dd MMM HH:mm:ss}] - [%4p] - %F:%L - %m%n");
//
//
//        PropertyConfigurator.configure(properties);
//    }
}
