package cn.h.beeclub.drools;

import java.util.Enumeration;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while(enumeration.hasMoreElements()){
            String name = (String) enumeration.nextElement();
            System.out.println(name + ":" + properties.getProperty(name));
        }
        System.out.println();
    }
}
