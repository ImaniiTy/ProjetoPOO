package formas2D;

import java.awt.Color;

@SuppressWarnings("serial")
public class Retangulo extends Forma {
	private final int N_PONTOS = 4;
	/**
	 * @param cor
	 * @param locationsX
	 * @param locationsY
	 */
	public Retangulo(Color cor, int[] locationsX, int[] locationsY) {
		super(cor, locationsX, locationsY);
		calculatePoints();
	}
	/**
	 * @return the nPontos
	 */
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
	public int getnPontos() {
		return N_PONTOS;
	}
	
	public String toString() {
		return "Retangulo";
	}
}
