package gui;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.io.*;

public class CabinPanel extends JPanel {
	private Image	img_Cabin, background;

	public CabinPanel(int i) {
		super(new GridBagLayout());

		if (i >= 0 && i <= 5) {
			try {
				img_Cabin = ImageIO.read(getClass().getResource("images/Cabin" + i + ".png"));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(this, "Grafikdatei nicht gefunden!\n" + iae.getMessage());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Fehler beim Einlesen einer Grafikdatei!\n" + ioe.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belegung der Liftkabine nicht im Intervall 0...5!\nProgrammabbruch\n");
		}

		JButton pictureButton = new JButton("", new ImageIcon(img_Cabin));
		add(pictureButton);
	}

}