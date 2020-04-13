package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMain {

	public static void main(String[] args) {
		
		Email [] emails = new Email[20];
		emails[0] = new Email("Programmieren 2 Vorlesung", "Hallo allerseits,\ndie Vorlesung morgen fällt leider aus.\nViele Grüße\nStephi");
		emails[1] = new Email("Witze", "Huhu,\nich bin gerade auf der Suche nach coolen Chuck Norris Witzen. Du kennst doch so viele. Kannst du mir mal welche schreiben?\nDas wäre mega cool :)\nLG, Rudolf");
		emails[2] = new Email("SRA Treffen", "Guten Tag liebe Kollegen und Kollginnen,\nheute findet der nächste Studienreformausschuss in E45 statt.\nMit freundlichen Grüßen\nMarkus Schubert");
		emails[3] = new Email("Geburtstag", "Hallo Maria, ich wollte dir alles Gute zum geburtstag wünschen. Ich hoffe du machst dir einen schönen Tag und lässt dich ordentlich feiern.\nLiebe Grüße\nKira");
		emails[4] = new Email("Hiiillllllffffeeeeee :(", "Hallo Sina,\nich glaube ich habe einen Virus auf dem Rechner. Was soll ich tun? Kannst du dir das nachher mal anschauen? Danke und liebe Grüße\nPapa");
		emails[5] = new Email("Buch ausleihen", "Hey Hannes,\nTim sagte mir du hast die ganze Harry Potter Reihe an Büchern. Ich habe gerade voll Langeweile und würde mir gerne mal etwas Leselektüre ausleihen. Ich bring dir als Danke mal ein 6er Bier vorbei :) Grüße\nAnna");
		emails[6] = new Email("Spieleabend", "Hey Leudde,\nheute Abend bei uns Spieleabend mit leckeren Cocktails. Biste dabei?\nGrüße Laura und Dennis");
		emails[7] = new Email("Festival", "Hey,\ndas letzte Mal Flanky Ball ist schon ein Weilchen her. Ich würde sagen Zeit fürs nächste Festival ;) Biste diesen Sommer wieder am Start? Wollen entweder aufs Highfield, Hurricane oder Wacken. Over and out Digga\nKolle");
		emails[8] = new Email("Game Jam", "Moinsen,\nhab gehört der FSR organisiert einen Game Jam. Weißt du wann der ist? Hätte da ja mal echt Bock drauf, wie schauts bei dir aus?\n\nViele Grüße\nBasti");
		emails[9] = new Email("Fußball", "Hey Dave,\nkommste in zwei Wochen mit zum Pauli-Spiel? Die Bielefelder hauen wir wech. Keine Ahnung, wo die Spieler her kommen, Bielefeld gibts doch eh nicht :D\nGrüße\nMaik");
		emails[10] = new Email("Kleidertausch", "Hey Bine,\nhabe heute gehört, dass demnächst ein Kleidertausch ist. Kommste mit?\nBussi\nFrauke");
		emails[11] = new Email("AW Fußball", "Ey Tim,\nsischer bin ich dabei! Ich frag die restlichen Jungs auch mal. Bis Donnerstag, Dave");
		emails[12] = new Email("Hausaufgaben", "Hallo,\nhat jemand von euch die Hausaufgaben programmiert und verstanden? Ich bräuchte da mal Hilfe. Ciao Dome");
		emails[13] = new Email("Kino", "Hey Mädels,\nam Samsta kommt der Goldene Handschuh in die Kinos. Da gabs ja auch ein Buch zu, das war schon echt krass. Lass uns da mal hingehen.\nGrüße\nLaura");
		emails[14] = new Email("Zocken", "Hey ho, Lust auf ne Runde Spielen am Wochenende und Grillen im Stadtpark? Sag mal Bescheid, ob du dabei bist! LG");
		emails[15] = new Email("Badminton", "Hey Tom,\nwir Häuser waren am Sonntag Badminton spielen, das war ja so mega. Nächstes Mal musst du mitkommen. Wie geht es eigentlich deiner Kleinen?\nViele Grüße\nRudi");
		emails[16] = new Email("Treffen", "Aloha,\nkommste nachher mit zum Slam? Wollen uns um 19 uhr treffen und dann was Essen gehen. Es geht dann um 20:30 Uhr los.\nCu Peter");
		emails[17] = new Email("Bier brauen", "Hey Jan,\nSarah will mal Bier brauen, du musst dann wohl unter übel vorbei kommen zum kosten.\nBis denne\nSteve");
		emails[18] = new Email("Nachbarschaftshilfe", "Hey Laura,\nwollen 00:34:45wir mal Werbung für unsere Nachbarschaftshilfe machen? Können ja mal nachher drüber quatschen. Wann treffen wir uns eigentlich?");
		emails[19] = new Email("Bla", "Test, bla, test, huhu, was geht, was geht Digga?");

		String regex = "(Haus)|(Häuser)";
		Pattern pattern = Pattern.compile(regex);
		for(Email email : emails) {
			Matcher matcher = pattern.matcher(email.getMessage());
			if(matcher.find()) {
				System.out.println(email.getMessage());
			}
		}
		
		
	}
	
	
}
