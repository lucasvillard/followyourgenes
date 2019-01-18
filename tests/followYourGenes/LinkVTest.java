package followYourGenes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkVTest {

	LinkV l;

	@Before
	public void setUp() throws Exception {
		l = new LinkV(1, 2, null);
	}

	@Test
	public void testLinkH() {
		assertNotNull(l);
	}

}
