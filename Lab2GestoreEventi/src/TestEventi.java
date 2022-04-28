import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestEventi 
{
	Eventi e = new Eventi();
	Utente u1, u2;
	Admin a1, a2;
	
	String s1 = "Nello";
	String s2 = "Bro";
	/*
	@Before
	public void setUp()
	{
		e = new Eventi();
		
		u1 = new Utente(e);
		u2 = new Utente(e);
		
		a1 = new Admin(e);
		a2 = new Admin(e);
	}
	*/
	@Test
	public void testAdmin()
	{
		//a1.run(s1, 5);
		//assertEquals(e.getEventi().get(s1), 10);
		//assertEquals(e, null);
	}
}
