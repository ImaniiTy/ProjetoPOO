package formas2D;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

@SuppressWarnings("serial")
public abstract class Forma extends Polygon {
	protected Color cor;
	protected int locationsX[], locationsY[], locationsXFromCenter[], locationsYFromCenter[], altura, largura;
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
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public abstract void refactor();
	
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
