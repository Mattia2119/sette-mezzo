package SetteEMezzo.src.SetteEMezzo;

public class Card {

	//VSRIABILI D'ISTANZA
	private final double numero;
	private final Seme seme;
	
	//COSTRUTTORE
	public Card(int numero, Seme seme) {
		this.numero = numero;
		this.seme = seme;
	}
	
	//METODI GETTERS E SETTERS
	public double getNumero() {
		return numero;
	}
	
	public int printNumero() {
		return (int) numero;
	}

	public Seme getSeme() {
		return seme;
	}
	
	//METODO TO STRING
	@Override
	public String toString() {
		return printNumero() +" di "+ seme;
	}
	
	
	
	
}
