package com.atguigu.test;

import com.atguigu.aop.MyInvocationHandler;
import com.atguigu.aop.UserService;
import com.atguigu.aop.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.aop.MathCalculator;
import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Red;
import com.atguigu.config.MainConfigOfAOP;
import com.atguigu.config.MainConifgOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class IOCTest_AOP {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		
		mathCalculator.div(1, 0);
		
		applicationContext.close();
	}

	@Test
	public void test02(){
		UserService userService = (UserService) Proxy.newProxyInstance(IOCTest_AOP.class.getClassLoader(), new Class[]{UserService.class}, new MyInvocationHandler(new UserServiceImpl()));
		userService.login();
	}

	@Test
	public void test03() throws Exception{
		byte bytes[] = ProxyGenerator.generateProxyClass("$ProxyUS", new Class[]{UserService.class});
		FileOutputStream fileOutputStream = new FileOutputStream("$ProxyUS.class");
		fileOutputStream.write(bytes);
		fileOutputStream.flush();
		fileOutputStream.close();
	}

}
