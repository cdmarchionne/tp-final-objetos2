package gui.main;

import gui.Index;
import Utils.GeneradorDeDatos;

public class RunApplication {
	public static void main(String[] args) {
		GeneradorDeDatos.loadDataSystem();
		new Index();
	}
}
