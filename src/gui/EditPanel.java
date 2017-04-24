package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import formas2D.Circuferencia;
import formas2D.Forma;
import formas2D.Retangulo;

@SuppressWarnings("serial")
public class EditPanel extends JPanel {
	private final int DEFAULTLOCATIONSX[] = {0,0,0,0};
	private final int DEFAULTLOCATIONSY[] = {0,0,0,0};
	private JButton edit_Color;
	private JTextField locationXTextField, locationYTextField, larguraTextField, alturaTextField, raioTextField;
	private Forma selectedForma;
	private JLabel colorLabel, locationXLabel, locationYLabel, larguraLabel, alturaLabel, raioLabel;
	private JPanel editArea;
	private ListaFormas listFrame;
	private DrawAreaPanel drawArea;
	public EditPanel(ListaFormas listaFrame) {
		this.listFrame = listaFrame;
		selectedForma = new Retangulo(Color.BLACK, DEFAULTLOCATIONSX, DEFAULTLOCATIONSY);
		locationXTextField = new JTextField();
		locationYTextField = new JTextField();
		larguraTextField = new JTextField();
		alturaTextField = new JTextField();
		raioTextField = new JTextField();
		drawArea = listaFrame.getDrawArea();
		setupGui();
	}

	public void setupGui() {
		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		//Bunttons
		JButton back =  new JButton("Back");
		setMainColors(back, Color.DARK_GRAY);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setUnselected();
				listFrame.changeLayout(listFrame.LISTPANEL);
				resetEdit();
				drawArea.repaint();
			}
		});
		edit_Color = new JButton();
		edit_Color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorChooser myColorChooser = new ColorChooser();
				Color corAux = myColorChooser.showDialog(null, "COR", Color.WHITE);
				if(corAux != null){
					edit_Color.setBackground(corAux);
					selectedForma.setCor(corAux);
					drawArea.repaint();
				}
				
			}
		});
		setMainColors(edit_Color, Color.BLACK);
		//Labels
		colorLabel = new JLabel("Editar Cor", SwingConstants.CENTER);
		locationXLabel = new JLabel("Editar X", SwingConstants.CENTER);
		locationYLabel = new JLabel("Editar Y", SwingConstants.CENTER);
		larguraLabel = new JLabel("Editar Largura", SwingConstants.CENTER);
		alturaLabel = new JLabel("Editar Altura", SwingConstants.CENTER);
		raioLabel = new JLabel("Editar Raio", SwingConstants.CENTER);
		
		//Text Fields
		locationXTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setCenter(new Point(Integer.parseInt(locationXTextField.getText()), Integer.parseInt(locationYTextField.getText())));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		
		locationYTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setCenter(new Point(Integer.parseInt(locationXTextField.getText()), Integer.parseInt(locationYTextField.getText())));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		larguraTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setLargura(-Integer.parseInt(larguraTextField.getText()));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		alturaTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setAltura(-Integer.parseInt(alturaTextField.getText()));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		raioTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedForma instanceof Circuferencia) {
					((Circuferencia) selectedForma).setRaio(Integer.parseInt(raioTextField.getText()));
					selectedForma.refactor();
					drawArea.repaint();
				}
			}
		});
		
		
		//Panels
		editArea =  new JPanel(new GridLayout(12,5));
		setMainColors(editArea, Color.GRAY);
		//Constrains
		GridBagConstraints gbc_Back = new GridBagConstraints();
		gbc_Back.anchor = GridBagConstraints.CENTER;
		gbc_Back.fill = GridBagConstraints.BOTH;
		gbc_Back.gridx = 0;
		gbc_Back.gridy = 1;
		gbc_Back.weightx = 1;
		gbc_Back.weighty = 0.05;
		
		GridBagConstraints gbc_EditArea = new GridBagConstraints();
		gbc_EditArea.anchor = GridBagConstraints.CENTER;
		gbc_EditArea.fill = GridBagConstraints.BOTH;
		gbc_EditArea.gridx = 0;
		gbc_EditArea.gridy = 0;
		gbc_EditArea.weightx = 1;
		gbc_EditArea.weighty = 0.95;
		//Add...
		add(editArea, gbc_EditArea); add(back,gbc_Back);
		//editArea Add...
		editArea.add(colorLabel);
		editArea.add(edit_Color);
		editArea.add(locationXLabel);
		editArea.add(locationXTextField);
		editArea.add(locationYLabel);
		editArea.add(locationYTextField);
	}	
	public JButton getColorButton() {
		return edit_Color;
	}
	public void selectEdit() {
		if(selectedForma instanceof Circuferencia) {
			editArea.add(raioLabel);
			editArea.add(raioTextField);
			raioTextField.setText(Integer.toString((int) ((Circuferencia)selectedForma).getRaio()));
		}
		else {
			editArea.add(alturaLabel);
			editArea.add(alturaTextField);
			editArea.add(larguraLabel);
			editArea.add(larguraTextField);
		}
	}
	
	public void resetEdit() {
		if(selectedForma instanceof Circuferencia) {
			editArea.remove(raioLabel);
			editArea.remove(raioTextField);
		}
		else {
			editArea.remove(alturaLabel);
			editArea.remove(alturaTextField);
			editArea.remove(larguraLabel);
			editArea.remove(larguraTextField);
		}
	}
	
	public void setupPanel(Forma f) {
		selectedForma = f;
		selectEdit();
		selectedForma.setSelected();
		edit_Color.setBackground(selectedForma.getCor());
		locationXTextField.setText(Integer.toString(selectedForma.getCenter().x));
		locationYTextField.setText(Integer.toString(selectedForma.getCenter().y));
		alturaTextField.setText(Integer.toString(-selectedForma.getAltura()));
		larguraTextField.setText(Integer.toString(-selectedForma.getLargura()));
	}
	
	
	private void setMainColors(Component c, Color background) {
		c.setBackground(background);
		c.setForeground(Color.WHITE);
	}
}
