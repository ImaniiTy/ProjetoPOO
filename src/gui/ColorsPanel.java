package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private FlowLayout layout;
	private DrawAreaPanel drawArea;
	
	public ColorsPanel(DrawAreaPanel drawArea) {
		this.drawArea = drawArea;
		layout = new FlowLayout(FlowLayout.LEFT);
		setLayout(layout);
		setPreferredSize(new Dimension(700,50));
		JButton red = new JButton();
		red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(40, 40));
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.RED);
			}
		});
		JButton blue = new JButton();
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(new Dimension(40, 40));
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.BLUE);
			}
		});
		JButton green = new JButton();
		green.setBackground(Color.GREEN);
		green.setPreferredSize(new Dimension(40, 40));
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.GREEN);
			}
		});
		JButton black = new JButton();
		black.setBackground(Color.BLACK);
		black.setPreferredSize(new Dimension(40, 40));
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.BLACK);
			}
		});
		JButton yellow = new JButton();
		yellow.setBackground(Color.YELLOW);
		yellow.setPreferredSize(new Dimension(40, 40));
		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.YELLOW);
			}
		});
		JButton purple = new JButton();
		purple.setBackground(Color.MAGENTA);
		purple.setPreferredSize(new Dimension(40, 40));
		purple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.MAGENTA);
			}
		});
		JButton gray = new JButton();
		gray.setBackground(Color.GRAY);
		gray.setPreferredSize(new Dimension(40, 40));
		gray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.GRAY);
			}
		});
		JButton cyan = new JButton();
		cyan.setBackground(Color.CYAN);
		cyan.setPreferredSize(new Dimension(40, 40));
		cyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getEditor().setCor(Color.CYAN);
			}
		});
		add(red); add(blue); add(green); add(black); add(yellow); add(purple); add(gray); add(cyan);
	}
}
