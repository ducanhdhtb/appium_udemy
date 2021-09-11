package test.java.demo;

public class TryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String value = "Baeldung";
//	    String formatted = String.format("Welcome to %s!", value);
//	    System.out.println(formatted);
		String value_01 = "attribute";
		String value_02 = "value";
		
		String formatted = String.format("//*[@%s = '%s']", value_01,value_02);
		System.out.println(formatted);
//		formatted = "//*[@attribute = value]".format(alpha, value)
	}

}
