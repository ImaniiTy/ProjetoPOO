package formas2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.EOFException;
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

import javax.swing.DefaultListModel;

import gui.ErrorPopUp;
import gui.ListaFormas;
import gui.OpenErrorPopUp;

public class Editor {
	private final int WIDTH = 750, HEIGHT = 600;
	public static final int MOUSE = 0;
	public static final int RETANGULO = 1;
	public static final int TRIANGULO = 2;
	public static final int CIRCUNFERENCIA = 3;
	private ArrayList<Forma> formas;
	private BufferedImage bimage;
	private Graphics2D bImageGraphics;
	private Forma lastP;
	private int shape;
	private Color cor;
	private DefaultListModel<Forma> list;

	public Editor() {
		formas = new ArrayList<>();
		list = new DefaultListModel<>();
		shape = MOUSE;
		cor = Color.BLACK;
		lastP = null;
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

	public void addOnRelease(int[] locationsX, int[] locationsY) {
		if(shape != MOUSE){
			clearDragTrash();
			addForma(locationsX, locationsY);
			addOnList(formas.get(formas.size() - 1));
			clearLastP();
		}
	}
	public ArrayList<Forma> getArrayFormas() {
		return this.formas;
	}

	public DefaultListModel<Forma> getList() {
		return this.list;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}
	public void setCor(Color cor) {
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
		}
		if(shape != MOUSE){
			formas.add(lastP);
		}

	}

	public void addOnList(Forma f) {
		if(shape != MOUSE){
			list.addElement(f);
		}
	}


	public void clearDragTrash() {
		if(shape != MOUSE){
			formas.remove(lastP);
		}
	}

	public void clearLastP() {
		lastP = null;
	}

	public void removeForma(int index) {
		formas.remove(list.get(index));
		list.remove(index);
	}
	public void drawBorder(Forma f) {
		Rectangle fBounds = f.getBounds();
		bImageGraphics.setColor(Color.BLACK);
		bImageGraphics.draw(fBounds);
		fBounds.grow(1, 1);
		bImageGraphics.setColor(Color.RED);
		bImageGraphics.draw(fBounds);
		fBounds.grow(1, 1);
		bImageGraphics.setColor(Color.BLACK);
		bImageGraphics.draw(fBounds);
	}
	public void limparListaDeFormas() {
		formas = new ArrayList<>();
		list.clear();
	}

	public void drawInBufferedImage() {
		bImageGraphics.setColor(Color.WHITE);
		bImageGraphics.fillRect(0, 0, WIDTH, HEIGHT);
		Forma selectedForma = null;
		for (Forma p : formas) {
			bImageGraphics.setColor(p.getCor());
			bImageGraphics.fill(p);
			if(p.IsSelected()) {
				selectedForma = p;
			}
		}
		if(selectedForma != null) {
			drawBorder(selectedForma);
		}
	}

	public void drawImage(Graphics g) {
		drawInBufferedImage();
		g.drawImage(bimage, 0, 0, null);
	}

	public void salvarFormas(File f) {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Forma forma : formas) {
				oos.writeObject(forma);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void carregarFormas(File f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true){
				Forma forma = (Forma) ois.readObject();
				formas.add(forma);
				list.addElement(forma);
			}
		}catch (EOFException e){

		} catch (IOException e) {
			// TODO Auto-generated catch block
			ErrorPopUp openError = new OpenErrorPopUp();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
