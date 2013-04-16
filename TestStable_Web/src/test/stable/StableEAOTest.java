package test.stable;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

import ebj.eao.StableEntityAccessLocal;
import ejb.stablepkg.Stable;
import junit.framework.TestCase;

public class StableEAOTest extends TestCase {
	
	@EJB
	StableEntityAccessLocal stableLocal;
	
	final long expectedStableNumber = 999;
	final String expectedStableName = "richard stallman";
	
	final long expectedStableNumber2 = 998;
	final String expectedStableName2 = "stallet";

	
	public StableEAOTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		Context context = new InitialContext();
		stableLocal = (StableEntityAccessLocal)context.lookup("java:app/Stable/StableEntityAccess!ebj.eao.StableEntityAccess");
	
		cleanUp();
		Stable stable = new Stable();
		stable.setStableNumber(expectedStableNumber);
		stable.setStableName(expectedStableName);
		
		stableLocal.createStable(stable);
	
	}

	protected void tearDown() throws Exception {
		
		cleanUp();
	}
	
	public void testFindByStableNumber() throws Exception {
		Stable stable = stableLocal.findByStableNumber(expectedStableNumber);
		assertEquals(stable.getStableNumber(), expectedStableNumber);
		assertEquals(stable.getStableName(), expectedStableName);
	}
	
	public void testCreateStable() throws Exception {
		Stable stable = new Stable();
		stable.setStableNumber(expectedStableNumber2);
		stable.setStableName(expectedStableName2);
		stable = stableLocal.createStable(stable);
		
		assertNotNull(stable);
		assertEquals(stable.getStableNumber(), expectedStableNumber2);
		assertEquals(stable.getStableName(), expectedStableName2);	
	}
	
	public void testDeleteStable() throws Exception {
		if (stableLocal.findByStableNumber(expectedStableNumber2) != null) {
			stableLocal.deleteStable(expectedStableNumber2);
		}
		assertNull(stableLocal.findByStableNumber(expectedStableNumber2));
	}
	
	
	
	private void cleanUp() {
		if(stableLocal.findByStableNumber(expectedStableNumber) != null) {
			stableLocal.deleteStable(expectedStableNumber);
		}
		
		if(stableLocal.findByStableNumber(expectedStableNumber2) != null) {
			stableLocal.deleteStable(expectedStableNumber2);
		}
	}

}
