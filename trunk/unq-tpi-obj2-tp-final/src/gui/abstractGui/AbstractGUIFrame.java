package gui.abstractGui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Frame maqueta. Inicializa un frame para que éste pueda verse, y tiene el boton volver.
 */
public abstract class AbstractGUIFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JFrame mainFrame;
	private JPanel panel;
	
	protected AbstractGUIFrame (JFrame frame){
		this.setMainFrame(frame);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(new Dimension(850, 300));
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(getPanel());

		this.init();
		
		panel.add(mkBotonVolver());
	}
	
	protected abstract void init();

	/**
	 * Cierra la ventana actual y vuelve a la anterior
	 */
	protected JComponent mkBotonVolver() {
		JButton button = new JButton("Volver");
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AbstractGUIFrame.this.dispose();
				AbstractGUIFrame.this.getMainFrame().setVisible(true);
			}
			
		});
		return button;
	}

	
	//setters&getters
	protected void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	protected JFrame getMainFrame() {
		return mainFrame;
	}

	protected void setPanel(JPanel container) {
		this.panel = container;
	}

	protected JPanel getPanel() {
		return panel;
	}
}
