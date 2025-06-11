package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Course;

public class TestAutowiring {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Course c11=(Course)ctx.getBean("c1");
		//Course c12=(Course)ctx.getBean("c2");
		System.out.println(c11);
		//System.out.println(c12);
	}

}
