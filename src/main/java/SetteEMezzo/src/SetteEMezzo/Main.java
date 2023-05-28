package SetteEMezzo.src.SetteEMezzo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Inizializzo il mazzo
		Player banco = new Player("Il banco");
		
		Mazzo mazzo = new Mazzo();
		
		System.out.println(mazzo);
		
		//Avvio uno scanner che interagisca con l'utente
		Scanner input = new Scanner(System.in);
		
		System.out.println("Benvenuto a Sette e Mezzo 1v1!\n");
		
		System.out.println("Inserisci il nome del player 1 e premi Enter");
		
		String namePlayer1 = input.nextLine();
		
		Player player1 = new Player(namePlayer1);
		
		System.out.println("Inserisci il nome del player 2 e premi Enter");
		
		String namePlayer2 = input.nextLine();
		
		Player player2 = new Player(namePlayer2);	
		
		System.out.println("\n"+ player1 + " sfida " + player2 + "!\n");
		
		System.out.println(player1 + " è il primo a pescare...\n");
		
		player1.addCard(mazzo.takeCard());
		
		boolean stopPlayer1 = false;
		while(stopPlayer1 == false) {
			System.out.println("vuoi pescare un'altra carta? (digita s/n)" );
			String choice = input.nextLine();
			if(choice.equals("s")) {
				player1.addCard(mazzo.takeCard());
				System.out.println(player1.getName() + " ha in mano " + player1.getHand() + "\n");	
				if(player1.calculateScore() > 7.5) {
					System.out.println(player1.getName() + " HA SBALLATO!\n");
					stopPlayer1 = true;
				}
			} else {
				System.out.println(player1.getName() + " sta! con " + player1.calculateScore() + " punti\n");
				stopPlayer1 = true;
			}
		
		}
		
		System.out.println(player2 + " è il secondo a pescare...\n");
		
		player2.addCard(mazzo.takeCard());
			
		boolean stopPlayer2 = false;
		while(stopPlayer2 == false) {
			System.out.println("vuoi pescare un'altra carta? (digita s/n)" );
			String choicePlayer2 = input.nextLine();
			if(choicePlayer2.equals("s")) {
				player2.addCard(mazzo.takeCard());
				System.out.println(player2.getName() + " ha in mano " + player2.getHand() + "\n");
				if(player2.calculateScore() > 7.5) {
					System.out.println(player2.getName() + " HA SBALLATO!\n");
					stopPlayer2 = true;
				}
			} else {
				System.out.println(player2.getName() + " sta! con " + player2.calculateScore() + " punti\n");
				stopPlayer2 = true;
			}
			
			
		}
		
		System.out.println(banco.getName() + " è l'ultimo a pescare...\n");
		
		banco.addCard(mazzo.takeCard());
		
		boolean stopBanco = false;
		while(stopBanco == false) {
			System.out.println("vuoi pescare un'altra carta? (digita s/n)" );
			String choiceBanco = input.nextLine();
			if(choiceBanco.equals("s")) {
				banco.addCard(mazzo.takeCard());
				System.out.println(banco.getName() + " ha in mano " + banco.getHand() + "\n");
				if(banco.calculateScore() > 7.5) {
					System.out.println(banco.getName() + " HA SBALLATO!\n");
					stopBanco = true;
				}
			} else {
				System.out.println(banco.getName() + " sta! con " + banco.calculateScore() + " punti\n");
				stopBanco = true;
			}
			
			
		}
		
		input.close();	
		
	}
	

}
