package regextool;

import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseController {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private RegexChecker regexChecker = new RegexChecker();
	private ArrayList<Exercise> exercises;
	private int level = Exercise.BEGINNER;

	public void init() {
		exercises = SaveStatus.readStatus();
		if(exercises == null || exercises.size() == 0) {
			ExerciseLoader loader = new ExerciseLoader();
			exercises = loader.load();			
		}
		loop();
		SaveStatus.writeStatus(exercises);
	}

	private void loop() {
		Scanner in = new Scanner(System.in);
		while(level != Exercise.END) {
			exerciseLevel(in);
			printResult();

			
		}
		in.close();

	}

	protected void exerciseLevel(Scanner in) {
		for (Exercise exercise : exercises) {
			if (level == exercise.getLevel()) {

				while(!exercise.isSucceded()) {
					displayExercise(exercise);
					checkSolution(in, exercise);
					displayFeedback(exercise);
					 
					if(!exercise.isSucceded()) {
						System.out.println("(a) nächste Aufgabe\n(t) Tipp\n(b) beenden und sichern\n( ) nächster Versuch :)");
						String answer = in.nextLine();
						if(answer.toLowerCase().matches("[t].*")) {
							System.out.println("--------------------------- Tipp -------------------------------------------");
							System.out.println("\n" +exercise.nextHint()+"\n");
							System.out.println("----------------------------------------------------------------------------");
						}
						else if(answer.toLowerCase().matches("[a].*")) {
							System.out.println("\n-------------------- nächste Aufgabe ----------------------------------\n");
							break;
						} else if(answer.toLowerCase().matches("[b].*")) {
							SaveStatus.writeStatus(exercises);
							SaveStatus.writeFeedback(exercises);
							System.exit(0);
						} else {
							System.out.println("\n---------------------- nächster Versuch --------------------------------\n");							
						}
						exercise.reset();
					}
				}
			}
		}
	}

	protected void checkSolution(Scanner in, Exercise exercise) {
		System.out.println("Bitte gib deinen regex ein:");
		String pattern = in.nextLine();
		exercise.setAnswer(pattern);
		try {
			if (regexChecker.checkWords(pattern, exercise.getGoodWords(), exercise.getBadWords())) {
				exercise.setSucceded(true);
			} else {
				exercise.setSucceded(false);
			}			
		} catch (Exception e) {
			System.err.println("Deine Regex Syntax hat einen Fehler:" + e.getMessage());
			exercise.setSucceded(false);
		}
	}

	protected void displayFeedback(Exercise exercise) {
		System.out.println(
				"\nAlle Wörter sollten grün sein. Alles was nicht erkannt wird, wird rot dargestellt.");
		output(exercise.getGoodWords(), ANSI_GREEN, ANSI_RED);
		System.out.println("\nAlle Wörter sollten blau sein. Alles was erkannt wird, wird pink dargestellt.");
		output(exercise.getBadWords(), ANSI_PURPLE, ANSI_BLUE);

		if (exercise.isSucceded()) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\nSuper gemacht!");
			System.out.println("\n-------------------- nächste Aufgabe ----------------------------------\n");
		} else {
			System.out.println("Noch nicht ganz. Versuch es doch noch mal :)");

		}
	}



	protected void displayExercise(Exercise exercise) {
		System.out.println(exercise.getText());
		System.out.println("Diese Wörter solltest du erkennen:");
		output(exercise.getGoodWords(), ANSI_GREEN, ANSI_GREEN);
		System.out.println("Diese Wörter solltest du nicht erkennen:");
		output(exercise.getBadWords(), ANSI_RED, ANSI_RED);
	}

	public void output(ArrayList<Word> words, String colorOK, String colorNOk) {

		for (Word word : words) {
			for (int i = 0; i < word.getIsMatched().length; i++) {
				if (word.getIsMatched()[i]) {
					System.out.print(colorOK + word.getWord().charAt(i) + ANSI_RESET);
				} else {
					System.out.print(colorNOk + word.getWord().charAt(i) + ANSI_RESET);
				}
			}
			System.out.println();
		}
	}

	public void printResult() {
		String oldLevel = "";
		String newLevel = "";
		switch (level) {
		case Exercise.BEGINNER:
			oldLevel = "Beginner";
			newLevel = "Middle";
			level = Exercise.MIDDLE;
			break;
		case Exercise.MIDDLE:
			oldLevel = "Middle";
			newLevel = "Advanced";
			level = Exercise.ADVANCED;
			break;
		case Exercise.ADVANCED:
			oldLevel = "Advanced";
			newLevel = "Chuck Norris";
			level = Exercise.CHUCK_NORRIS;
			break;
		case Exercise.CHUCK_NORRIS:
			oldLevel = "Chuck Norris";
			level = Exercise.END;
			newLevel = "Nach Chuck Norris kann es nichts mehr geben. Selbst die Jedis verbeugen sich vor ihm.";
			break;
		default:
			oldLevel = "Beginner";
			level = Exercise.END;
			newLevel = "Nach Chuck Norris kann es nichts mehr geben. Selbst die Jedis verbeugen sich vor ihm.";
			break;
		}
		System.out.println("Du hast das Level " + oldLevel + " absolviert. Herzlichen Glückwunsch!\n\n");
		if(level != Exercise.END) {
			System.out.println("Du befindest dich nun im Level " + newLevel + ". Möge die Macht mit dir sein ;)\n\n");
		}
		else {
			System.out.println(newLevel);
		}
	}

}
