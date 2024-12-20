package hust.soict.hedspi.aims.screen;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddDVDToStoreScreenController extends AddItemToStoreScreenController {
	private String director;
	private int length;
	private Media dvd;

	@FXML
	private TextField tfDirector;

	@FXML
	private TextField tfLength;

	public AddDVDToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	@FXML
	public void initialize() {
		tfDirector.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				director = newValue;
			}

		});

		tfLength.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					int number = Integer.parseInt(newValue);
					length = number;
				} catch (NumberFormatException e) {
					length = 0;
				}
			}

		});

		super.initialize();
	}

	@FXML
	@Override
	protected void addBtnPressed() {
		dvd = new DigitalVideoDisc(1, this.title, this.category, this.director, this.length, this.cost);
		store.addMedia(dvd);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText(dvd.getTitle() + " has been added to the store");
		alert.showAndWait();
	}

}