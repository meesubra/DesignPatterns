package com.learnings.singleton;

/**
 * Issues:
 * Non ThreadSafe
 * Reflection can break
 * Serialization can break
 * @author msubrama
 *
 */


public class SingletonObjectLazyInitialization {

	    //Declaration of singleton object and initialization are separated to ensure the LazyInitialization
		private static SingletonObjectLazyInitialization instance;

		//make the constructor private so that this class cannot be instantiated
		private SingletonObjectLazyInitialization(){};

		//Get the only object available
		public static SingletonObjectLazyInitialization getInstance(){
			if(instance == null)
				instance = new SingletonObjectLazyInitialization();
			return instance;
		}

		public void showMessage(){
			System.out.println("Hello World!");
		}
}
