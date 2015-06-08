package com.java.anno04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.java.anno04.Anno;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "com.java.anno04.Sample";
		Class<?> cls = Class.forName(className);
		Method[] methods = cls.getMethods();
		
		for(int i = 0 ; i < methods.length ; i ++){
			Method method = methods[i];
			Annotation[][] annos = method.getParameterAnnotations();
			for(int j = 0 ; j <annos.length ; j ++){
				for(int k = 0 ; k < annos[j].length ; k++){
					Anno anno = (Anno) annos[j][k];
					System.out.println(anno.name());
				}
			}
		}
				
	}
}
