package formas2D;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

import gui.NegativeNumberException;

@SuppressWarnings("serial")
/*
toda forma extende poligono que é feito com 2 vetores: um com as coordenadas X e outro com as coordenadas Y. Alem
do numero de pontos que serao feitos as partir desse vertor. Cada forma implementa o poligono de uma jeito diferente
Retangulo:
	-Usa os 4 pontos para ser feito.
Triangulo:
	-Usa somente 3 dos 4 pontos para ser criado.
Circunferencia:
	-Usa a distancia entre coordenada X inicial(quando o mouse é presionado) e a coordenada X final(quando o mouse é solto)
	para calcular o raio e a partir dele criar os pontos do circulo.
*/
public abstract class Forma extends Polygon {
	protected Color cor;
	protected int locationsX[], locationsY[], locationsXFromCenter[], locationsYFromCenter[], altura, largura;
	//Variavel usada para saber se a forma esta selecinada e desenhar a borda de selecao.
	protected boolean isSelected = false;
	protected Point center;

	/**
	 * @param cor
	 * @param x localizacao na tela
	 * @param y localizacao na tela
	 */
	public Forma(Color cor, int locationsX[], int locationsY[]) {
		this.cor = cor;
		this.locationsX = locationsX;
		this.locationsY = locationsY;
		calculateAlturaLargura();
		calculateCenter();
		calculateLocationsFromCenter();
	}
	/**
	 * @return the cor
	 */
	public Color getCor() {
		return cor;
	}
	/**
	 * @return the x(localizacao na tela)
	 */
	public int[] getlocationsX() {
		return locationsX;
	}
	/**
	 * @return the y(localizacao na tela)
	 */
	public int[] getlocationsY() {
		return locationsY;
	}
	/**
	 * @param cor the cor to set
	 */
	public void setCor(Color cor) {
		this.cor = cor;
	}
	/**
	 * @param x(localizacao na tela) the x to set
	 */
	public void setlocationsX(int locationsX[]) {
		this.locationsX = locationsX;
	}
	/**
	 * @param y(localizacao na tela) the y to set
	 */
	public void setlocationsY(int locationsY[]) {
		this.locationsY = locationsY;
	}
	/**
	 * @return the isSelected
	 */
	public boolean IsSelected() {
		return isSelected;
	}
	/**
	 * @param isSelected the isSelected to set
	 */
	public void setSelected() {
		this.isSelected = true;
	}
	
	public void setUnselected() {
		this.isSelected = false;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) throws NegativeNumberException {
		if (center.x < 0|| center.y < 0) {
			throw new NegativeNumberException();
		} else {
			this.center = center;
		}
	}
	
	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}
	/**
	 * @return the largura
	 */
	public int getLargura() {
		return largura;
	}
	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	/**
	 * @param largura the largura to set
	 */
	public void setLargura(int largura) {
		this.largura = largura;
	}
	/*
	Como toda forma tem sua propria logica para criacao cada uma delas tem que implemtar de forma diferente
	a funcao de recriacao
	*/
	public abstract void refactor();
	/*
	Para facilitar a edicao do local e do tamanho das formas eu uso as localizacao dadas no construtor
	para calcular a altura e o centro da forma, e crio as formas com esses novos pontos em fucao 
	dessas variaveis (altura,largura e centro).

	*/
	public void calculateAlturaLargura() {
		altura = locationsY[0] - locationsY[2];
		largura = locationsX[0] - locationsX[2];
	}
	
	public void calculateCenter() {
		center = new Point(locationsX[0] - (int) (largura/2), locationsY[0] - (int) (altura/2));
	}
	
	public void calculateLocationsFromCenter() {
		locationsXFromCenter = new int[locationsX.length];
		locationsYFromCenter = new int[locationsY.length];
		locationsXFromCenter[0] = center.x - largura/2;
		locationsXFromCenter[1] = center.x - largura/2;
		locationsXFromCenter[2] = center.x + largura/2;
		locationsXFromCenter[3] = center.x + largura/2;
		locationsYFromCenter[0] = center.y - altura/2;
		locationsYFromCenter[1] = center.y + altura/2;
		locationsYFromCenter[2] = center.y + altura/2;
		locationsYFromCenter[3] = center.y - altura/2;
	}
}
