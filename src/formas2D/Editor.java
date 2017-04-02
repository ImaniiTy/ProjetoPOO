package formas2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Editor {
	private final int WIDTH = 750, HEIGHT = 600;
	public static final int RETANGULO = 1;
	public static final int TRIANGULO = 2;
	private ArrayList<Forma> formas;
	private BufferedImage bimage;
	private Graphics2D bImageGraphics;
	private Forma lastP;
	private int shape;
	private Color cor;
	
	public Editor() {
		formas = new ArrayList<Forma>();
		cor = Color.BLACK;
		bimage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		bImageGraphics = bimage.createGraphics();
		bImageGraphics.setColor(Color.WHITE);
		bImageGraphics.fillRect(0, 0, WIDTH, HEIGHT);
	}
	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}
	
	public void setShape(int shape) {
		this.shape = shape;
	}
	public void setCor (Color cor) {
		this.cor = cor;
	}
	
	public void addForma(int[] locationsX, int[] locationsY) {
		switch (shape) {
		case RETANGULO:
			lastP = new Retangulo(cor, locationsX, locationsY);
			break;
		case TRIANGULO:
			lastP = new Triangulo(cor, locationsX, locationsY);
			break;
		default:
			lastP = new Retangulo(cor, locationsX, locationsY);
			break;
		}
		formas.add(lastP);
		drawInBufferedImage();
	}
	
	public void removeLastForma() {
		formas.remove(lastP);
	}
	
	public void drawInBufferedImage() {
		bImageGraphics.setColor(Color.WHITE);
		bImageGraphics.fillRect(0, 0, WIDTH, HEIGHT);
		for (Forma p : formas) {
			bImageGraphics.setColor(p.getCor());
			bImageGraphics.fill(p);
		}
	}
	
	public void drawImage(Graphics g) {
		g.drawImage(bimage, 0, 0, null);
	}
	
}
