package hust.soict.hedspi.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.Exception.UserException;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;

	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public DigitalVideoDisc(int id, String title, String category, String direcor, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() throws UserException {
		if (getLength() <= 0) {
			throw new UserException("ERROR: DVD length is non-positive!");
		}

		showPlayDialog();
	}

	private void showPlayDialog() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JDialog dialog = createDialog();

		int dialogWidth = dialog.getSize().width;
		int dialogHeight = dialog.getSize().height;
		int x = (screenSize.width - dialogWidth) / 2;
		int y = (screenSize.height - dialogHeight) / 2;

		dialog.setLocation(x, y);
		dialog.setVisible(true);
	}

	private JDialog createDialog() {
		JDialog dialog = new JDialog();
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
		panel.add(createLabel("Now playing: " + getTitle()));
		panel.add(createLabel("DVD length: " + getLength() + " seconds"));
		panel.add(Box.createVerticalGlue());

		dialog.add(panel);
		dialog.setTitle("Media Player");
		dialog.setSize(300, 120);

		return dialog;
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}

	public String toString() {
		return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "s - $"
				+ getCost();
	}
}
