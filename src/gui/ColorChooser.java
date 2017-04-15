package gui;

import java.awt.Dimension;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.colorchooser.AbstractColorChooserPanel;

@SuppressWarnings("serial")
public class ColorChooser extends JColorChooser {
	private ChooserTab myChooser[] = new ChooserTab[1];
	private AbstractColorChooserPanel cc[] = getChooserPanels();
	public ColorChooser() {
		//myChooser[0] = new ChooserTab();
		//setChooserPanels(myChooser);
		for (int i = 1; i < cc.length; i++) {
			removeChooserPanel(cc[i]);
		}
		setPreferredSize(new Dimension(300, 400));
		setPreviewPanel(new JComponent() {
		});
	}
}
