package com.osu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField osuPathInput;
	private JTextField musicFolderInput;
	private JButton copy;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		setTitle("Osu Tool Lol");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(418, 237);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		osuPathInput = new JTextField();
		osuPathInput.setBounds(85, 8, 200, 20);
		contentPane.add(osuPathInput);
		osuPathInput.setColumns(10);

		musicFolderInput = new JTextField();
		musicFolderInput.setBounds(85, 39, 200, 20);
		contentPane.add(musicFolderInput);
		musicFolderInput.setColumns(10);

		copy = new JButton("Copy");
		copy.setBounds(10, 70, 89, 23);
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!osuPathInput.getText().equals("") && !musicFolderInput.getText().equals("")) {
					if (testPath(osuPathInput.getText(), true) && testPath(musicFolderInput.getText(), false)) {
						osuPathInput.setEnabled(false);
						musicFolderInput.setEnabled(false);
						btnNewButton.setVisible(true);
						copy.setVisible(false);
						lblNewLabel_2.setVisible(true);
					}
				}

			}
		});
		contentPane.add(copy);

		JLabel lblNewLabel = new JLabel("Osu Path");
		lblNewLabel.setBounds(10, 11, 65, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Music Path");
		lblNewLabel_1.setBounds(9, 42, 66, 14);
		contentPane.add(lblNewLabel_1);

		btnNewButton = new JButton("Are u sure bro?");
		btnNewButton.setBounds(10, 98, 275, 23);
		contentPane.add(btnNewButton);

		lblNewLabel_2 = new JLabel(
				"<html>Look at your Music Folder/Path, this might take a while, it depends how many beatmaps you have >.>..... Thus you can't cancel this operation because i don't know how >.>, teach me i guess, if you want to stop this just end proccess this program in task manager</html>");
		lblNewLabel_2.setBounds(10, 121, 382, 63);
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Osu(Paths.get(osuPathInput.getText())).musics
							.copyAudioSongs(Paths.get(musicFolderInput.getText()));
					lblNewLabel_2.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public boolean testPath(String str, boolean isOsu) {
		Path path = Paths.get(str);
		if (isOsu) {
			Path osuExe = path.resolve("osu!.exe");
			Path osuSongs = path.resolve("Songs");
			return path.toFile().exists() && osuExe.toFile().exists() && osuSongs.toFile().exists();
		}
		return path.toFile().exists();
	}

}
