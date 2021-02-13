package javaCore.datatype;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		String str2 = str;
		str2 = "I've changed! ";
		System.out.println("str: " + str + "\nstr2: " + str2);
		
		StringBuilder sb = new StringBuilder("Hello");
		StringBuilder sb2 = sb;
		sb2.append(" changing!");
		System.out.println("str: " + sb + "\nstr2: " + sb2);
		//System.out.println(str.hashCode() + " and " + c.hashCode());
		
		

	}

}
