package com.learnings.singleton;

public class SafeCloneableSingleton extends CloneableSuper {

	// create an object of SingleObject during class load time.. Can be done
	// inside a static block too.
	private static SafeCloneableSingleton instance;

	// make the constructor private so that this class cannot be instantiated
	private SafeCloneableSingleton() {
	};

	// Get the only object available
	public static synchronized SafeCloneableSingleton getInstance() {
		if (instance == null)
			instance = new SafeCloneableSingleton();
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}
	
	/**
	 * This can return the same instance or it can throw the CloneNotSupported Exception
	 */
	protected Object clone() throws CloneNotSupportedException {
		return instance;
		
	}
}