package com.netjstech.codedemos;

public class Arithmetic {
   public int sum(int a, int b){
	   if(a >= 10)
		   throw new IllegalArgumentException("Value should be less than 10");
	   return a + b;
   }
   
   public int subtraction(int a, int b) {
	   return a - b;
   }

}
