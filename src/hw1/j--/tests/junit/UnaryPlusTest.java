package junit;

import junit.framework.TestCase;
import pass.UnaryPlus;


public class UnaryPlusTest extends TestCase {
	private UnaryPlus uPlus;

	protected void setUp() throws Exception{
		super.setUp();
		uPlus = new UnaryPlus();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testUnaryPlus(){
		this.assertEquals(uPlus.unaryPlus(-1),-1);
		this.assertEquals(uPlus.unaryPlus(5),5);
		this.assertEquals(uPlus.unaryPlus(-127),-127);
	}
}
