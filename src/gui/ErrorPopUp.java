/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author jainec
 */
@SuppressWarnings("serial")
public abstract class ErrorPopUp extends JFrame{
	protected String mensagem;
	public ErrorPopUp () {
		mensagem = getMensagem();
		setBounds(Principal.screenResolution.width/2 - 150, Principal.screenResolution.height/2 - 80, 300, 160);
		setLayout(new BorderLayout());
		JButton okButton = new JButton();
		JLabel buttonText = new JLabel("OK");
		buttonText.setForeground(Color.WHITE);
		buttonText.setHorizontalAlignment(SwingConstants.CENTER);
		okButton.setLayout(new BorderLayout());
		okButton.setBackground(Color.DARK_GRAY);
		okButton.setForeground(Color.WHITE);
		okButton.setPreferredSize(new Dimension(80, 40));
		okButton.setBorder(null);
		okButton.add(buttonText, BorderLayout.CENTER);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		TextPanel textPanel = new TextPanel(mensagem);
		setVisible(true);
		//Add..
		add(textPanel, BorderLayout.CENTER); add(okButton, BorderLayout.SOUTH);
	}

	public abstract String getMensagem();

	public class TextPanel extends JPanel {
		private JLabel textArea;

		public TextPanel(String text) {
			setBackground(Color.GRAY);
			textArea = new JLabel(text, SwingConstants.CENTER);
			textArea.setForeground(Color.WHITE);
			textArea.setVerticalAlignment(SwingConstants.CENTER);
			textArea.setPreferredSize(new Dimension(300, 80));
			add(textArea);
		}


	}

}
