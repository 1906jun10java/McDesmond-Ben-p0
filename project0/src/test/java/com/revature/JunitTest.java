package test.java.com.revature;



import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.services.Utility;

public class JunitTest {
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void nonNumberReturnsFalse() {
		assertFalse(Utility.tryParseInt("bacon"));
	}
	

}
