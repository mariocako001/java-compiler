package junit;

import junit.framework.TestCase;
import pass.ExclusiveOr;


public class ExclusiveOrTest extends TestCase {
	private ExclusiveOr exOr;

	protected void setUp() throws Exception{
		super.setUp();
		exOr = new ExclusiveOr();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testExclusiveOr(){
		this.assertEquals(exOr.exclusiveOr(0,42),42);
		this.assertEquals(exOr.exclusiveOr(42,1),43);
		this.assertEquals(exOr.exclusiveOr(127,3),124);
	}
}
