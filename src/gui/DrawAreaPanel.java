package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

import formas2D.Editor;

@SuppressWarnings("serial")
public class DrawAreaPanel extends JPanel{
	private int locationsX[] = new int[4], oldx;
	private int locationsY[] = new int[4], oldy;
	private MouseAdapter mAdapter;
	private MouseMotionAdapter mMotionAdapter;
	private Editor editor;
        private Principal principalFrame;
	
	public DrawAreaPanel(Principal principalFrame) {
            this.principalFrame = principalFrame;
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		editor = new Editor();
		mAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				locationsX[0] = e.getPoint().x;
				locationsY[0] = e.getPoint().y;
				oldx = locationsX[0];
				oldy = locationsY[0];
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				locationsX[2] = e.getPoint().x;
				locationsY[2] = e.getPoint().y;
				locationsX[1] = oldx;
				locationsY[1] = locationsY[2];
				locationsX[3] = locationsX[2];
				locationsY[3] = oldy;
				editor.addOnRelease(locationsX, locationsY);
				repaint();
			}
		};

		mMotionAdapter = new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				locationsX[2] = e.getPoint().x;
				locationsY[2] = e.getPoint().y;
				locationsX[1] = oldx;
				locationsY[1] = locationsY[2];
				locationsX[3] = locationsX[2];
				locationsY[3] = oldy;
				editor.clearDragTrash();
				editor.addForma(locationsX, locationsY);
				repaint();
			}
		};

		addMouseListener(mAdapter);
		addMouseMotionListener(mMotionAdapter);
	}
	
	/**
	 * @return the locationsX
	 */
	public int[] getLocationsX() {
		return locationsX;
	}
	/**
	 * @return the locationsY
	 */
	public int[] getLocationsY() {
		return locationsY;
	}
	
	public Editor getEditor() {
		return editor;
	}
        
        public Principal getPrincipalFrame(){
            return principalFrame;
        }
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		editor.drawImage(g);
	}	
}
