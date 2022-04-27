import java.util.HashMap;

public class MainEventi {

	public static void main(String[] args) throws InterruptedException
	{
		String nome = "Nello";
		
		
		//CONCORRENTE vedi: Sincronizzazione
		
		/*Eventi t1 = new Eventi();
		t1.crea(nome, 5);
		t1.crea("pippo", 10);
		
		HashMap<String, Integer> eventi = t1.getEventi();
		eventi.replace(nome, eventi.get(nome)+5);
		
		t1.listaEventi();*/
		
		Eventi e = new Eventi();
		Utente u1, u2;
		Admin a1, a2;
		
		String s1 = "Nello";
		String s2 = "Bro";
		
		u1 = new Utente(e);
		u2 = new Utente(e);
		
		a1 = new Admin(e);
		a2 = new Admin(e);
		
		a1.start();
		u1.start();
		
		a1.run(s1, 5);
		System.out.println();
		a2.run(s2, 5);
		System.out.println();
		u1.run(s1, 1);
		
		
	}

}
