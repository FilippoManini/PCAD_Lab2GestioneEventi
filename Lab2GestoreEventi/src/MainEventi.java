import java.util.HashMap;

public class MainEventi {

	public static void main(String[] args) throws InterruptedException
	{
		String nome = "Nello";
		//single thread
		/*Eventi ev = new Eventi();
		
		
		ev.crea(nome, 10);
		ev.listaEventi();
		
		ev.aggiungi(nome, 20);
		ev.listaEventi();
		
		ev.prenota(nome, 5);
		ev.listaEventi();
		
		ev.chiudi(nome);
		System.out.println("---");
		ev.listaEventi();*/
		
		//CONCORRENTE vedi: Sincronizzazione
		HashMap<String, Integer> eventi = new HashMap<String, Integer>();
		
		Eventi t1 = new Eventi();
		Eventi t2 = new Eventi();
		Eventi t3 = new Eventi();
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.crea(nome, 10, eventi);
		t3.prenota(nome, 1, eventi);
		t2.crea("Gem", 5, eventi);
		t3.aggiungi(nome, 5, eventi);
		t1.listaEventi(eventi);
	}

}
