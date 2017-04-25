package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;

import gui.Principal;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal principal = new Principal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
