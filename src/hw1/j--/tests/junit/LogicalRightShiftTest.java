package junit;

import junit.framework.TestCase;
import pass.LogicalRightShift;


public class LogicalRightShiftTest extends TestCase {
	private LogicalRightShift lrShift; 

	protected void setUp() throws Exception{
		super.setUp();
		lrShift = new LogicalRightShift();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testLogicalRightShift(){
		this.assertEquals(lrShift.logicalRightShift(32,5),1);
		this.assertEquals(lrShift.logicalRightShift(64,3),8);
		this.assertEquals(lrShift.logicalRightShift(512,1),256);
	}
}
