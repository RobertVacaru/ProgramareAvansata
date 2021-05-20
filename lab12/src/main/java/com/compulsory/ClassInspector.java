package com.compulsory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

public class ClassInspector {
    public void inspect (String className) throws ClassNotFoundException, IntrospectionException {
        Class clazz=Class.forName(className);
        BeanInfo beanInfo= Introspector.getBeanInfo(clazz);
        extractInformation(beanInfo);
    }
    public void extractInformation(BeanInfo beanInfo)
    {
        System.out.println("Bean Descriptor:"+beanInfo.getBeanDescriptor().getBeanClass());
        System.out.println("Property Descriptor:"+Arrays.toString(beanInfo.getPropertyDescriptors()));
    }

}
