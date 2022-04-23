
public class MainEventi {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Eventi ev = new Eventi();
		
		String nome = "Nello";
		
		ev.crea(nome, 10);
		ev.listaEventi();
		
		ev.aggiungi(nome, 20);
		ev.listaEventi();
		
		ev.prenota(nome, 5);
		ev.listaEventi();
		
		ev.chiudi(nome);
		System.out.println("---");
		ev.listaEventi();
		
	}

}
