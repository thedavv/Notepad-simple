package model;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import util.Constants;

public class NotepadMenu{
	private JMenuBar mb;

	public NotepadMenu(JFrame frame, Notepad notepad) {
		createMenuBar(frame, notepad);
	}

	private void createMenuBar(JFrame frame, Notepad notepad){
		mb = new JMenuBar();

		JMenu fileJMenu = createJMenu(Constants.JMAIN_MENU_FILE_NAME, KeyEvent.VK_F, mb);
		JMenu editJMenu = createJMenu(Constants.JMAIN_MENU_EDIT_NAME, KeyEvent.VK_E, mb);
		JMenu formatJMenu = createJMenu(Constants.JMAIN_MENU_FORMAT_NAME, KeyEvent.VK_O, mb);
		JMenu viewJMenu = createJMenu(Constants.JMAIN_MENU_VIEW_NAME, KeyEvent.VK_V, mb);
		JMenu helpJMenu = createJMenu(Constants.JMAIN_MENU_HELP_NAME, KeyEvent.VK_H, mb);

		fillFileMenuWithItems(fileJMenu, notepad);
		fillEditMenuWithItems(editJMenu, notepad);
		fillFormatMenuWithItems(formatJMenu, notepad);
		fillViewMenuWithItems(viewJMenu, notepad);
		fillHelpMenuWithItems(helpJMenu, notepad);
	}

	private JMenu createJMenu(String name, int key, JMenuBar toMenuBar){
		JMenu temp = new JMenu(name);
		temp.setMnemonic(key);
		toMenuBar.add(temp);

		return temp;
	}

	private JMenuItem createJMenuItem(String name, int Key, JMenu toMenu, boolean enabled, ActionListener al){
		JMenuItem temp = new JMenuItem(name);
		temp.addActionListener(al);
		temp.setMnemonic(Key);
		temp.setEnabled(enabled);
		toMenu.add(temp);

		return temp;
	}

	private void fillFileMenuWithItems(JMenu fileJMenu, Notepad notepad){
		createJMenuItem(Constants.FILE_SUBMENU_NEW_NAME, KeyEvent.VK_N, fileJMenu, true, notepad);
		createJMenuItem(Constants.FILE_SUBMENU_OPEN_NAME, KeyEvent.VK_O, fileJMenu, true, notepad);
		createJMenuItem(Constants.FILE_SUBMENU_SAVE_NAME, KeyEvent.VK_S, fileJMenu, true, notepad);
		createJMenuItem(Constants.FILE_SUBMENU_SAVE_AS_NAME, KeyEvent.VK_A, fileJMenu, true, notepad);
		fileJMenu.addSeparator();
		createJMenuItem(Constants.FILE_SUBMENU_PAGE_SETUP_NAME, KeyEvent.VK_U, fileJMenu, false, notepad);//TODO submenu na Print Perferences
		createJMenuItem(Constants.FILE_SUBMENU_PRINT_NAME, KeyEvent.VK_P, fileJMenu, true, notepad);
		fileJMenu.addSeparator();
		createJMenuItem(Constants.FILE_SUBMENU_EXIT_NAME, KeyEvent.VK_X, fileJMenu, true, notepad);
	}

	private void fillEditMenuWithItems(JMenu editJMenu, Notepad notepad){
		createJMenuItem(Constants.EDIT_SUBMENU_UNDO_NAME, KeyEvent.VK_U, editJMenu, false, notepad);
		editJMenu.addSeparator();
		createJMenuItem(Constants.EDIT_SUBMENU_CUT_NAME, KeyEvent.VK_T, editJMenu, false, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_COPY_NAME, KeyEvent.VK_C, editJMenu, false, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_PASTE_NAME, KeyEvent.VK_P, editJMenu, true, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_DELETE_NAME, KeyEvent.VK_L, editJMenu, false, notepad);
		editJMenu.addSeparator();
		createJMenuItem(Constants.EDIT_SUBMENU_FIND_NAME, KeyEvent.VK_F, editJMenu, false, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_FIND_NEXT_NAME, KeyEvent.VK_N, editJMenu, false, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_REPLACE_NAME, KeyEvent.VK_R, editJMenu, true, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_GO_TO_NAME, KeyEvent.VK_G, editJMenu, false, notepad);
		editJMenu.addSeparator();
		createJMenuItem(Constants.EDIT_SUBMENU_SELECT_ALL_NAME, KeyEvent.VK_A, editJMenu, true, notepad);
		createJMenuItem(Constants.EDIT_SUBMENU_TIME_DATE_NAME, KeyEvent.VK_D, editJMenu, true, notepad);
	}

	private void fillFormatMenuWithItems(JMenu formatJMenu, Notepad notepad){
		createJMenuItem(Constants.FORMAT_SUBMENU_WORD_WRAP_NAME, KeyEvent.VK_W, formatJMenu, true, notepad);
		createJMenuItem(Constants.FORMAT_SUBMENU_FONT_NAME, KeyEvent.VK_F, formatJMenu, true, notepad);
	}

	private void fillViewMenuWithItems(JMenu viewJMenu, Notepad notepad){
		createJMenuItem(Constants.VIEW_SUBMENU_STATUS_BAR_NAME, KeyEvent.VK_S, viewJMenu, false, notepad);
	}
	
	private void fillHelpMenuWithItems(JMenu helpJMenu, Notepad notepad){
		createJMenuItem(Constants.HELP_SUBMENU_HELP_NAME, KeyEvent.VK_H, helpJMenu, true, notepad);
		helpJMenu.addSeparator();
		createJMenuItem(Constants.HELP_SUBMENU_ABOUT_NAME, KeyEvent.VK_A, helpJMenu, true, notepad);
	}

	public JMenuBar getJMenuBarObject(){
		return mb;
	}
}
