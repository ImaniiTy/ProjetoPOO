package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import formas2D.Forma;

public class EditPanel extends JPanel {
	private JButton edit_Color;
	private Forma selectedForma;
	private ListaFormas listFrame;
	private DefaultListModel<Forma> list;
	private DrawAreaPanel drawArea;
	public EditPanel(ListaFormas listaFrame) {
		this.listFrame = listaFrame;
		selectedForma = listaFrame.getList().getSelectedValue();
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
				
				drawArea.getEditor().getArrayFormas().get(listFrame.getList().getSelectedIndex()).setUnselected();
				listFrame.changeLayout(listFrame.LISTPANEL);
				drawArea.repaint();
			}
		});
		edit_Color = new JButton();
		setMainColors(edit_Color, Color.BLACK);
		//Labels
		JLabel colorLabel = new JLabel("Editar Cor", SwingConstants.CENTER);
		JLabel locationLabel = new JLabel("Editar Localizacao", SwingConstants.CENTER);
		JLabel sizeLabel = new JLabel("Editar Tamanho", SwingConstants.CENTER);
		
		//Text Fields
		Integer x =  new Integer(selectedForma.getCenter().x);
		Integer y =  new Integer(selectedForma.getCenter().y);
		JTextField locationXTextField = new JTextField(x.toString());
		locationXTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setCenter(new Point(Integer.parseInt(locationXTextField.getText()), y));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		
		JTextField locationYTextField = new JTextField(y.toString());
		locationYTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setCenter(new Point(x, Integer.parseInt(locationYTextField.getText())));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		Integer largura =  new Integer(selectedForma.getLargura());
		JTextField larguraTextField = new JTextField(largura.toString());
		larguraTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setLargura(Integer.parseInt(larguraTextField.getText()));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		Integer altura =  new Integer(selectedForma.getAltura());
		JTextField alturaTextField = new JTextField(altura.toString());
		alturaTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedForma.setAltura(Integer.parseInt(alturaTextField.getText()));
				selectedForma.refactor();
				drawArea.repaint();
			}
		});
		
		//Panels
		JPanel editArea =  new JPanel(new GridLayout(12,5));
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
		//Add.
		add(editArea, gbc_EditArea); add(back,gbc_Back);
		//editArea Add...
		editArea.add(colorLabel);
		editArea.add(edit_Color);
		editArea.add(locationLabel);
	}	
	public JButton getColorButton() {
		return edit_Color;
	}
	
	private void setMainColors(Component c, Color background) {
		c.setBackground(background);
		c.setForeground(Color.WHITE);
	}
}
