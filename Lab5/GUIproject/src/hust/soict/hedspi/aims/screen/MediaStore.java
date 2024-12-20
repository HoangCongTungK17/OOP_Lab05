package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.Exception.ItemException;
import hust.soict.hedspi.aims.Exception.UserException;
import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addMedia();
				} catch (ItemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		container.add(addToCartButton);
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					playMedia();
				}

			});
			container.add(playButton);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	private void playMedia() {
		try {
			if (media instanceof CompactDisc) {
				((CompactDisc) media).play();
			} else if (media instanceof DigitalVideoDisc) {
				((DigitalVideoDisc) media).play();
			}
		} catch (UserException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Playback Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void addMedia() throws ItemException {
		if (cart.getLength() < Cart.MAX_NUMBERS_ORDERED) {
			cart.addMedia(media);
			JOptionPane.showMessageDialog(null, media.getTitle() + " has been added to your cart.", "Cart Update",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "The cart is full. You cannot add more items.", "Cart Full",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
