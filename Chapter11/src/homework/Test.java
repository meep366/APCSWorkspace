package homework;

public class Test {

	/**
	 * @param args
	 */
	
	
	
	
	public void test(Adder device)
	{
		device.setA(2);
		device.setB(5);
		device.process();
		System.out.println(device.getResult());
	}
	
	public void test(Multiplier device)
	{
		device.setA(2);
		device.setB(5);
		device.process();
		System.out.println(device.getResult());
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test=new Test();
		Adder adder=new Adder();
		Multiplier mul=new Multiplier();
		test.test(adder);
		test.test(mul);
		
	}

}
