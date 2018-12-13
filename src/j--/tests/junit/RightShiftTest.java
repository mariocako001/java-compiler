package junit;

import junit.framework.TestCase;
import pass.RightShift;


public class RightShiftTest extends TestCase {
	private RightShift rshift; 

	protected void setUp() throws Exception{
		super.setUp();
		rshift = new RightShift();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testRightShift(){
		this.assertEquals(rshift.rightShift(32,5),1);
		this.assertEquals(rshift.rightShift(64,3),8);
		this.assertEquals(rshift.rightShift(512,1),256);
	}
}
