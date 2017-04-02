package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;

import gui.Principal;

public class tsteee {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal teste = new Principal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
