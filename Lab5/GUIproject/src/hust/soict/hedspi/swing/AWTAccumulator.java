package hust.soict.hedspi.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;

	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));
		add(new Label("20225947 || Enter an Interger: "));
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		add(new Label("20225947 || The Accumulated Sum is: "));
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);

		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new AWTAccumulator();
	}

	private class TFInputListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}