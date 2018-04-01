package com.learnings.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPatternDemo {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, CloneNotSupportedException {

		// illegal construct - Compile Time Error: The constructor
		// SingletonObjectEagerInitialization() is not visible
		// SingletonObjectEagerInitialization object = new SingletonObjectEagerInitialization();

		// Get the only object available
		SingletonObjectEagerInitialization object1 = SingletonObjectEagerInitialization.getInstance();

		// show the message
		object1.showMessage();

		SingletonObjectEagerInitialization object2 = SingletonObjectEagerInitialization.getInstance();

		// Check whether the objects are equal to test the singleton.
		object2.showMessage();
		System.out.println(object1 == object2);

		breakSingletonUsingReflection();
		
		breakSingletonUsingSerialization();
		
		breakSingletonUsingClone();
		
		validateSingletonEnum();

	}

	private static void validateSingletonEnum() throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		validateSingletonEnumWithRefelction();
		validateSingletonEnumWithSerialization();
		validateSingletonEnumWithClone();
		
	}
	
	public static void validateSingletonEnumWithRefelction() {
		SingletonEnum instanceObj1 = SingletonEnum.INSTANCE;

		SingletonEnum instanceObj2 = null;

		// to get all the constructors of the class.
		Constructor[] constructs = SingletonEnum.class.getDeclaredConstructors();
		for (Constructor construct : constructs) {
			construct.setAccessible(true);
			try {
				instanceObj2 = (SingletonEnum) construct.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");
	}
	
	public static void validateSingletonEnumWithSerialization() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("Singleton Using Serialization");
		
		// initialize the first object
		SingletonEnum instanceObj1 = SingletonEnum.INSTANCE;

		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceObj1);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		SingletonEnum instanceObj2 = (SingletonEnum) in.readObject();
		

		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");
	}
	
	public static void validateSingletonEnumWithClone() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("Singleton Using Clone");
		
		// initialize the first object
		System.out.println("Singleton Using Clone");
		// initialize the first object
		SingletonEnum instanceObj1 = SingletonEnum.INSTANCE;

		/* SingletonEnum has a final method of clone -- hence invalidated this test
		SingletonEnum instanceObj2 = (SingletonEnum) instanceObj1.clone(); 
		

		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");*/
		System.out.println("safe");
	}

	public static void breakSingletonUsingReflection() {
		// initialize the first object
		LazySingletonObjectThreadSafe instanceObj1 = LazySingletonObjectThreadSafe.getInstance();

		LazySingletonObjectThreadSafe instanceObj2 = null;

		// to get all the constructors of the class.
		Constructor[] constructs = LazySingletonObjectThreadSafe.class.getDeclaredConstructors();
		for (Constructor construct : constructs) {
			construct.setAccessible(true);
			try {
				instanceObj2 = (LazySingletonObjectThreadSafe) construct.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");
	}

	public static void breakSingletonUsingSerialization() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("Singleton Using Clone");
		
		// initialize the first object
		UnsafeSerializedSingleton instanceObj1 = UnsafeSerializedSingleton.getInstance();

		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceObj1);
		out.close();
		

		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		UnsafeSerializedSingleton instanceObj2 = (UnsafeSerializedSingleton) in.readObject();
		

		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");
		
		SafeSerializedSingleton instanceObj3 = SafeSerializedSingleton.getInstance();

		out = new ObjectOutputStream(new FileOutputStream("filename1.ser"));
		out.writeObject(instanceObj3);
		out.close();
		

		in = new ObjectInputStream(new FileInputStream("filename1.ser"));
		SafeSerializedSingleton instanceObj4 = (SafeSerializedSingleton) in.readObject();
		

		System.out.println(instanceObj3 == instanceObj4 ? "safe" : "Unsafe");
	}
	
	public static void breakSingletonUsingClone() throws CloneNotSupportedException {
		
		System.out.println("Singleton Using Clone");
		// initialize the first object
		UnsafeCloneableSingleton instanceObj1 = UnsafeCloneableSingleton.getInstance();

		UnsafeCloneableSingleton instanceObj2 = (UnsafeCloneableSingleton) instanceObj1.clone();
		

		System.out.println(instanceObj1 == instanceObj2 ? "safe" : "Unsafe");
		
		SafeCloneableSingleton instanceObj3 = SafeCloneableSingleton.getInstance();

		SafeCloneableSingleton instanceObj4 = (SafeCloneableSingleton) instanceObj3.clone();
		
		System.out.println(instanceObj3 == instanceObj4 ? "safe" : "Unsafe");

	}

}
