package hust.soict.hedspi.aims.cart.Cart;

import hust.soict.hedspi.aims.Exception.ItemException;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private int qtyOrdered;

	public void addMedia(Media media) throws ItemException {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " is added successfully (DOAN THANH TUNG)");
			qtyOrdered++;
		} else
			throw new ItemException("the cart is full!");
	}

	public void removeMedia(Media media) throws ItemException {
		if (itemsOrdered.size() == 0) {
			throw new ItemException(media.getTitle() + "is not exits!");
		}
		for (Media item : itemsOrdered) {
			if (item.equals(media)) {
				itemsOrdered.remove(item);
				System.out.println(media.getTitle() + " is removed successfully");
				qtyOrdered--;
				return;
			}
		}
		System.out.println("there is no media like that in your cart!");
	}

	public float totalcost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered.get(i).getCost();
			;
		}
		return sum;
	}

	// Doan Thanh Tung - 20225946
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.printf("Total cost: $%.2f\n", totalcost());
		System.out.println("**************************************************");
	}

	public boolean search(int id) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println(itemsOrdered.get(i).toString());
				return true;
			}
		}
		return false;
	}

	public boolean search(String title) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered.get(i).getTitle() == title) {
				System.out.println(itemsOrdered.get(i).toString());
				return true;
			}
		}
		return false;
	}

	public void empty() {
		this.itemsOrdered.clear();
		qtyOrdered = 0;
	}

	public Media searchMedia(String title) {
		for (Media medium : this.itemsOrdered) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}

	public void sortByTitle() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public int getLength() {
		return qtyOrdered;
	}

	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}

}
