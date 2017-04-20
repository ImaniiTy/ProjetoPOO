package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorsPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFileChooser fileChooser = new JFileChooser();
	private FlowLayout layout;
	private DrawAreaPanel drawArea;
	private ColorChooser myColorChooser;
	private JFrame colorChooserFrame;
	
	public ColorsPanel(DrawAreaPanel drawArea) {
		this.drawArea = drawArea;
		layout = new FlowLayout(FlowLayout.LEFT, 0, 1);
		setLayout(layout);
		setPreferredSize(new Dimension(700,40));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		JButton abrir = new JButton();
		abrir.setBackground(Color.DARK_GRAY);
		abrir.setPreferredSize(new Dimension(35, 35));
		abrir.setHorizontalAlignment(SwingConstants.CENTER);
		abrir.setBorder(null);
		try {
			abrir.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("OpenFIcon.gif"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abrir.setContentAreaFilled(false);
		abrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnval = fileChooser.showOpenDialog(drawArea);
				if (returnval == JFileChooser.APPROVE_OPTION) {
					drawArea.getEditor().carregarFormas(fileChooser.getSelectedFile());
					drawArea.repaint();
				}
			}
		});
		JButton salvar = new JButton();
		salvar.setText("Salvar");
		salvar.setBackground(Color.DARK_GRAY);
		salvar.setPreferredSize(new Dimension(35, 35));
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setBorder(null);
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnval = fileChooser.showSaveDialog(drawArea);
				if (returnval == JFileChooser.APPROVE_OPTION) {
					drawArea.getEditor().salvarFormas(fileChooser.getSelectedFile());
				}
			}
		});
		JButton limparTela = new JButton();
		limparTela.setText("Limpar Tela");
		limparTela.setBackground(Color.DARK_GRAY);
		limparTela.setPreferredSize(new Dimension(35, 35));
		limparTela.setHorizontalAlignment(SwingConstants.CENTER);
		limparTela.setBorder(null);
		limparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawArea.getEditor().limparListaDeFormas();
				drawArea.repaint();
			}
		});
		add(abrir); add(salvar); add(limparTela);
		//color chooser
		myColorChooser = new ColorChooser();
		colorChooserFrame = new JFrame();
		colorChooserFrame.setBounds(0, 0, 400, 300);
		colorChooserFrame.getContentPane().add(myColorChooser);
		JButton moreColors = new JButton("Mais Cores");
		moreColors.setBackground(Color.DARK_GRAY);
		moreColors.setPreferredSize(new Dimension(35, 35));
		moreColors.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colorChooserFrame.setVisible(true);
			}
		});
		add(moreColors);
	}
}
