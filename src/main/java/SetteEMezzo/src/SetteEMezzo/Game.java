package SetteEMezzo.src.SetteEMezzo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game {

	private static List<Player> players;

	public Game() {
		this.players = new ArrayList<Player>();
	}

	public static void main(String[] args) {

		Game game = new Game();

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
					player1.setSballato(true);
					stopPlayer1 = true;
				}
			} else {
				System.out.println(player1.getName() + " sta! con " + player1.calculateScore() + " punti\n");
				players.add(player1);
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
					player2.setSballato(true);
					stopPlayer2 = true;
				}
			} else {
				System.out.println(player2.getName() + " sta! con " + player2.calculateScore() + " punti\n");
				players.add(player2);
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
					banco.setSballato(true);
					stopBanco = true;
				}
			} else {
				System.out.println(banco.getName() + " sta! con " + banco.calculateScore() + " punti\n");
				players.add(banco);
				stopBanco = true;
			}
		}

		game.getWinner();
		input.close();

	}

	public void getWinner() {
		Iterator<Player> it = players.iterator();
		Player first = it.next();
		while(it.hasNext()) {
			if(first.calculateScore() < it.next().calculateScore()) {
				first = it.next();
			}
		}
		System.out.println(first.getName() + " Ha vinto questa mano! ");
	}

}
