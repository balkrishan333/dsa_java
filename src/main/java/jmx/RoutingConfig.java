package jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoutingConfig implements RoutingConfigMBean {

    private static final Logger logger = LoggerFactory.getLogger(RoutingConfigMBean.class);

    private int shortThreads;
    private int longThreads;
    private int timeout;

    @Override
    public int getShortThreads() {
        return shortThreads;
    }

    @Override
    public void setShortThreads(int shortThreads) {
        logger.info("Setting short threads : " + shortThreads);
        this.shortThreads = shortThreads;
    }

    @Override
    public int getLongThreads() {
        return longThreads;
    }

    @Override
    public void setLongThreads(int longThreads) {
        logger.info("Setting long threads : " + longThreads);
        this.longThreads = longThreads;
    }

    @Override
    public void setTimeout(int timeout) {
        logger.info("Setting timeout : " + timeout);
        this.timeout = timeout;
    }

    @Override
    public int getTimeout() {
        return timeout;
    }
}
