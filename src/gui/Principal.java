package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.*;
import javax.swing.Box.Filler;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Principal {
	JFrame frame = new JFrame();
	int cX,cY,oX,oY,formsQtd;
	
	public Principal() {
		setupGui();
	}
	
	protected void setupGui() {
		// Frame Config...
		frame.setVisible(true);
		GridBagLayout frameLayout = new GridBagLayout();
		frameLayout.rowWeights = new double[]{0.0};
		frame.getContentPane().setLayout(frameLayout);
		frame.getContentPane().setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		//frame.setMaximizedBounds(new Rectangle(800, 600));
		//Panels Config
		DrawAreaPanel drawArea = new DrawAreaPanel();
		GridBagConstraints gbc_drawArea = new GridBagConstraints();
		gbc_drawArea.weighty = 1.0;
		gbc_drawArea.weightx = 1.0;
		gbc_drawArea.fill = GridBagConstraints.BOTH;
		gbc_drawArea.gridx = 1;
		gbc_drawArea.gridy = 1;
		frame.getContentPane().add(drawArea, gbc_drawArea);
		ToolsPanel toolsPanel = new ToolsPanel(drawArea);
		GridBagConstraints gbc_toolsPanel = new GridBagConstraints();
		gbc_toolsPanel.fill = GridBagConstraints.BOTH;
		gbc_toolsPanel.gridx = 0;
		gbc_toolsPanel.gridy = 0;
		gbc_toolsPanel.gridheight = 2;
		frame.getContentPane().add(toolsPanel, gbc_toolsPanel);
		ColorsPanel colorsPanel = new ColorsPanel(drawArea);
		GridBagConstraints gbc_colorsPanel = new GridBagConstraints();
		gbc_colorsPanel.gridx = 1;
		gbc_colorsPanel.gridy = 0;
		//gbc_colorsPanel.gridwidth = 2;
		frame.getContentPane().add(colorsPanel, gbc_colorsPanel);
		//Draw Area Forms Config
		
		//Console config
		JFrame consoleFrame = new JFrame();
		consoleFrame.setBounds(960, 540, 500, 300);
		//File Open
		JFileChooser open = new JFileChooser();
		
		//File Save
		JFileChooser save = new JFileChooser();
		
		//Menu
		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu fileMenu = new JMenu("Arquivo");
		menu.add(fileMenu);
		JMenuItem abrir = new JMenuItem("Abrir");
		JMenuItem salvar = new JMenuItem("Salvar");
		JMenuItem salvarComo = new JMenuItem("Salvar como...");
		JMenuItem console = new JMenuItem("Abrir Console");
		console.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				consoleFrame.setVisible(true);
			}
			
		});
		fileMenu.add(abrir); fileMenu.add(salvar); fileMenu.add(salvarComo); fileMenu.add(console);
		abrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int returnval = open.showOpenDialog(frame);
				super.mouseClicked(e);
			}
		});
		salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int returnval = save.showSaveDialog(frame);
				super.mousePressed(e);
			}
		});
	}
}


