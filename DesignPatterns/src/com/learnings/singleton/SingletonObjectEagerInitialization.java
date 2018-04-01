package com.learnings.singleton;

/**
 * Issues:
 * Non ThreadSafe
 * Eagerly Initialized
 * Reflection can break
 * Serialization can break
 * @author msubrama
 *
 */
public class SingletonObjectEagerInitialization {

	//create an object of SingleObject during class load time.. Can be done inside a static block too.
	private static SingletonObjectEagerInitialization instance = new SingletonObjectEagerInitialization();

	//make the constructor private so that this class cannot be instantiated
	private SingletonObjectEagerInitialization(){};

	//Get the only object available
	public static SingletonObjectEagerInitialization getInstance(){
		return instance;
	}

	public void showMessage(){
		System.out.println("Hello World!");
	}
}