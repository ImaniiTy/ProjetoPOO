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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorsPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
        private final Color FONT_COLOR = Color.WHITE;
	private JFileChooser fileChooser = new JFileChooser();
	private FlowLayout layout;
	private DrawAreaPanel drawArea;
	private ColorChooser myColorChooser;
	private JFrame colorChooserFrame;
	private Color corEscolhida = Color.WHITE;
        
	public ColorsPanel(DrawAreaPanel drawArea) {
		this.drawArea = drawArea;
		layout = new FlowLayout(FlowLayout.LEFT, 5, 1);
		setLayout(layout);
		setPreferredSize(new Dimension(700,40));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		JButton abrir = new JButton();
                //Abrir Arquivo
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
                //Salvar Arquivo
		JButton salvar = new JButton();
		salvar.setText("Salvar");
		salvar.setBackground(Color.DARK_GRAY);
                salvar.setForeground(FONT_COLOR);
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
                //Limpar Tela
		JButton limparTela = new JButton();
		limparTela.setText("Limpar Tela");
		limparTela.setBackground(Color.DARK_GRAY);
                limparTela.setForeground(FONT_COLOR);
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
		
		//color chooser
		myColorChooser = new ColorChooser();
		colorChooserFrame = new JFrame();
		colorChooserFrame.setBounds(0, 0, 400, 300);
		colorChooserFrame.getContentPane().add(myColorChooser);
                JLabel labelCor = new JLabel("");
                labelCor.setBackground(Color.WHITE);
                labelCor.setPreferredSize(new Dimension(35, 35));
                labelCor.setOpaque(true);
                
               
		JButton moreColors = new JButton("Mais Cores");
		moreColors.setBackground(Color.DARK_GRAY);
                moreColors.setForeground(FONT_COLOR);
		moreColors.setPreferredSize(new Dimension(35, 35));
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
                edit.setText("Abrir Janela de Edição");
		edit.setBackground(Color.DARK_GRAY);
                edit.setForeground(FONT_COLOR);
		edit.setPreferredSize(new Dimension(35, 35));
		edit.setHorizontalAlignment(SwingConstants.CENTER);
		edit.setBorder(null);
                edit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        drawArea.getPrincipalFrame().getLista().setVisible(true);
                    }
		});
                
                //Add..
                add(abrir); add(salvar); add(limparTela); add(moreColors);  add(labelCor); add(edit);
	}
}
