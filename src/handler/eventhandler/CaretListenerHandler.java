package handler.eventhandler;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;

public class CaretListenerHandler {
	public static String setStatusLabel(CaretEvent e, JTextArea ta){
		int pos = 0;
		int wordCount = 0;
		int charCount = 0;
		int lineCount = 0;
		int colCount = 0;
		String message;
		
		try {
			pos=ta.getCaretPosition();  
			lineCount = ta.getLineOfOffset(pos);
			colCount = ta.getLineOfOffset(lineCount);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		charCount = ta.getText().length();
		wordCount = ta.getText().split("(\n.)|( +)|(\t+)").length;
		message = "Words: "+ wordCount+" || Chars: "+charCount+" "+"     "+" Ln: "+lineCount+" || Col: "+colCount+"  ";
		
		return message;
	}
}
