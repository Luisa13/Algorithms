package javaCore.datatype;

public class SBexercises {

	/**
	 * Checks the mutable property with Strings and StringBuilder. While 
	 * String is immutable, StringBuilder is not. We can test it by 
	 * concatenating a new string to each one of them and see the result
	 * 
	 * */
	public static void checkInmutability(String newStr, StringBuilder newsb) {
		String str = "This is an old string";
		String str2 = str;
		// now they are the same
		str2 = str2.concat(newStr);
		// and now I changed one of them
		System.out.println("STRING");
		System.out.println("Old: " + str + "\nNew: " + str2);
		
		StringBuilder sb = new StringBuilder("This is an old String Builder");
		StringBuilder sb2 = sb;
		// now they are the same
		sb2.append(newsb);
		// and now I changed one of them
		System.out.println("\nSTRING BUILDER");
		System.out.println("Old: " + sb + "\nNew: " + sb2);
	}
	
	/**
	 * StringBuilder is thread safe
	 * */
	public static class TestThreadSafe implements Runnable{
		private StringBuilder sb = new StringBuilder();
		private String s = new String();
		
		public TestThreadSafe(String str){
			this.sb.append(str);
			this.s.concat(str);
		}
		public void run() {
			System.out.println("SB: " + this.sb);
			System.out.println("STR:" + this.s);
		}
	}
	
	public static void main(String[] args) {
		// 1. Check immutability 
		//checkInmutability(" ...and now it changes", new StringBuilder(" that changes all the way"));
		
		// 2. Thread Safe
		new Thread(new TestThreadSafe("bla")).start();
		new Thread(new TestThreadSafe("meh")).start();
		
		// 3. 
	}

}
