package handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Notepad;

public class FileJMenuHandler {

	public static void newNotepad(JFrame frame, File file, JTextArea ta, boolean changedText){
		if(changedText){
			int answer = JOptionPane.showConfirmDialog(frame, "Changes will not be saved, save?", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);

			if(answer == 0){
				saveFile(ta, file, changedText);

				frame.setVisible(false);
				frame.dispose();
				new Notepad();

			} else{
				frame.setVisible(false);
				frame.dispose();
				new Notepad();
			}
		} else{
			frame.setVisible(false);
			frame.dispose();
			new Notepad();
		}
	}

	public static void openFile(JFrame frame, File file, JTextArea ta, boolean changedText){
		String currentLine;
		String pathName;
		File myFile;
		JFileChooser fc = new JFileChooser();
		if(changedText){
			System.out.println("asdasdasd");
			int answer = JOptionPane.showConfirmDialog(frame, "Changes will not be saved, save?", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);

			if(answer == 0){
				saveFile(ta, file, changedText);
			}
		}

		ta.setText(null);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "text", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java Files (*.java)", "java"));
		fc.showOpenDialog(fc);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		pathName = fc.getSelectedFile().toString();
		myFile = new File(pathName);

		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			while ((currentLine = br.readLine()) != null) {
				ta.append(currentLine + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}	

	public static void saveFile(JTextArea ta, File file, boolean newFile){
		int start, end;
		if(newFile){
			saveAs(ta, file);
		} else{
			try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
				for (int i = 0; i < ta.getLineCount(); i++) {
					start = ta.getLineStartOffset(i);
					end = ta.getLineEndOffset(i);
					br.write(ta.getText(start, end-start));
					br.newLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static File saveAs(JTextArea ta, File file ){//TODO duplicate file
		String pathName = file.getName();
		int start, end;

		File myFile = file;
		JFileChooser fc = new JFileChooser();

		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", ".txt"));
		fc.setSelectedFile(myFile);
		fc.showSaveDialog(fc);
		pathName = fc.getSelectedFile().toString();


		try (BufferedWriter br = new BufferedWriter(new FileWriter(pathName))){

			for (int i = 0; i < ta.getLineCount(); i++) {
				start = ta.getLineStartOffset(i);
				end = ta.getLineEndOffset(i);
				System.out.println(ta.getText(start, end-start));
				br.write(ta.getText(start, end-start));
				br.newLine();
			}
			myFile = new File(pathName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

		return myFile;
	}

	public static void pageSetup(){//TODO urobit novy frame pre page setup pri tlaci

	}

	public static void print(){}//TODO dorobit print page

	public static void exit(JFrame frame, boolean changedText){
		//if(changedText){
		int answer = JOptionPane.showConfirmDialog(frame, "Are you sure? Changes will not be saved", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);

		if(answer == 0){
			frame.setVisible(false);
			frame.dispose();
		}
		//}
	}
}
