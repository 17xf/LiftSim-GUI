package gui;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.io.*;

public class SmileyPanel extends JPanel {
	private Image	img_smiley;

	public SmileyPanel(int i) {
		super(new GridBagLayout());
		String wish = Integer.toString(i);
		if (i >= 1 && i <= 5) {
			try {
				img_smiley = ImageIO.read(getClass().getResource("images/Smiley.png"));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(this, "Grafikdatei nicht gefunden!\n" + iae.getMessage());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Fehler beim Einlesen einer Grafikdatei!\n" + ioe.getMessage());
			}
		} else {
			try {
				img_smiley = ImageIO.read(getClass().getResource("images/Empty.png"));
				wish=" ";
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(this, "Grafikdatei nicht gefunden!\n" + iae.getMessage());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Fehler beim Einlesen einer Grafikdatei!\n" + ioe.getMessage());
			}
		}

		JButton pictureButton = new JButton(wish, new ImageIcon(img_smiley));
		add(pictureButton);
	}

}