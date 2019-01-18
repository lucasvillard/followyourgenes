package followYourGenes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkTest {
	
	Link l;

	@Before
	public void setUp() throws Exception {
		l = new Link(1, 2, new Tree("Tree Test"));
	}

	@Test
	public void testGetId1() {
		int id1 = l.getId1();
		assertEquals(1, id1);
	}

	@Test
	public void testGetId2() {
		assertEquals(1, l.getId1());
	}

	@Test
	public void testGetT() { 
		assertEquals(new Tree("Tree Test"), l.getT());
	}

}
