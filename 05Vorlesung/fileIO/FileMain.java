/**
 * 
 */
package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ufogame.Ufo;

/**
 * @author jenny
 *
 */
public class FileMain {

	public static void main(String[] args) {
		File file = new File("05Vorlesung\\fileIO\\name.txt");
		// anlegen eines Ordners
//		File file = new File("05Vorlesung\\fileIO\\dir")
		if (file.exists()) {
			System.out.println("Die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
//				file.mkdir();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Das Programm lebt noch");
		}

		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			bufferedWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();

//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");
//			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			Scanner scanner = new Scanner(file);
//		} catch(FileNotFoundException e1) {
//			e1.printStackTrace();
//		}

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String text = bufferedReader.readLine();
			System.out.println(text);

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
			oos.writeObject(new Ufo(10, 15, 1000, 1000, 3, "spriteName"));
			oos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// oder
//		try{
//			//bei true wird es rangehängt, bei false wird datei überschrieben
//			//oder bei nur file-> datei wird überschrieben
//			FileWriter fileWriter =  new FileWriter(file, false);
//			fileWriter.write("Corona desinfiziert sich nach Kontakt miit Chuck Norris die Hände\r\n");
//			fileWriter.close();
//			fileWriter.flush();
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}

}
