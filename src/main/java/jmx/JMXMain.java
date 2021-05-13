package jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class JMXMain {

    /*
        Important :
        If you need to expose MBean, interface name and class name should strictly differ in MBean word i.e. interface
        name should be <ClassName>+"MBean".

        If you don't to adhere to this restriction, use MXBean word instead of MBean
     */
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.nagpal:type=basic,name=routing");

        RoutingConfigMBean routingMBean = new RoutingConfig();
        server.registerMBean(routingMBean, objectName);

        System.out.println("Mbean ready...");

        Thread.sleep(Long.MAX_VALUE);
    }
}
