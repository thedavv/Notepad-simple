package model;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class FindDialog {
	private JFrame frame;
	private JLabel findWhatJLabel;
	private JButton findNextJButton;
	private JButton closeJButton;
	private JRadioButton up;
	private JRadioButton down;
	private JCheckBox matchselectedCheckbox;
	private ButtonGroup radioButtonGroupDirection;
	private GroupLayout layout;
	private JTextArea findJTextArea;

	public FindDialog() {
		frame = new JFrame("Find");
		frame.setVisible(true);
		//frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		layout = new GroupLayout(frame.getContentPane());
		frame.setLayout(layout);

		findJTextArea = new JTextArea();
		matchselectedCheckbox = new JCheckBox("Match Selected");
		findWhatJLabel = new JLabel("Find What: ");
		findNextJButton = new JButton("Find Next");
		closeJButton = new JButton("Close");
		up = new JRadioButton("Up");
		down = new JRadioButton("Down");
		down.setSelected(true);

		radioButtonGroupDirection = new ButtonGroup();
		radioButtonGroupDirection.add(up);
		radioButtonGroupDirection.add(down);
		
		frame.add(up);
		frame.add(down);
		frame.add(closeJButton);
		frame.add(findNextJButton);
		frame.add(matchselectedCheckbox);
		frame.add(findWhatJLabel);
		frame.add(findJTextArea);
	}
}
