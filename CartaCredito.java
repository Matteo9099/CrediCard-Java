import java.util.Scanner;

public class CartaCredito {
	private String numero;
	private int codiceUnivoco;
	private String nome;
	
	public void leggiInput() {
		verificaNome();
		numeroValido();
		CodiceUnivoco();
		conferma();
	}
	
	// verifica numero a 20 int
	public void numeroValido() {
		System.out.println("Inserisci numero carta di credito:");
		Scanner input = new Scanner(System.in);
		numero = input.nextLine();
		
		while(numero.length() < 16 || numero.length() > 16) {
			System.out.println("ERRORE: Carta non valida! deve contenere 16 numeri");
			System.out.println("Inserisci numero carta di credito:");
			numero = input.nextLine();
		} 
	}
	
	// verifica codice univoco
	public void CodiceUnivoco() {
		System.out.println("Inserisci il codice a 3 cifre:");
		Scanner input = new Scanner(System.in);
		codiceUnivoco = input.nextInt();
		String cv = Integer.toString(codiceUnivoco);
		while(cv.length() < 3 || cv.length() > 3) {
			System.out.println("ERRORE: numero cv non valido! deve contenere 3 numeri");
			System.out.println("Inserisci numero cv:");
			codiceUnivoco = input.nextInt();
			cv = Integer.toString(codiceUnivoco);
		}
	}
	
	// verifica nome
	public void verificaNome() {
		System.out.println("Inserisci nome intestatario:");
		Scanner input = new Scanner(System.in);
		nome = input.nextLine();
		while(nome.length() <= 2 || nome.length() >= 50) {
			System.out.println("ERRORE: nome non leggibile.");
			System.out.println("Inserisci nome intestatario della carta di credito:");
			nome = input.nextLine();
		}
	}
	
	// conferma dati
	public void conferma() {
		System.out.println("I tuoi dati:");
		System.out.println("Nome: " + getNome());
		System.out.println("numero carta: " + getNumero());
		System.out.println("CodiceCv: " + getcodiceUnivoco());
        System.out.println("Confermi?");
		
		Scanner input = new Scanner(System.in);
		String risposta = input.nextLine();
		if(risposta.equalsIgnoreCase("si")) {
			System.out.println("Carta di credito confermata");
		} else {
			modifica();
		}
	}
	
	// modifica dati
	public void modifica() {
		System.out.println("Cosa vuoi modificare?");
		System.out.println("1 - Nome \n2 - numero \n3 - Codice Cv");
		
		Scanner input = new Scanner(System.in);
		int modifica = input.nextInt();
		switch(modifica) {
		case 1:
			verificaNome();
			break;
		case 2:
			numeroValido();
			break;
		case 3:
			CodiceUnivoco();
			break;
		default:
			System.out.println("Inserisci un valore valido.");
		}
		conferma();
	}
	
	
	// Getter
	public String getNome() {
		return this.nome;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public int getcodiceUnivoco() {
		return this.codiceUnivoco;
	}
	
}