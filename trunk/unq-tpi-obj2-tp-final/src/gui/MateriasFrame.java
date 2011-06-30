package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.interfaces.CatedraIMPL;
import model.interfaces.MateriaIMPL;
import model.interfaces.UniversidadIMPL;
import universidad.Universidad;

public class MateriasFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private JList listaMaterias, listaCatedras;

	public MateriasFrame(JFrame frame) {
		super(frame);
	}

	@Override
	protected void init() {
		JPanel materiasPanel = new JPanel();
		materiasPanel.setLayout(new FlowLayout());

		materiasPanel.add(this.mkListaMaterias());
		materiasPanel.add(this.mkListaCatedras());

		this.getPanel().add(materiasPanel);
	}

	private JScrollPane mkListaCatedras() {
		JList listaCatedras = new JList();
		// listaCatedras.setSize(new Dimension(100, 50));
		listaCatedras.setPreferredSize(new Dimension(100, 150));
		this.setListaCatedras(listaCatedras);

		return new JScrollPane(this.getListaCatedras());
	}

	/**
	 * Crea la lista de materias y setea la variable de instancia
	 */
	private JScrollPane mkListaMaterias() {
		UniversidadIMPL universidad = Universidad.getInstance();
		Vector<MateriaIMPL> materias = new Vector<MateriaIMPL>(universidad.getMaterias());
		JList listaMaterias = new JList(materias);
		// listaMaterias.setSize(new Dimension(100, 50));
		listaMaterias.setPreferredSize(new Dimension(100, 150));

		listaMaterias.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				MateriasFrame.this.actualizarListaCatedras();
			}
		});

		this.setListaMaterias(listaMaterias);

		return new JScrollPane(listaMaterias);
	}

	protected void actualizarListaCatedras() {
		MateriaIMPL materia = (MateriaIMPL) this.getListaMaterias().getSelectedValue();
		this.getListaCatedras().setListData(new Vector<CatedraIMPL>(materia.getCatedras()));
	}

	// getters&setters
	private void setListaMaterias(JList materias) {
		listaMaterias = materias;
	}

	public JList getListaMaterias() {
		return listaMaterias;
	}

	private void setListaCatedras(JList catedras) {
		listaCatedras = catedras;
	}

	public JList getListaCatedras() {
		return listaCatedras;
	}
}
