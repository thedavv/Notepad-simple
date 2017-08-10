package model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import handler.FileJMenuHandler;
import handler.eventhandler.CaretListenerHandler;
import util.Constants;

public class Notepad implements ActionListener, DocumentListener, CaretListener{
	JFrame frame;
	JLabel statusJLabel;
	JTextArea notepadJTextArea;
	JScrollPane textJScrollPane;
	NotepadMenu notepadMenuBar;
	boolean newFile;
	// TODO do settings
	File file = new File("untitled.txt");
	boolean changedText = false;

	public Notepad(){
		newFile = true;
		frame = new JFrame(Constants.FILE_NAME + " - " + Constants.APPLICATION_NAME);
		frame.setLayout(new BorderLayout());

		notepadJTextArea = new JTextArea(30,50);
		notepadJTextArea.getDocument().addDocumentListener(this);
		notepadJTextArea.addCaretListener(this);
		statusJLabel = new JLabel("Words: 0 || Chars: 0"+"      "+" Ln: 1 || Col: 1  ",JLabel.RIGHT);
		textJScrollPane = new JScrollPane(notepadJTextArea);
		notepadMenuBar = new NotepadMenu(frame, this);

		frame.add(statusJLabel,BorderLayout.SOUTH);
		frame.add(new JLabel("  "), BorderLayout.EAST);
		frame.add(new JLabel("  "), BorderLayout.WEST);
		frame.add(textJScrollPane, BorderLayout.CENTER);
		frame.setJMenuBar(notepadMenuBar.getJMenuBarObject());

		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		FileMenuMethodChooser(e);
		EditMenuMethodChooser(e);
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		changedText = true;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changedText = true;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		changedText = true;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		statusJLabel.setText(CaretListenerHandler.setStatusLabel(e, notepadJTextArea));
	}
	
	private void FileMenuMethodChooser(ActionEvent e){
		switch (e.getActionCommand()) {
		case Constants.FILE_SUBMENU_NEW_NAME:
			FileJMenuHandler.newNotepad(frame, file, notepadJTextArea, changedText);
			changedText = false;
			newFile = true;
			break;

		case Constants.FILE_SUBMENU_OPEN_NAME:
			FileJMenuHandler.openFile(frame, file, notepadJTextArea, changedText);
			changedText = false;
			newFile = false;
			break;

		case Constants.FILE_SUBMENU_SAVE_NAME:
			FileJMenuHandler.saveFile(notepadJTextArea, file, newFile);
			changedText = false;
			newFile = false;
			break;

		case Constants.FILE_SUBMENU_SAVE_AS_NAME:
			file = FileJMenuHandler.saveAs(notepadJTextArea, file);
			changedText = false;
			newFile = false;
			break;

		case Constants.FILE_SUBMENU_PAGE_SETUP_NAME:
			break;

		case Constants.FILE_SUBMENU_PRINT_NAME:
			break;

		case Constants.FILE_SUBMENU_EXIT_NAME:
			FileJMenuHandler.exit(frame, changedText);
			break;
		default:
			break;
		}
	}
	
	private void EditMenuMethodChooser(ActionEvent e){
		switch (e.getActionCommand()) {
		case Constants.EDIT_SUBMENU_COPY_NAME:
			notepadJTextArea.copy();
			break;
		case Constants.EDIT_SUBMENU_CUT_NAME:
			notepadJTextArea.cut();
			break;
		case Constants.EDIT_SUBMENU_DELETE_NAME:
			notepadJTextArea.replaceSelection("");
			break;
		case Constants.EDIT_SUBMENU_FIND_NAME:
			
			break;
		case Constants.EDIT_SUBMENU_FIND_NEXT_NAME:
			break;
		case Constants.EDIT_SUBMENU_GO_TO_NAME:
			break;
		case Constants.EDIT_SUBMENU_PASTE_NAME:
			notepadJTextArea.paste();
			break;
		case Constants.EDIT_SUBMENU_REPLACE_NAME:
			break;
		case Constants.EDIT_SUBMENU_SELECT_ALL_NAME:
			notepadJTextArea.selectAll();
			break;
		case Constants.EDIT_SUBMENU_TIME_DATE_NAME:
			break;
		case Constants.EDIT_SUBMENU_UNDO_NAME:
			break;

		default:
			break;
		}
	}
}
