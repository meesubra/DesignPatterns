package com.learnings.singleton;

import java.io.Serializable;

/**
 * Issues:
 * Reflection can break
 * Serialization can break
 * @author msubrama
 *
 */

public class UnsafeSerializedSingleton implements Serializable{


	//create an object of SingleObject during class load time.. Can be done inside a static block too.
	private static UnsafeSerializedSingleton instance ;

	//make the constructor private so that this class cannot be instantiated
	private UnsafeSerializedSingleton(){};

	//Get the only object available
	public static synchronized UnsafeSerializedSingleton getInstance(){
		if(instance == null)
			instance = new UnsafeSerializedSingleton();
		return instance;
	}

	public void showMessage(){
		System.out.println("Hello World!");
	}
}