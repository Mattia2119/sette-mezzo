package SetteEMezzo.src.SetteEMezzo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Mazzo {
	
	//VARIABILI D'ISTANZA
	private List<Card> deck;
	
	//COSTRUTTORE
	//In questo modo la classe potrà essere istanziata senza dover passare parametri in input
	//e nel momento in cui verrà istanziata genera il deck;
	public Mazzo() {
		this.deck = new ArrayList<Card>();
		generateDeck();
		Collections.shuffle(deck);
	}
	
	//FUNZIONE PER GENERARE IL DECK
	private void generateDeck() {
		
		for (int i = 1; i <= 10; i++) {
			Card card = new Card(i, Seme.BASTONI);
			deck.add(card);
		}
		
		for (int i = 1; i <= 10; i++) {
			Card card = new Card(i, Seme.SPADE);
			deck.add(card);
		}
		
		for (int i = 1; i <= 10; i++) {
			Card card = new Card(i, Seme.DENARA);
			deck.add(card);
		}
		
		for (int i = 1; i <= 10; i++) {
			Card card = new Card(i, Seme.COPPE);
			deck.add(card);
		}	
		
	}

	//METODO TO STRING
	@Override
	public String toString() {
		return "Mazzo = " + deck;
	}
	
	//METODO GETTER
	public Collection<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	public Card takeCard() {
		Card cartaPescata = deck.remove(0);
		return cartaPescata;
	}
}
