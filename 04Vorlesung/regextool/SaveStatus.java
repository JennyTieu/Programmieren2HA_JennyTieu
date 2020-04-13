package regextool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class SaveStatus {
	private static String path = "";
	private static final String FILE_NAME_STATE = "excerciseSaveState.bin";
	private static final String FILE_NAME_FEEDBACK = "feedback.txt";

	public static void writeStatus(ArrayList<Exercise> exercises) {
		File file = createFile(FILE_NAME_STATE);
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(exercises);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static File createFile(String name) {
		File file;
		if (path == "") {
			file = new File("04Vorlesung\\regextool\\" + name);
			if (!file.exists()) {
				createFileIfNotExists(name, file);
			}
		} else {
			file = new File(path, name);
		}
		return file;
	}

	protected static void createFileIfNotExists(String name, File file)  {
		try {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				
				try {
					File currentDirFile = new File(".");
					JFileChooser jf = new JFileChooser(currentDirFile.getCanonicalPath());
					if (jf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						file = jf.getSelectedFile();
					} else {
						file = createFileInProjectFolder(name, file);
					}
				} catch (Exception e1) {
					file = createFileInProjectFolder(name, file);
					e.printStackTrace();
				}
			}
			path = file.getCanonicalPath().replace(name, "");	
		} catch (Exception e) {
			System.err.println("Cannot save state. Please contact Stephi for help. This is important for your homework.");
		}
	}

	protected static File createFileInProjectFolder(String name, File file) {
		try {
			file = new File(name);							
			file.createNewFile();							
		} catch (Exception e2) {
			System.err.println("Cannot save state. Please contact Stephi for help. This is important for your homework.");
		}
		return file;
	}

	public static ArrayList<Exercise> readStatus() {
		File file = createFile(FILE_NAME_STATE);
		ArrayList<Exercise> exercises = null;
		try (FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Object obj = ois.readObject();
			if(obj instanceof ArrayList) {
				try {
					exercises = (ArrayList<Exercise>) obj;					
				} catch (Exception e) {
				}
			}
			
		} catch (Exception e) {
			
		}

		return exercises;

	}

	
	public static void writeFeedback(ArrayList<Exercise> exercises) {
		File file = createFile(FILE_NAME_FEEDBACK);
		try (FileWriter fw = new FileWriter(file); 
			BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
			for(Exercise exercise : exercises) {
				bufferedWriter.write("Excercise : " + (exercise.isSucceded()? " Mission completed \n" : " Waiting to be solved \n") + exercise.getText()+"\n\n");
				bufferedWriter.newLine();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
