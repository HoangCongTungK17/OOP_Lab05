package hust.soict.hedspi.aims.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Store store;
	private Cart cart;

	public CartScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		this.setSize(1024, 768);
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setVisible(true);
		JFrame frame = this;
//		store.ItemsInStore().forEach((items) -> System.out.println(items + " "));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreScreen(store, cart);
				dispose();
			}
		});
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(store, cart, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String args[]) throws Exception {
		// Test
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Goblin King", "Animation", "Someone", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
		Track track1 = new Track(1, "Wei");
		Track track2 = new Track(2, "Shu");
		Track track3 = new Track(3, "Wu");
		CompactDisc cd1 = new CompactDisc(1, "ROTK OST (Part 1)", "Drama", "Various", 30.95f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc(2, "ROTK OST (Part 2)", "Drama", "Various", 25.99f);
		cd2.addTrack(track3);
		Cart myCart = new Cart();
		myCart.addMedia(dvd1);
		myCart.addMedia(dvd2);
		myCart.addMedia(dvd3);
		myCart.addMedia(cd1);
		myCart.addMedia(cd2);
		Store myStore = new Store();
		new CartScreen(myStore, myCart);
	}
}