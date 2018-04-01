package com.learnings.singleton;

public class CloneableSuper implements Cloneable {

		protected Object clone() throws CloneNotSupportedException{
			return super.clone();
			
		}
}
