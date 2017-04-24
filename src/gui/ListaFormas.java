package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import formas2D.Forma;

@SuppressWarnings("serial")
public class ListaFormas extends JFrame {
	public final String LISTPANEL = "Lista";
	public final String EDITPANEL = "Editar";
	private Dimension resolution;
	private JList<Forma> lista;
	private DefaultListModel<Forma> listModel;
	private DrawAreaPanel drawArea;
	private CardLayout cardLayout;
        
	
	public ListaFormas (Dimension resolution, DrawAreaPanel drawArea) {
		this.resolution = resolution;
		this.drawArea = drawArea;
		this.listModel = drawArea.getEditor().getList();
		setupGui();
	}
	public JList<Forma> getList() {
		return lista;
	}
	
	public void setupGui() {
		//Setup Frame
		resolution.width = 200;
		resolution.height = resolution.height + 10;
		cardLayout =  new CardLayout();
		setLayout(cardLayout);
		cardLayout.show(getContentPane(), LISTPANEL);
		setPreferredSize(resolution);
		setLocation(Principal.screenResolution.width/2 + (Principal.LARGURA/2 + 10), Principal.screenResolution.height/2 - (Principal.ALTURA/2 + 5));
		pack();
		//Setup Jlist
		lista = new JList<Forma>(listModel);
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setBackground(Color.GRAY);
		lista.setForeground(Color.WHITE);
		JScrollPane jsp = new JScrollPane(lista);
		jsp.setPreferredSize(new Dimension(200, 400));
		jsp.setBackground(Color.GRAY);
		jsp.setForeground(Color.WHITE);
		//Setup Buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(200, 200));
		buttonsPanel.setLayout(new GridLayout(2, 1, 5, 5));
		buttonsPanel.setBackground(Color.GRAY);
		JButton delete = new JButton("Delete");
		delete.setBackground(Color.DARK_GRAY);
		delete.setForeground(Color.WHITE);
		//Setup List Panel
		JPanel listPanel =  new JPanel(new GridBagLayout());
		//Setup EditPanel
		EditPanel editPanel = new EditPanel(this);
		//Setup Card Panel
		JPanel cardsPanel = new JPanel();
		//Delete Button Logic
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!lista.isSelectionEmpty()){
					while(lista.getSelectedIndex() != -1) {
						drawArea.getEditor().removeForma(lista.getSelectedIndex());
					}
					drawArea.repaint();
				}
			}
		});
		
		//
		JButton edit = new JButton("Edit");
		edit.setBackground(Color.DARK_GRAY);
		edit.setForeground(Color.WHITE);
		buttonsPanel.add(delete); buttonsPanel.add(edit);
		//Edit Button Logic
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!lista.isSelectionEmpty()){
					editPanel.getColorButton().setBackground(lista.getSelectedValue().getCor());
					drawArea.getEditor().getArrayFormas().get(lista.getSelectedIndex()).setSelected();
					cardLayout.show(getContentPane(), EDITPANEL);
					drawArea.repaint();
				}
			}
		});
		//
		//Constrains
		GridBagConstraints gbc_ButtonsPanel = new GridBagConstraints();
		gbc_ButtonsPanel.anchor = GridBagConstraints.CENTER;
		gbc_ButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_ButtonsPanel.gridx = 0;
		gbc_ButtonsPanel.gridy = 1;
		//gbc_ButtonsPanel.gridwidth = 2;
		gbc_ButtonsPanel.weightx = 1;
		gbc_ButtonsPanel.weighty = 0.1;
		
		GridBagConstraints gbc_jsp = new GridBagConstraints();
		gbc_jsp.anchor = GridBagConstraints.CENTER;
		gbc_jsp.fill = GridBagConstraints.BOTH;
		gbc_jsp.gridx = 0;
		gbc_jsp.gridy = 0;
		//gbc_jsp.gridwidth = 2;
		gbc_jsp.weightx = 1;
		gbc_jsp.weighty = 0.9;
		//Add..
		listPanel.add(buttonsPanel, gbc_ButtonsPanel); listPanel.add(jsp, gbc_jsp);
		add(listPanel, LISTPANEL); add(editPanel, EDITPANEL);
	}
	public DrawAreaPanel getDrawArea() {
		return drawArea;
	}
	public void changeLayout(String name) {
		cardLayout.show(getContentPane(), name);
	}
}
