package regextool;

import java.util.ArrayList;

public class ExerciseLoader {

	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	private static final String HINT_SMALL_LETTERS = "Mit [a-z] kann man sagen, dass nur Kleinbuchstaben akteptiert sind.";
	private static final String HINT_SMALL_LETTERS_RED = "Mit [b-u] kann man sagen, dass nur kleine Buchstaben von b bis u akteptiert sind.";
	private static final String HINT_PLUS = "Mit [e]+ kann man sagen, dass man mindestens 1 e bis beliebig viele e haben möchte.";
	private static final String HINT_BEGINN = "Mit \"^a\" kann man sagen, dass ein String mit einem a beginnen soll.";
	private static final String HINT_END = "Mit \"a$\" kann man sagen, dass ein String mit einem a enden soll.";
	private static final String HINT_ANY_CHAR = "Mit . kann man sagen, dass man jedes Zeichen erlaubt. z.B. \"o\" oder \"?\" oder \"2\"";
	private static final String HINT_STAR = "Mit dem Sternchen (z.B. e*) kann man sagen, dass man ein Zeichen 0 Mal bis beliebig oft erlaubt ist. Z.B. eeeeee";
	private static final String HINT_WORD = "Soll bestimmte Zeichen wie z.B. \"nie\" in einem Wort enthalten sein, schreibt man \"nie\" in den reguären Ausdruck.";
	private static final String HINT_NUMBERS = "Mit \\d kann man sagen, dass nur Zahlen akteptiert sind. Das gleiche sagt man auch mit [0-9]";
	private static final String HINT_LETTERS_NUM = "Mit [a-e0-3] kann man sagen, dass Kleinbuchstaben von a bis e und Zahlen von 0-3 akteptiert sind. ";
	private static final String HINT_LETTERS_UL = "Mit [a-eA-F] kann man sagen, dass Kleinbuchstaben von a bis e und Großbuchstaben von A bis F akteptiert sind. ";
	private static final String HINT_WHITE_SPACE = "Mit \\s kann man sagen, dass Whitespace also \\n oder \\t oder Leertaste akteptiert sind. ";
	private static final String HINT_SPECIAL = "Mit [.] oder \\. kann man sagen, dass wir einen Punkt akteptiert sind. Wenn ein Zeichen wie ein Punkt eine spezielle Bedeutung hat wie . oder + oder ?, dann muss man das auf diese Weise schreiben";
	private static final String HINT_NUM_TIMES = "Mit e{2} oder e{6,10} oder e{1,} kann man sagen, ob z.B. ein \"e\" exakt 2 mal auftauchen solle{2}, mindestens 6 Mal aber maximal 10 Mal e{6,10} oder mindestens einmal e{1,}.";
	private static final String HINT_OR = "Mit (a)|(b) kann man sagen, dass entweder a oder b akteptiert wird. ";
	
	
	public ArrayList<Exercise> load() {

		loadExercises01();
		loadExercises02();
		loadExercises03();
		loadExercises04();

		loadExercises11();
		loadExercises12();
		loadExercises13();
		loadExercises14();

		loadExercises51();
		loadExercises52();
		loadExercises53();
		loadExercises54();
		loadExercises55();
		loadExercises56();
		loadExercises57();

		loadExercises62();
		loadExercises63();
		loadExercises61();
		return exercises;
	}

	private void loadExercises01() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("laufen"));
		goodWords.add(new Word("saufen"));
		goodWords.add(new Word("Rauf"));
		goodWords.add(new Word("auf dem"));
		goodWords.add(new Word("taufen"));
		goodWords.add(new Word("kaufen"));
		goodWords.add(new Word("raufen"));
		goodWords.add(new Word("Schaufel"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("aus"));
		badWords.add(new Word("tauchen"));
		badWords.add(new Word("raus"));
		badWords.add(new Word("laut"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("au f"));
		badWords.add(new Word("genau"));
		badWords.add(new Word("ufff"));

		String text = "Filtert nach Wörtern, die ein \"auf\" enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		
		Exercise exercise = new Exercise(Exercise.BEGINNER, text, goodWords, badWords);
		exercise.addHints(HINT_WORD);
		exercise.addHints(HINT_ANY_CHAR);
		exercise.addHints(HINT_STAR);		
		exercises.add(exercise);

	}

	private void loadExercises02() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("laufen"));
		goodWords.add(new Word("rauf"));
		goodWords.add(new Word("tauchen"));
		goodWords.add(new Word("raus"));
		goodWords.add(new Word("laut"));
		goodWords.add(new Word("raufen"));
		goodWords.add(new Word("schaufeln"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("AHHH"));
		badWords.add(new Word("1.1.89"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("42"));
		badWords.add(new Word("OH NO"));

		String text = "Filtert nach Wörtern, die Kleinbuchstaben enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.BEGINNER, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);
		exercise.addHints(HINT_ANY_CHAR);
		exercise.addHints(HINT_STAR);		
		exercises.add(exercise);
	}

	private void loadExercises03() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("123"));
		goodWords.add(new Word("42"));
		goodWords.add(new Word("89"));
		goodWords.add(new Word("1987"));
		goodWords.add(new Word("7"));
		goodWords.add(new Word("12345"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("laut"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("au f"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("OH NO"));

		String text = "Filtert nach Ausdrücken, die Zahlen enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.BEGINNER, text, goodWords, badWords);
		exercise.addHints(HINT_NUMBERS);
		exercise.addHints(HINT_PLUS);		
		exercises.add(exercise);
	}

	private void loadExercises04() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Was"));
		goodWords.add(new Word("Nein"));
		goodWords.add(new Word("ohhhhh"));
		goodWords.add(new Word("nanu"));
		goodWords.add(new Word("Digga"));
		goodWords.add(new Word("suPer"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("89.1"));
		badWords.add(new Word("..."));
		badWords.add(new Word("-.-"));
		badWords.add(new Word("!!"));
		badWords.add(new Word(" . "));
		badWords.add(new Word("#++++#"));
		badWords.add(new Word("00011101101"));

		String text = "Filtert nach Ausdrücken, die sowohl Klein- als auch Großbuchstauben enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.BEGINNER, text, goodWords, badWords);
		exercise.addHints(HINT_LETTERS_UL);
		exercise.addHints(HINT_PLUS);		
		exercises.add(exercise);
	}

	private void loadExercises11() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Was geht"));
		goodWords.add(new Word("Richtig gut"));
		goodWords.add(new Word("oh\tno"));
		goodWords.add(new Word("heute morgen"));
		goodWords.add(new Word("alles\nklar"));
		goodWords.add(new Word("gut gemacht"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("WasGeht?"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("nope"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));

		String text = "Filtert nach Ausdrücken, die ein Whitespace (Leertaste, Zeilenumbruch, Tab) enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.MIDDLE, text, goodWords, badWords);
		exercise.addHints(HINT_WHITE_SPACE);
		exercise.addHints(HINT_ANY_CHAR);		
		exercise.addHints(HINT_PLUS);		
		exercises.add(exercise);
	}

	private void loadExercises12() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("eine"));
		goodWords.add(new Word("abcd"));
		goodWords.add(new Word("nie"));
		goodWords.add(new Word("klmn"));
		goodWords.add(new Word("man"));
		goodWords.add(new Word("naja"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("nur"));
		badWords.add(new Word("nass"));
		badWords.add(new Word("sag"));
		badWords.add(new Word("WTF"));
		badWords.add(new Word("falsch"));
		badWords.add(new Word("Y/N?"));

		String text = "Filtert nach Wörtern, die nur aus Kleinbuchstaben von a - n bestehen. "
				+ "\nIn Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.MIDDLE, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);
		exercise.addHints(HINT_SMALL_LETTERS_RED);		
		exercise.addHints(HINT_PLUS);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);

	}

	private void loadExercises13() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("3.1.2009"));
		goodWords.add(new Word("98.13.1123"));
		goodWords.add(new Word("23.12.2123"));
		goodWords.add(new Word("10.00.9999"));
		goodWords.add(new Word("43.2.23"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("2.2.2"));
		badWords.add(new Word("332.12.1232"));
		badWords.add(new Word("34.32.41232"));
		badWords.add(new Word("te.st.test"));
		badWords.add(new Word("gut gemacht!"));

		String text = "Filtert nach Ausdrücken, die mit 1-2 Zahlen bestehen, gefolgt von 1-2 Zahlen, gefolgt von 2-4 Zahlen."
				+ "\nIn Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.MIDDLE, text, goodWords, badWords);
		exercise.addHints(HINT_NUMBERS);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_NUM_TIMES);		
		exercises.add(exercise);
	}

	private void loadExercises14() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("www.test.de"));
		goodWords.add(new Word("www.huhu.de"));
		goodWords.add(new Word("www.WasGeht.de"));
		goodWords.add(new Word("www.naklar.de"));
		goodWords.add(new Word("www.logo.de"));
		goodWords.add(new Word("www.developper4future.de"));

		ArrayList<Word> badWords = new ArrayList<Word>();

		badWords.add(new Word("www.na-klar.de"));
		badWords.add(new Word("www.test.org"));
		badWords.add(new Word("www,yo,digga"));
		badWords.add(new Word("schauen wir mal"));
		badWords.add(new Word("www.ja oder nein.de"));
		badWords.add(new Word("www.Das.geht.so.nicht.de"));

		String text = "Filtert nach Ausdrücken, die mit www. beginnen und mit .de aufhören. Dazwischen dürfen nur Groß- und Kleinbuchstaben sowie Zahlen stehen. "
				+ "\nIn Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.MIDDLE, text, goodWords, badWords);
		exercise.addHints(HINT_WORD);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_LETTERS_NUM);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_NUM_TIMES);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		

		exercises.add(exercise);
	}

	private void loadExercises51() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Sonne"));
		goodWords.add(new Word("sonnig"));
		goodWords.add(new Word("saß"));
		goodWords.add(new Word("sitzen"));
		goodWords.add(new Word("Sessel"));
		goodWords.add(new Word("singen"));
		goodWords.add(new Word("sammeln"));
		goodWords.add(new Word("suchen"));
		goodWords.add(new Word("sagen"));
		goodWords.add(new Word("Sage"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("aus"));
		badWords.add(new Word("reißen"));
		badWords.add(new Word("Spliss"));
		badWords.add(new Word("Spross"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("hu hu"));
		badWords.add(new Word("singe2"));
		badWords.add(new Word("sing2e"));

		String text = "Filtert nach Wörtern, die mit s oder S beginnen, aber nicht mit s aufhören. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);		
		exercise.addHints(HINT_LETTERS_NUM);
		exercise.addHints(HINT_STAR);	
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		

		exercises.add(exercise);
	}

	private void loadExercises52() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Martin Max Mustermann"));
		goodWords.add(new Word("Mira van Hagen"));
		goodWords.add(new Word("Torsten de Larrin"));
		goodWords.add(new Word("Sina Schmidt"));
		goodWords.add(new Word("marvin"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("St4phi"));
		badWords.add(new Word("Jan-Mirko"));
		badWords.add(new Word("Dennis  Carsten Klein"));
		badWords.add(new Word("Richard_Klein"));
		badWords.add(new Word("Richard.Klein"));
		badWords.add(new Word("Digga!"));

		String text = "Filtert nach Namen. Diese Namen dürfen nur aus Buchstaben bestehen und können Leerzeichen enthalten. "
				+ "Ab dem 2. Buchstaben dürfen nur kleine Buchstaben. Der erste Buchstabe darf kleingeschrieben sein. "
				+ "Es dürfen keine zwei Leerzeichen aufeinander folgen. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);		
		exercise.addHints(HINT_LETTERS_NUM);
		exercise.addHints(HINT_STAR);		
		exercise.addHints(HINT_WHITE_SPACE);
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		

		exercises.add(exercise);

	}

	private void loadExercises53() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Abendessen"));
		goodWords.add(new Word("Affen"));
		goodWords.add(new Word("decken"));
		goodWords.add(new Word("baden"));
		goodWords.add(new Word("Chaoten"));
		goodWords.add(new Word("Chancen"));
		goodWords.add(new Word("denken"));
		goodWords.add(new Word("dichten"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("barfuß gehen"));
		badWords.add(new Word("Biene"));
		badWords.add(new Word("Bruder"));
		badWords.add(new Word("Abend"));
		badWords.add(new Word("Rachen"));
		badWords.add(new Word("rufen"));

		String text = "Filtert nach Wörtern, die mit a, A, B, b, c, C, d oder D beginnen und mit n aufhören. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);		
		exercise.addHints(HINT_LETTERS_UL);
		exercise.addHints(HINT_STAR);	
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		

		exercises.add(exercise);
	}

	private void loadExercises54() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Abendessen"));
		goodWords.add(new Word("Affen"));
		goodWords.add(new Word("anders"));
		goodWords.add(new Word("arrangieren"));
		goodWords.add(new Word("Asien"));
		goodWords.add(new Word("Arten"));
		goodWords.add(new Word("Abend"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("Affe"));
		badWords.add(new Word("aber"));
		badWords.add(new Word("Attacke"));
		badWords.add(new Word("Bund"));
		badWords.add(new Word("Art"));
		badWords.add(new Word("Biene"));
		badWords.add(new Word("baden"));
		badWords.add(new Word("suchen"));
		badWords.add(new Word("A1rten"));
		badWords.add(new Word("Abend-Essen"));

		String text = "Filtert nach Wörtern, die mit a oder A beginnen und ein n im Wort haben. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_SMALL_LETTERS);		
		exercise.addHints(HINT_LETTERS_UL);
		exercise.addHints(HINT_STAR);				
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		

		exercises.add(exercise);
	}

	private void loadExercises55() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("[23:43:32] Der Spieler stellt einen neuen Rekord mit 192 Punkten auf."));
		goodWords.add(new Word("[00:13:42] 201 ist der neue Rekord."));
		goodWords.add(new Word("[23:59:59] 204 Punkte – was für eine grandiose Leistung."));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("Der Spieler ist offline."));
		badWords.add(new Word("Der Spieler ist online."));
		badWords.add(new Word("Der Spieler tritt einem Match bei."));
		badWords.add(new Word("Das Match geht mit 192:87 Punkten in 01:47 Min aus."));
		badWords.add(new Word("[57:11:99] Dies ist keine richtige Uhrzeit."));
		badWords.add(new Word("[24:00:00] Dies sollt ihr nicht filtern."));
		badWords.add(new Word("[00:95:00] Dies sollt ihr nicht filtern."));

		String text = "Stellt euch vor ihr hättet eine riesige Log-Datei eines Spiels. "
				+ "Immer wenn jemand einen neuen Rekord aufstellt, wird dies in der "
				+ "Log-Datei mit einem Zeitstempel (z.B.: 22:34:02) und einer entsprechenden "
				+ "Nachricht eingetragen. Ihr sollt die Zeilen aus der Log-Datei filtern, "
				+ "die so einen Zeitstempel haben, achtet darauf, dass im Zeitstempel auch nur "
				+ "gültige Uhrzeiten stehen können. In so einer Zeile können Zahlen, Buchstaben, "
				+ "Leerzeichen, Doppelpunkte, Satzzeichen auftreten. " + "Ihr sollt die komplette Zeile filtern."
				+ "In Grün sind die Zeilen aufgeführt, die ihr filtern solltet. In Rot sind Zeilen aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_OR);		
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_ANY_CHAR);
		exercise.addHints(HINT_STAR);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

	private void loadExercises56() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("stephanieb@gmail.com"));
		goodWords.add(new Word("noreply@gmx.net"));
		goodWords.add(new Word("tim23@yahoo.de"));
		goodWords.add(new Word("coffee2go@marke.de"));
		goodWords.add(new Word("grrrrr@keinklopapier.da"));
		goodWords.add(new Word("alle@nudelnsind.weg"));
		goodWords.add(new Word("hierkönntedeine@email.sein"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("was.geht.so?@nicht.v1el"));
		badWords.add(new Word("@gmail.com"));
		badWords.add(new Word("stephi@gmail."));
		badWords.add(new Word("sonne@istCool?ne"));
		badWords.add(new Word("Chuck.norris@brauchtkeine.email"));
		badWords.add(new Word("Warum-habe-ich keinen@kuchen.hier"));

		String text = "Schreibt eine Methode boolean emailCheck(String email), dabei sollt ihr prüfen, "
				+ "ob die Email-Adresse ein Mix aus Buchstaben und Zahlen, gefolgt von einem @, "
				+ "danach sind Buchstaben erlaubt, ein Punkt muss folgen und "
				+ "danach müssen 2-4 Buchstaben wieder folgen. Eure emailCheck()-Methode soll prüfen, "
				+ "ob angegebene Email-Adressen diesem Schema folgen. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_ANY_CHAR);
		exercise.addHints(HINT_STAR);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

	private void loadExercises57() {

		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("1.1.00"));
		goodWords.add(new Word("23.12.1999"));
		goodWords.add(new Word("31.01.10"));
		goodWords.add(new Word("14.10.1930"));
		goodWords.add(new Word("5.7.59"));
		goodWords.add(new Word("99.99.99"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("199.01.99"));
		badWords.add(new Word("01.01.9"));
		badWords.add(new Word("01.01.199"));
		badWords.add(new Word("z9.07.69"));
		badWords.add(new Word("23.132.81"));

		String text = "Filtert nach Ausdrücken, die mit 1-2 Zahlen bestehen, gefolgt von 1-2 Zahlen, gefolgt von 2 oder 4 Zahlen."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.ADVANCED, text, goodWords, badWords);
		exercise.addHints(HINT_NUM_TIMES);		
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

	private void loadExercises61() {

		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("30.04.2000"));
		goodWords.add(new Word("23.12.1999"));
		goodWords.add(new Word("31.01.2010"));
		goodWords.add(new Word("31.10.1930"));
		goodWords.add(new Word("05.07.1959"));
		goodWords.add(new Word("28.02.1999"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("29.02.99"));
		badWords.add(new Word("32.01.79"));
		badWords.add(new Word("31.11.2009"));
		badWords.add(new Word("z7.07.69"));
		badWords.add(new Word("23.91.81"));
		badWords.add(new Word("9.9.999"));

		String text = "Filtert nach Ausdrücken, die ein richtiges Datum enthalten. Das Jahr soll dabei 4-stellig sein"
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";

		Exercise exercise = new Exercise(Exercise.CHUCK_NORRIS, text, goodWords, badWords);
		exercise.addHints(HINT_NUM_TIMES);		
		exercise.addHints(HINT_OR);		
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

	private void loadExercises62() {

		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("$test4"));
		goodWords.add(new Word("Test3"));
		goodWords.add(new Word("test2"));
		goodWords.add(new Word("_test1"));
		goodWords.add(new Word("test"));
		goodWords.add(new Word("NUM_RECTS"));
		goodWords.add(new Word("RECT_1"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("1_RECT"));
		badWords.add(new Word("rect 1"));
		badWords.add(new Word("test-2"));
		badWords.add(new Word("test#2"));
		badWords.add(new Word("#test"));
		badWords.add(new Word("test!"));

		String text = "Filtert, ob der Ausdruck ein gültiger Identifier(Bezeichner/Variablenname) ist. Gültig ist der Name, wenn er mit einem Buchstaben, $ oder _ beginnt. Die folgenden Zeichen können Buchstaben, Zahlen, _ und $ sein."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.CHUCK_NORRIS, text, goodWords, badWords);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_NUM_TIMES);		
		exercise.addHints(HINT_OR);		
		exercise.addHints(HINT_WORD);				
		exercise.addHints(HINT_PLUS);				
		exercise.addHints(HINT_STAR);				
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

	private void loadExercises63() {

		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("boolean $test4;"));
		goodWords.add(new Word("boolean Test3 = true;"));
		goodWords.add(new Word("boolean test2=false;"));
		goodWords.add(new Word("boolean _test1 =false;"));
		goodWords.add(new Word("boolean test= true;"));
		goodWords.add(new Word("boolean\nNUM_RECTS;"));
		goodWords.add(new Word("boolean\tRECT_1;"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("bool $test4;"));
		badWords.add(new Word("Test3 = true;"));
		badWords.add(new Word("boolean test2=;"));
		badWords.add(new Word("boolean _test1 =false"));
		badWords.add(new Word("boolean test true;"));
		badWords.add(new Word("boolean NUM_RECTS $;"));
		badWords.add(new Word("boolean a RECT_1;"));

		String text = "Erweitert eure Aufgabe und prüft, ob eine boolean Variable richtig deklariert wurde. Zwischen dem Datentyp und dem Variablennamen etc. muss mindestens ein Whitespace. Damit darf auch ein Zeilenumbruch stehen."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		Exercise exercise = new Exercise(Exercise.CHUCK_NORRIS, text, goodWords, badWords);
		exercise.addHints(HINT_SPECIAL);		
		exercise.addHints(HINT_NUM_TIMES);		
		exercise.addHints(HINT_OR);		
		exercise.addHints(HINT_WORD);				
		exercise.addHints(HINT_PLUS);				
		exercise.addHints(HINT_STAR);				
		exercise.addHints(HINT_BEGINN);		
		exercise.addHints(HINT_END);		
		exercises.add(exercise);
	}

}
