import static org.junit.Assert.*;

import org.junit.Test;

public class BillTest {

	@Test
	public void test() 
	{
		Bill b=new Bill(11111,"qing","qiu",1980,12345);
		String str=b.toString();
		assertEquals(str,"11111  qing  qiu  1980  12345");
	}

}
