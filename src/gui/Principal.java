package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class Principal {
	protected static final int ALTURA = 600, LARGURA = 800;
	protected static final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
	private JFrame frame = new JFrame();
	private ListaFormas lista;
	
	public Principal() {
		setupGui();
	}
	
	protected void setupGui() {
		// Frame Config...
		frame.setVisible(true);
		GridBagLayout frameLayout = new GridBagLayout();
		frameLayout.rowWeights = new double[]{0.0};
		frame.setBounds(screenResolution.width/2 - (LARGURA/2), screenResolution.height/2 - (ALTURA/2), LARGURA, ALTURA);
		frame.getContentPane().setLayout(frameLayout);
		frame.getContentPane().setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setResizable(false);
		//frame.setMaximizedBounds(new Rectangle(800, 600));
		//Panels Config
		DrawAreaPanel drawArea = new DrawAreaPanel(this);
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
		gbc_toolsPanel.gridy = 1;
		//gbc_toolsPanel.gridheight = 2;
		frame.getContentPane().add(toolsPanel, gbc_toolsPanel);
		ColorsPanel colorsPanel = new ColorsPanel(drawArea);
		GridBagConstraints gbc_colorsPanel = new GridBagConstraints();
		gbc_colorsPanel.fill = GridBagConstraints.BOTH;
		gbc_colorsPanel.gridx = 0;
		gbc_colorsPanel.gridy = 0;
		gbc_colorsPanel.gridwidth = 2;
		frame.getContentPane().add(colorsPanel, gbc_colorsPanel);
		lista = new ListaFormas(frame.getSize(),drawArea);
		lista.setVisible(true);
		//Console config
		JFrame consoleFrame = new JFrame();
		consoleFrame.setBounds(960, 540, 500, 300);
		//File Open
		JFileChooser open = new JFileChooser();
		
		//File Save
		JFileChooser save = new JFileChooser();
		
	}
        public ListaFormas getLista(){
            return this.lista;
        }
}


