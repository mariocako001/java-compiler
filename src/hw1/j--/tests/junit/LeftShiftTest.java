package junit;

import junit.framework.TestCase;
import pass.LeftShift;


public class LeftShiftTest extends TestCase {
	private LeftShift lshift; 

	protected void setUp() throws Exception{
		super.setUp();
		lshift = new LeftShift();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testLeftShift(){
		this.assertEquals(lshift.leftShift(1,2),4);
		this.assertEquals(lshift.leftShift(10,3),80);
		this.assertEquals(lshift.leftShift(127,3),1016);
	}
}
