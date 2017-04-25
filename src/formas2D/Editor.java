package formas2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import gui.ErrorPopUp;
import gui.OpenErrorPopUp;
/*
Para desenhar a figura na tela ao inves de desenhar a figura direto no componente eu a desenho em uma buffered image
e apos isso eu desenho a imagem no Panel. Optei pelo uso desse metodo pois ao desenhar um nova forma eu redesenho todas
as anteriores e a buffered image é muito mais eficiente, oque torna seu uso melhor do que o uso do desenho direto no Panel. 
*/

public class Editor {
	private final int WIDTH = 750, HEIGHT = 600;
	public static final int MOUSE = 0;
	public static final int RETANGULO = 1;
	public static final int TRIANGULO = 2;
	public static final int CIRCUNFERENCIA = 3;
	//Array que guarda as formas
	private ArrayList<Forma> formas;
	private BufferedImage bimage;
	private Graphics2D bImageGraphics;
	//Variavel que guarda a ultima forma criada(usada para fazer o efeito de arrastar)
	private Forma lastP;
	//Variavel que guarda a forma selecinada
	private int shape;
	private Color cor;
	//Usado para fazer a lista de formas aparecer na interface
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
	/*
	Para adicionar a forma final(quando o mouse é solto) eu faco os seguintes passos:
	-Vejo se tem alguma forma selecionada
	-limpo a ultima forma salva pelo efeito de arrastar o mouse
	-adiciono a nova forma no array
	-adiciono a forma criada no passo anterior na lista que aparece na tela
	-limpo a variavel que guarda a ultima forma criada, pois assim eu evito que ao chamar a funcao que limpa
	a ultima forma se delete a forma final que eu acabei de adicionar
	*/
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
	/*
	Para saber qual forma deve ser criada eu usei uma variavel que diz a forma selecionada pelo usuario
	e a partir dela eu instancio a forma e no fim adiciono no array
	*/
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
	//adiciona a forma na lista que aparece na tela
	public void addOnList(Forma f) {
		if(shape != MOUSE){
			list.addElement(f);
		}
	}
	//limpa a ultima forma adicionada(usada no efeito de arrastar o mouse)
	public void clearDragTrash() {
		if(shape != MOUSE){
			formas.remove(lastP);
		}
	}
	//limpa a variavel que guarda a ultima forma(usada para evitar o erro descrito acima)
	public void clearLastP() {
		lastP = null;
	}

	public void removeForma(int index) {
		formas.remove(list.get(index));
		list.remove(index);
	}
	/*
	funcao usada para desenhar a borda na forma selecionada quando esta editando-a.
	*/
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
	//funcao usada para limpar a tela
	public void limparListaDeFormas() {
		formas = new ArrayList<>();
		list.clear();
	}
	/*
	funcao usada para desenhar as formas na buffered image.
	Para cada forma adicionada eu chamo essa funcao que redesenha todas as anteriores
	*/
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
		//desenha a borda da forma que esta selecionada
		if(selectedForma != null) {
			drawBorder(selectedForma);
		}
	}
	//desenha a imagem no Panel
	public void drawImage(Graphics g) {
		drawInBufferedImage();
		g.drawImage(bimage, 0, 0, null);
	}
	//Salva as formas em um arquivo(serializa)
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
	//Carrega as formas do arquivo para o array(des-serializa)
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
