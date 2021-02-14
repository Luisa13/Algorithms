package javaCore.exceptionsHandling;

public class exceptions {
	
	public static class superClass{
		public void method1() throws Exception {
			System.out.print("Method1: Ey there! Im the SUPER class"); 
		}
		
		public void method2()  {
			System.out.print("Method2: Ey there! Im the SUPER class");
		}
		
	}
	
	public static class subClass extends superClass{
		public void method1() {
			System.out.print("Method1: Ey there Im the SUBclass"); 
		}
		
		/*public void method2() throws Exception {   // Compite time error
			System.out.print("Method2: Ey there Im the SUBclass"); 
		}*/
	}

	/**
	 * Shows how a basic exception  is 

	 * */
	public static void exceptionHandling() {
		try {
			String s = null;
			System.out.print(s.length()); //Runtime Exception
		}catch(NullPointerException ex) {
			System.out.print("This is a null pointer exception!: " + ex.getMessage());
		}
	}
	
	/**
	 * Shows the behavior when a super class defines an exception and a 
	 * subclass that overrides a method is executed
	 * 
	 * */
	public static void superClassDefinedException() {
		superClass sc = new subClass();
		try {
			sc.method1();
		}catch(Exception e) {
			System.out.print("This is an exception\n");
		}
		
		try{
			sc.method2();
		}catch(ArithmeticException e){
			System.out.print("This is an arithmetic exception \n");
		}
	}
}
