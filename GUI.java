package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;
import javax.imageio.*;

public class GUI extends JFrame {

	private JPanel	contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 0, 0 }, { 1, 2, 3, 4 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int cabinload=5;
		int cabinposition=0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(array, cabinload, cabinposition);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * liftuser, ist ein array, stellt wartende Nutzer dar [Etage][Ziel]
	 * cabinload, Füllung der Liftkabine 0...5
	 * cabinposition, repräsentiert Etage der Kabine, Intervall 0...8, 0 ist oben, 2er Schritte daher 0,2,4,8 zur vollen Etage
	 */
	public GUI(int[][] liftuser, int cabinload, int cabinposition) {
		setResizable(false);
		setTitle("Liftsim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMen = new JMenu("Men\u00FC");
		menuBar.add(mnMen);

		JMenuItem mntmNewMenuItem_start = new JMenuItem("Start");
		mntmNewMenuItem_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("start");
			}
		});
		mnMen.add(mntmNewMenuItem_start);

		JMenuItem mntmNewMenuItem_stop = new JMenuItem("Stop");
		mntmNewMenuItem_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("stop");
			}
		});
		mnMen.add(mntmNewMenuItem_stop);

		JMenuItem mntmNewMenuItem_beenden = new JMenuItem("Beenden");
		mntmNewMenuItem_beenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("beenden");
			}
		});
		mnMen.add(mntmNewMenuItem_beenden);

		JMenu mnNewMenu = new JMenu("Liftnutzer");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_hinzu = new JMenuItem("Hinzuf\u00FCgen");
		mntmNewMenuItem_hinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("hinzufuegen");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_hinzu);

		JMenuItem mntmNewMenuItem_gen = new JMenuItem("Zuf\u00E4llig Generieren");
		mntmNewMenuItem_gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("generieren");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_gen);

		JMenuItem mntmNewMenuItem_entf = new JMenuItem("Entfernen");
		mntmNewMenuItem_entf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("entfernen");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_entf);

		JMenuItem mntmNewMenuItem_allentf = new JMenuItem("Alle Entfernen");
		mntmNewMenuItem_allentf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("alle entfernen");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_allentf);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 320, 100, 100, 100, 100, 450 };
		gridBagLayout.rowHeights = new int[] { 70, 70, 70, 70, 70, 70, 70, 70, 70, 70 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gridBagLayout);

		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("Button5");
				button5.setForeground(Color.BLACK);
				System.err.println(button5.getForeground());
			}
		});
		button5.setForeground(Color.RED);
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 0;
		gbc_button5.gridy = 0;
		contentPane.add(button5, gbc_button5);

		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("Button4");
			}
		});
		button4.setForeground(Color.RED);
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 2;
		contentPane.add(button4, gbc_button4);

		JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("Button3");
			}
		});

		button3.setForeground(Color.RED);
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button3.insets = new Insets(0, 0, 5, 5);
		gbc_button3.gridx = 0;
		gbc_button3.gridy = 4;
		contentPane.add(button3, gbc_button3);

		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("Button2");
			}
		});
		button2.setForeground(Color.RED);
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 0;
		gbc_button2.gridy = 6;
		contentPane.add(button2, gbc_button2);

		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.err.println("Button1");
			}
		});
		button1.setForeground(Color.RED);
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 8;
		contentPane.add(button1, gbc_button1);

		
		/**
		 * Erstelle alle GUI-Elemente für wartende Liftnutzer
		 */

		for (int i = 0; 5 > i; i++) {
			for (int k = 0; 4 > k; k++) {
				SmileyPanel[][] smiley = new SmileyPanel[5][4];
				smiley[i][k] = new SmileyPanel(liftuser[i][k]);
				/* Debug
				 * System.err.println("m " + m + " i " + i + " k " + k +" liu " + liftuser[i][k]);
				 */
				GridBagConstraints[][] gbc_smiley = new GridBagConstraints[5][4];
				gbc_smiley[i][k] = new GridBagConstraints();
				gbc_smiley[i][k].anchor = GridBagConstraints.WEST;
				gbc_smiley[i][k].insets = new Insets(0, 0, 5, 5);
				gbc_smiley[i][k].gridx = 3 + k;
				gbc_smiley[i][k].gridy = 2 * i;
				contentPane.add(smiley[i][k], gbc_smiley[i][k]);
			}
		}

		CabinPanel Cabin = new CabinPanel(cabinload);
		GridBagConstraints gbc_Cabin = new GridBagConstraints();
		gbc_Cabin.fill = GridBagConstraints.HORIZONTAL;
		gbc_Cabin.insets = new Insets(0, 0, 5, 5);
		gbc_Cabin.gridx = 1;
		gbc_Cabin.gridy = cabinposition;
		contentPane.add(Cabin, gbc_Cabin);
	}

}
