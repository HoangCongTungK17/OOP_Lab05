package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private int length;
	private String title;

	public Track(int length, String title) {
		this.length = length;
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void play() {
		System.out.println("Hoang Cong Tung || Playing DVD: " + this.getTitle());
		System.out.println("Hoang Cong Tung || DVD length: " + this.getLength());
	}

	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			if (track.getTitle().equals(title) && track.getLength() == length) {
				return true;
			}
		}
		return false;
	}
}
