package com.java.anno03;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "com.java.anno03.Sample";
		Class<?> cls = Class.forName(className);
		Method[] methods = cls.getMethods();
		
		for(Method method : methods){
			Annotation[] annos = method.getDeclaredAnnotations();
			for(Annotation temp : annos){
				Anno anno = (Anno) temp;
				System.out.println(anno.su() + "\t " + anno.value());
			}
		}
				
	}
}
