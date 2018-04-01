package com.learnings.singleton;

/**
 * Issues:
 * Reflection can break
 * Serialization can break
 * @author msubrama
 *
 */

public class LazySingletonObjectThreadSafe {

		//create an object of SingleObject during class load time.. Can be done inside a static block too.
		private static LazySingletonObjectThreadSafe instance ;

		//make the constructor private so that this class cannot be instantiated
		private LazySingletonObjectThreadSafe(){};

		//Get the only object available
		public static synchronized LazySingletonObjectThreadSafe getInstance(){
			if(instance == null)
				instance = new LazySingletonObjectThreadSafe();
			return instance;
		}

		public void showMessage(){
			System.out.println("Hello World!");
		}
}
