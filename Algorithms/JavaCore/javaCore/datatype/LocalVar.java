package javaCore.datatype;

public  class LocalVar {
	
	// Global var variable is not allowed
	//var variable = "Hello";
	
	public static void main(String[] args) {
		 LocalVar.typeOf();
		 LocalVar.whenVarInitWithAnonymous_thenGetAnonymousType();
		
	}
	
	public static void typeOf() {
		var s = "Hey there! ";
		// Is not allowed
		// var variable = null;
		System.out.print(s instanceof String);
	}
	
	public static void whenVarInitWithAnonymous_thenGetAnonymousType()	{
		var obj = new Object() {};
		System.out.print(obj.getClass().equals(Object.class));
		
		 // obj = new Object();  //Error Type mismatch
	}
	
	
	
}
