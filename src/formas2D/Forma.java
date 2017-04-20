package formas2D;

import java.awt.Color;
import java.awt.Polygon;

@SuppressWarnings("serial")
public abstract class Forma extends Polygon {
	protected Color cor;
	protected int locationsX[],locationsY[];
	protected boolean isSelected = false;

	/**
	 * @param cor
	 * @param x localizacao na tela
	 * @param y localizacao na tela
	 */
	public Forma(Color cor, int locationsX[], int locationsY[]) {
		this.cor = cor;
		this.locationsX = locationsX;
		this.locationsY = locationsY;
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
	
	
}
