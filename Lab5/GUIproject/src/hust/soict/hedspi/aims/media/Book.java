package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<>();

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Hoang Cong Tung || " + authorName + "is added successfully");
		} else {
			System.out.println("Hoang Cong Tung || " + authorName + "is already in the list");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Hoang Cong Tung || " + authorName + "is removed successfully");
		} else {
			System.out.println("Hoang Cong Tung || " + authorName + "is not in the list");
		}
	}

	public String toString() {
		return "Book: " + getTitle() + " - " + getCategory() + " - " + getAuthors() + " - $" + getCost();
	}
}
