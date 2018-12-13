package junit;

import junit.framework.TestCase;
import pass.Remainder;


public class RemainderTest extends TestCase {
	private Remainder r;

	protected void setUp() throws Exception{
		super.setUp();
		r = new Remainder();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testRemainder(){
		this.assertEquals(r.remainder(0,42),0);
		this.assertEquals(r.remainder(10,3),1);
		this.assertEquals(r.remainder(127,3),1);
	}
}
