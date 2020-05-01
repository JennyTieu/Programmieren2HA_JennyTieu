/**
 * 
 */
package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import datastructures.Contact;

/**
 * @author jenny
 *
 */
public class FileIOAufgabe {

	public static void main(String[] args) {
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Tom Nook", 1568743412345678L));
		contacts.add(new Contact("Isabelle", 14658623));
		contacts.add(new Contact("Sherb", 284824375));
		contacts.add(new Contact("Raymond", 1233423243));
		contacts.add(new Contact("Skye", 1313473444));
		contacts.add(new Contact("Zorro", 1313473445));
		contacts.add(new Contact("Chuck Norris", 0));
		contacts.add(new Contact("Resettie", 987654));
		contacts.add(new Contact("Sprocket", 876544556));
		contacts.add(new Contact("Apple", 345678));

		Collections.sort(contacts);
		File file = new File("05Vorlesung\\fileIO\\contacts.txt");

		if (file.exists()) {
			System.out.println("Die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("alive");
		}

		for (Contact con : contacts) {

			try {

				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(con);
				oos.close();
				fos.close();

				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();

				if (obj instanceof Contact) {
					Contact cont = (Contact) obj;
					System.out.println(String.format("%20s:\t%d", cont.getName(), cont.getNumber()));
				}
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File secondFile = new File("05Vorlesung\\fileIO\\part2.txt");

		if (secondFile.exists()) {
			System.out.println("Die Datei2 existiert");
		} else {
			System.out.println("Die Datei2 wird angelegt");
			try {
				secondFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("alive 2.0");
		}

		try {

			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			FileWriter fwriter = new FileWriter(secondFile, true);
			PrintWriter pwriter = new PrintWriter(fwriter);
			pwriter.println(line);
			sc.close();
			pwriter.close();
			fwriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
