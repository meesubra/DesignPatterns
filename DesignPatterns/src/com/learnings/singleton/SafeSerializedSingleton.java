package com.learnings.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Issues:
 * Reflection can break
 * Serialization can break
 * @author msubrama
 *
 */

public class SafeSerializedSingleton implements Serializable{


	//create an object of SingleObject during class load time.. Can be done inside a static block too.
	private static SafeSerializedSingleton instance ;

	//make the constructor private so that this class cannot be instantiated
	private SafeSerializedSingleton(){};

	//Get the only object available
	public static synchronized SafeSerializedSingleton getInstance(){
		if(instance == null)
			instance = new SafeSerializedSingleton();
		return instance;
	}

	public void showMessage(){
		System.out.println("Hello World!");
	}
	/**
	 * The readResolve method is called when ObjectInputStream has read an object from the stream and 
	 * is preparing to return it to the caller. ObjectInputStream checks whether the class of the object defines 
	 * the readResolve method. If the method is defined, the readResolve method is called to allow the object 
	 * in the stream to designate the object to be returned.
	 * @return
	 */
	
	private Object readResolve() throws ObjectStreamException{
		return instance;
		
	}
	
}