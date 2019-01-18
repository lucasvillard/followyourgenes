package followYourGenes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkHTest {
	
	LinkH l;

	@Before
	public void setUp() throws Exception {
		l = new LinkH(TypeLinkUnion.marriage, 1, 2, null);
	}

	@Test
	public void testLinkH() {
		assertNotNull(l);
		assertEquals(TypeLinkUnion.marriage, l.getTypeLink());
		assertEquals(1, l.getId1());
		assertEquals(2, l.getId2());
	}

}
