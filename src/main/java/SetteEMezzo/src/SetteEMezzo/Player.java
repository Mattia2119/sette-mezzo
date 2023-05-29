package SetteEMezzo.src.SetteEMezzo;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	//VARIBILI D'ISTANZA
	private List<Card> hand = new ArrayList<>();
	private String name;
	private boolean sballato = false;
	
	
	//COSTRUTTORI
	public Player(String  name) {
		this.name = name;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSballato(boolean sballato) {
		this.sballato = sballato;
	}

	public void addCard(Card card) {
		hand.add(card);
		System.out.println(name + " ha pescato " + card +"\n");
	}
	
//	public void refuseCard() {
//		hand.remove(hand.size()-1);
//	}
	
	public double calculateScore() {
		double score = 0.0;
		for (Card card : hand) {
			if(card.getNumero() == 8 || card.getNumero() == 9 || card.getNumero() == 10) {
				score += 0.5;
			} else {
				score += card.getNumero();
			}	
		}
		return score;
	}

	//METODO TO STRING
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	

	


}
