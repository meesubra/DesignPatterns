package com.learnings.abstractfactorypattern;

public class ColorFactory extends AbstractFactory{

		//use getColor method to get object of type color 
	   @Override
	   public Color getColor(String colorName){
	      if(colorName == null){
	         return null;
	      }		
	      if(colorName.equalsIgnoreCase("RED")){
	         return new Red();
	         
	      } else if(colorName.equalsIgnoreCase("BLUE")){
	         return new Blue();
	         
	      } else if(colorName.equalsIgnoreCase("GREEN")){
	         return new Green();
	      }
	      
	      return null;
	   }
	   
	   @Override
	   Shape getShape(String shapeType) {
	      return null;
	   }
}
