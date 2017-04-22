package formas2D;

import java.awt.Color;

@SuppressWarnings("serial")
public class Triangulo extends Forma {
	private final int N_PONTOS = 3;
	/**
	 * @param cor
	 * @param locationsX
	 * @param locationsY
	 */
	public Triangulo(Color cor, int[] locationsX, int[] locationsY) {
		super(cor, locationsX, locationsY);
		calculatePoints();
	}
	public void refactor() {
		super.calculateLocationsFromCenter();
		reset();
		calculatePoints();
	}
	public void calculatePoints() {
		for (int i = 0; i < N_PONTOS; i++) {
			addPoint(locationsXFromCenter[i], locationsYFromCenter[i]);
		}
	}
	/**
	 * @return the n_PONTOS
	 */
	public int getN_PONTOS() {
		return N_PONTOS;
	}
	
	public String toString() {
		return "Triangulo";
	}
}
