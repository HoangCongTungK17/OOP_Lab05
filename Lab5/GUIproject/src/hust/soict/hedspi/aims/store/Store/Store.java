package hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println(media.getTitle() + " is added successfully (DOAN THANH TUNG)");
	}

	public void removeMedia(Media media) {
		for (Media item : itemsInStore) {
			if (item.equals(media)) {
				itemsInStore.remove(item);
				System.out.println(media.getTitle() + " is removed successfully (DOAN THANH TUNG)");
				return;
			}
		}
		System.out.println("Not found");
	}

	public ArrayList<Media> ItemsInStore() {
		return itemsInStore;
	}
}
