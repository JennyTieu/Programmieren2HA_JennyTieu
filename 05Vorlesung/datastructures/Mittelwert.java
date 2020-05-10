package datastructures;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jenny
 *
 */
public class Mittelwert {
	public static double eingabe;
	public static double summe = 0;
	public static String quitGame;
	public static boolean isRunning = true;

	public static void main(String[] args) {
		LinkedList<Double> list = new LinkedList<>();
		System.out.println("Bitte gebe einen double Wert ein!:");
		while (isRunning == true) {
			Scanner sc = new Scanner(System.in);

			if (!sc.hasNextDouble()) {
				quitGame = sc.next();
				if (quitGame.equals("quit")) {
					sc.close();
					isRunning = false;
				} else {
					System.out.println("Invalid input \nBitte gebe einen double Wert ein!:");
				}
			} else {
				eingabe = sc.nextDouble();
				list.add(eingabe);
			}
		}

		for (double ele : list) {
			summe += ele;
		}
		System.out.println("Der Mittelwert: " + summe / list.size());

	}

}
