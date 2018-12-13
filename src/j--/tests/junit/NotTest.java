package junit;

import junit.framework.TestCase;
import pass.Not;


public class NotTest extends TestCase {
	private Not n;

	protected void setUp() throws Exception{
		super.setUp();
		n = new Not();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testNot(){
		this.assertEquals(n.not(1),-2);
		this.assertEquals(n.not(127),-128);
		this.assertEquals(n.not(1024),-1025);
	}
}
