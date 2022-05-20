package tech.antoniosgarbi.main;


import tech.antoniosgarbi.AbstractLogger;
import tech.antoniosgarbi.ConsoleLogger;
import tech.antoniosgarbi.ErrorLogger;
import tech.antoniosgarbi.FileLogger;

public class Main {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }


    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information \n");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information \n");

        loggerChain.logMessage(AbstractLogger.ERROR, "this is an error information \n");
    }
}
