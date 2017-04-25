package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorsPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Color FONT_COLOR = Color.WHITE;
	private final Dimension BUTTON_DIMENSION = new Dimension(45, 45);
	private JFileChooser fileChooser = new JFileChooser();
	private FlowLayout layout;
	private DrawAreaPanel drawArea;
	private ColorChooser myColorChooser;
	private JFrame colorChooserFrame;
	private Color corEscolhida = Color.BLACK;

	public ColorsPanel(DrawAreaPanel drawArea) {
		this.drawArea = drawArea;
		layout = new FlowLayout(FlowLayout.LEFT, 5, 1);
		setLayout(layout);
		setPreferredSize(new Dimension(700,50));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		JButton abrir = new JButton();
		//Abrir Arquivo
		abrir.setBackground(Color.DARK_GRAY);
		abrir.setPreferredSize(BUTTON_DIMENSION);
		abrir.setHorizontalAlignment(SwingConstants.CENTER);
		abrir.setBorder(null);
		try {
			abrir.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("iconOpen.png"))));
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
		//Salvar Arquivo
		JButton salvar = new JButton();
		salvar.setBackground(Color.DARK_GRAY);
		salvar.setForeground(FONT_COLOR);
		salvar.setPreferredSize(BUTTON_DIMENSION);
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setBorder(null);
		try {
			salvar.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("SaveFIcon.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		//Limpar Tela
		JButton limparTela = new JButton();
		limparTela.setBackground(Color.DARK_GRAY);
		limparTela.setForeground(FONT_COLOR);
		limparTela.setPreferredSize(BUTTON_DIMENSION);
		limparTela.setHorizontalAlignment(SwingConstants.CENTER);
		limparTela.setBorder(null);
		try {
			limparTela.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("iconClear.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		limparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawArea.getEditor().limparListaDeFormas();
				drawArea.repaint();
			}
		});

		//color chooser
		myColorChooser = new ColorChooser();
		colorChooserFrame = new JFrame();
		colorChooserFrame.setBounds(0, 0, 400, 300);
		colorChooserFrame.getContentPane().add(myColorChooser);
		JLabel labelCor = new JLabel("");
		labelCor.setBackground(corEscolhida);
		labelCor.setPreferredSize(new Dimension(35, 35));
		labelCor.setOpaque(true);


		JButton moreColors = new JButton();
		moreColors.setBackground(Color.DARK_GRAY);
		moreColors.setForeground(FONT_COLOR);
		moreColors.setPreferredSize(BUTTON_DIMENSION);
		moreColors.setBorder(null);
		try {
			moreColors.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("iconPalette.gif"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moreColors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color corAux = myColorChooser.showDialog(null, "COR", Color.WHITE);
				if(corAux != null){
					corEscolhida = corAux;
				}
				drawArea.getEditor().setCor(corEscolhida);
				labelCor.setBackground(corEscolhida);
			}
		});
		//Abrir Janela de Edicao
		JButton edit = new JButton();
		edit.setBackground(Color.DARK_GRAY);
		edit.setForeground(FONT_COLOR);
		edit.setPreferredSize(BUTTON_DIMENSION);
		edit.setHorizontalAlignment(SwingConstants.CENTER);
		edit.setBorder(null);
		try {
			edit.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("iconList.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawArea.getPrincipalFrame().getLista().setVisible(true);
			}
		});

		//Add..
		add(abrir); add(salvar); add(limparTela); add(edit); add(moreColors);  add(labelCor);
	}
}
