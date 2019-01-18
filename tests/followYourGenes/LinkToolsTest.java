package followYourGenes;

import static org.junit.Assert.*;

import java.time.*;

import org.junit.Before;
import org.junit.Test;

public class LinkToolsTest {
	
	Tree t;
	
	@Before
	public void setUp() throws Exception {
		t = new Tree("Fammille Test");
		t.ajouterPersonne(	"Lee", 
							"Test", 
							"",
							LocalDate.of(1968, 8, 29), 
							"",
							LocalDate.of(1999, 10, 30), 
							TypeSex.Homme,
							1, 
							"");
		
		t.ajouterPersonne(	"Lou", 
							"Test", 
							"",
							LocalDate.of(1962, 2, 9), 
							"",
							LocalDate.of(1999, 11, 30), 
							TypeSex.Femme,
							2, 
							"");
	}
	
	@Test
	public void testIsAnterior() {
		boolean b;
		b = LinkTools.isAnterior(t.getPersonne(1).getBirthDate(), t.getPersonne(2).getBirthDate());
		assertFalse(b);
	}

	@Test
	public void testValidateHLink() {
		boolean b;
		b = LinkTools.validateHLink(t, 1, 2);
		assertTrue(b);
	}

	@Test
	public void testIsOrderedLinkV() {
		
	}

}
