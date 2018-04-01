package com.learnings.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
/**
 * Reflection can still break this code.
 * 
 * @author msubrama
 *
 */
public class SingletonCompleteWithoutEnum implements Serializable{

	private static SingletonCompleteWithoutEnum instance;
	
	private SingletonCompleteWithoutEnum() {}
	
	public static synchronized SingletonCompleteWithoutEnum getInstance() {
		/* Lazy Initialization */
		if(instance == null)
			instance = new SingletonCompleteWithoutEnum();
		return instance;
	}
	
	public void showMessage() {
		System.out.println("Hello World!");
	}
	
	/**
	 * To prevent Serialization break in
	 * @return
	 * @throws ObjectStreamException
	 */
	protected Object readResolve() throws ObjectStreamException {
		return instance;
	}

	/**
	 * To prevent Clone break in
	 * @return
	 * @throws ObjectStreamException
	 */
	protected Object clone() throws CloneNotSupportedException {
		return instance;
	}
}
