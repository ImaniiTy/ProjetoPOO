package formas2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Editor {
	private final int WIDTH = 750, HEIGHT = 600;
	public static final int RETANGULO = 1;
	public static final int TRIANGULO = 2;
	public static final int CIRCUNFERENCIA = 3;
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
		case CIRCUNFERENCIA:
			lastP = new Circuferencia(cor, locationsX, locationsY);
			break;
		default:
			lastP = new Retangulo(cor, locationsX, locationsY);
			break;
		}
		formas.add(lastP);
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
		drawInBufferedImage();
		g.drawImage(bimage, 0, 0, null);
	}
	
	public void salvarFormas(File f) {
		try {
			//PrintStream ps = new PrintStream(f);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(formas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carregarFormas(File f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			formas = (ArrayList<Forma>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
