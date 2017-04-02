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
		for (int i = 0; i < N_PONTOS; i++) {
			addPoint(locationsX[i], locationsY[i]);
		}
	}
	/**
	 * @return the n_PONTOS
	 */
	public int getN_PONTOS() {
		return N_PONTOS;
	}	
}
