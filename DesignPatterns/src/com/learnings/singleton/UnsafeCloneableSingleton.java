package com.learnings.singleton;

public class UnsafeCloneableSingleton extends CloneableSuper {

	// create an object of SingleObject during class load time.. Can be done
	// inside a static block too.
	private static UnsafeCloneableSingleton instance;

	// make the constructor private so that this class cannot be instantiated
	private UnsafeCloneableSingleton() {
	};

	// Get the only object available
	public static synchronized UnsafeCloneableSingleton getInstance() {
		if (instance == null)
			instance = new UnsafeCloneableSingleton();
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}
}