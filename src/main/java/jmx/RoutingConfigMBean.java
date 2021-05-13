package jmx;

public interface RoutingConfigMBean {

    int getShortThreads();

    void setShortThreads(int shortThreads);

    int getLongThreads();

    void setLongThreads(int longThreads);

    void setTimeout(int timeout);

    int getTimeout();

}
