package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import formas2D.Editor;

@SuppressWarnings("serial")
public class ToolsPanel extends JPanel {
	private GridLayout toolsLayout;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DrawAreaPanel drawArea;
	
	public ToolsPanel(DrawAreaPanel drawArea){
		this.drawArea = drawArea;
		toolsLayout = new GridLayout(8,1,0,8);
		setLayout(toolsLayout);
		setAlignmentX(Component.TOP_ALIGNMENT);
		setBackground(new Color(63, 63, 63));
		//Buttons config
		JButton cursor = new JButton();
		cursor.setBorder(new LineBorder(Color.DARK_GRAY));
		buttonGroup.add(cursor);
		cursor.setIcon(new ImageIcon(Principal.class.getResource("/icons/Icon2.gif")));
		cursor.setPreferredSize(new Dimension(58, 40));
		cursor.setMaximumSize(new Dimension(58,40));
		cursor.setBackground(new Color(63, 63, 63));
		add(cursor);
		JButton retangulo = new JButton();
		retangulo.setBorder(new LineBorder(Color.DARK_GRAY));
		buttonGroup.add(retangulo);
		retangulo.setIcon(new ImageIcon(Principal.class.getResource("/icons/IconQ.gif")));
		retangulo.setPreferredSize(new Dimension(58, 40));
		retangulo.setMaximumSize(new Dimension(58,40));
		retangulo.setBackground(new Color(63, 63, 63));
		add(retangulo);
		JButton circulo = new JButton();
		circulo.setBorder(new LineBorder(Color.DARK_GRAY));
		buttonGroup.add(circulo);
		circulo.setIcon(new ImageIcon(Principal.class.getResource("/icons/IconS.gif")));
		circulo.setPreferredSize(new Dimension(58, 40));
		circulo.setMaximumSize(new Dimension(58,40));
		circulo.setBackground(new Color(63, 63, 63));
		add(circulo);
		JButton triangulo = new JButton();
		triangulo.setBorder(new LineBorder(Color.DARK_GRAY));
		buttonGroup.add(triangulo);
		triangulo.setIcon(new ImageIcon(Principal.class.getResource("/icons/IconT.gif")));
		triangulo.setPreferredSize(new Dimension(58, 40));
		triangulo.setMaximumSize(new Dimension(58,40));
		triangulo.setBackground(new Color(63, 63, 63));
		add(triangulo);
		//Button Logic
		retangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawArea.getEditor().setShape(Editor.RETANGULO);
			}
		});
		
		triangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawArea.getEditor().setShape(Editor.TRIANGULO);
			}
		});
		
		circulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//drawArea.getEditor().setNPontos(2);
			}
		});
	}
}
