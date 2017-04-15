package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ChooserTab extends AbstractColorChooserPanel {
	private Color colors[] = new Color[256];
	private JButton buttons[] = new JButton[256];

	@Override
	protected void buildChooser() {
		// TODO Auto-generated method stub
		setLayout(new GridLayout(9, 26));
		for (int i = 0 ; i < 256 ; i++) {
			colors[i] = new Color(i, 0, 0);
			buttons[i] = new JButton();
			buttons[i].setBackground(colors[i]);
			buttons[i].setPreferredSize(new Dimension(12, 12));
			add(buttons[i]);
			i++;
		}
		
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "Colors";
	}

	@Override
	public Icon getLargeDisplayIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getSmallDisplayIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateChooser() {
		// TODO Auto-generated method stub

	}

}
