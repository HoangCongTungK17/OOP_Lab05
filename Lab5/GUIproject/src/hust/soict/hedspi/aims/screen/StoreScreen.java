package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new AddBookListener());
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new AddCDListener());
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new AddDVDListener());
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem viewCartMenuItem = new JMenuItem("View cart");
		viewCartMenuItem.addActionListener(new ViewCartListener());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(new ViewCartListener());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.ItemsInStore();
		for (Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media, cart);
			center.add(cell);
		}
		return center;
	}

	private class ViewCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("View Cart clicked");
			new CartScreen(store, cart);
			dispose();
		}

	}

	private class AddDVDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddDVDToStoreScreen(store, cart);
			dispose();
		}

	}

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddBookToStoreScreen(store, cart);
			dispose();
		}

	}

	private class AddCDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddCDToStoreScreen(store, cart);
			dispose();
		}

	}

	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Doraemon the movie", "Anime", "Zen Soichiro", 90, 25.50f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Spiderman no way home", "Science Fiction", "Jon Watts", 90,
				30.15f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Naruto", "Anime", "Hayato-date", 60, 21.30f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Diary of a Wimpy Kid", "Comedy", "Thor Freudenthal", 85,
				40.50f);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		StoreScreen storeScreen = new StoreScreen(store, cart);
		storeScreen.setVisible(true);
	}

}
