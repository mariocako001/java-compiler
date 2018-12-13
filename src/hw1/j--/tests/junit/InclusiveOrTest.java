package junit;

import junit.framework.TestCase;
import pass.InclusiveOr;


public class InclusiveOrTest extends TestCase {
	private InclusiveOr inOr;

	protected void setUp() throws Exception{
		super.setUp();
		inOr = new InclusiveOr();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testInclusiveOr(){
		this.assertEquals(inOr.inclusiveOr(0,42),42);
		this.assertEquals(inOr.inclusiveOr(42,1),43);
		this.assertEquals(inOr.inclusiveOr(127,3),127);
	}
}
