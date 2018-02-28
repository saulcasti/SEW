import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class PaginaPrincipal {

	private ParserXML parseXml;
	private GestorArtistas gestorArtistas;
	
	private JFrame frmEjercicio;
	private JPanel panel;
	private JButton btnSeleccionarXml;
	private JScrollPane scrollPane;
	private JTextArea txtConciertos;
	private JComboBox<String> cBArtistas;
	private JScrollPane scrollPane_1;
	private JTextArea txtRutaxml;
	private JLabel lblSeleccionaElArchivo;
	private JLabel lblSeleccionaElArtista;
	private JPanel panel_1;
	private JLabel lblGirasDeDe;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal window = new PaginaPrincipal();
					window.frmEjercicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaginaPrincipal() {
		parseXml = new ParserXML();
		gestorArtistas = new GestorArtistas();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEjercicio = new JFrame();
		frmEjercicio.setTitle("Ejercicio 3");
		frmEjercicio.setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmEjercicio.setBounds(100, 100, 611, 374);
		frmEjercicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEjercicio.getContentPane().add(getPanel(), BorderLayout.CENTER);
		frmEjercicio.getContentPane().add(getPanel_1(), BorderLayout.NORTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getBtnSeleccionarXml());
			panel.add(getScrollPane());
			panel.add(getCBArtistas());
			panel.add(getScrollPane_1());
			panel.add(getLblSeleccionaElArchivo());
			panel.add(getLblSeleccionaElArtista());
		}
		return panel;
	}
	private JButton getBtnSeleccionarXml() {
		if (btnSeleccionarXml == null) {
			btnSeleccionarXml = new JButton("");
			btnSeleccionarXml.setToolTipText("Click para seleccionar el archivo xml");
			btnSeleccionarXml.setBorder(null);
			btnSeleccionarXml.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
			btnSeleccionarXml.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc=new JFileChooser();
					
					int seleccion=fc.showOpenDialog(null);
					if(seleccion==JFileChooser.APPROVE_OPTION){
					    File fichero=fc.getSelectedFile();
					    gestorArtistas.setArts(parseXml.getXML(fichero.getAbsolutePath()));
					    getTxtRutaxml().setText(fichero.getAbsolutePath());
					    getCBArtistas().setEnabled(true);
					    String[] model = gestorArtistas.getArtistas().toArray(new String[gestorArtistas.getArtistas().size()]);
						getCBArtistas().setModel(new DefaultComboBoxModel<String>(model));
						String txt ="";
						for(int i=0;i< model.length;i++) txt+=gestorArtistas.getConc(model[i]);
						getTxtConciertos().setText(txt);
					 
				}}
			});
			btnSeleccionarXml.setBackground(Color.WHITE);
			btnSeleccionarXml.setBounds(191, 67, 42, 37);
		}
		return btnSeleccionarXml;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(49, 130, 496, 171);
			scrollPane.setViewportView(getTxtConciertos());
		}
		return scrollPane;
	}
	private JTextArea getTxtConciertos() {
		if (txtConciertos == null) {
			txtConciertos = new JTextArea();
			txtConciertos.setFont(new Font("Arial", Font.BOLD, 14));
			txtConciertos.setBackground(Color.WHITE);
			txtConciertos.setEditable(false);
		}
		return txtConciertos;
	}
	private JComboBox<String> getCBArtistas() {
		if (cBArtistas == null) {
			cBArtistas = new JComboBox<String>();
			cBArtistas.setToolTipText("Click y solo ver\u00E1s los conciertos del artista seleccionado");
			cBArtistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTxtConciertos().setText(gestorArtistas.getConc((String)cBArtistas.getSelectedItem()));
				}
			});
			cBArtistas.setBackground(Color.WHITE);
			cBArtistas.setEnabled(false);
			cBArtistas.setBounds(348, 84, 152, 20);
		}
		return cBArtistas;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(49, 66, 136, 38);
			scrollPane_1.setViewportView(getTxtRutaxml());
		}
		return scrollPane_1;
	}
	private JTextArea getTxtRutaxml() {
		if (txtRutaxml == null) {
			txtRutaxml = new JTextArea();
			txtRutaxml.setEditable(false);
		}
		return txtRutaxml;
	}
	private JLabel getLblSeleccionaElArchivo() {
		if (lblSeleccionaElArchivo == null) {
			lblSeleccionaElArchivo = new JLabel("Selecciona el archivo .xml:");
			lblSeleccionaElArchivo.setBounds(49, 41, 152, 14);
		}
		return lblSeleccionaElArchivo;
	}
	private JLabel getLblSeleccionaElArtista() {
		if (lblSeleccionaElArtista == null) {
			lblSeleccionaElArtista = new JLabel("Selecciona el artista:");
			lblSeleccionaElArtista.setBounds(348, 59, 121, 14);
		}
		return lblSeleccionaElArtista;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.inactiveCaption);
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblGirasDeDe(), BorderLayout.NORTH);
		}
		return panel_1;
	}
	private JLabel getLblGirasDeDe() {
		if (lblGirasDeDe == null) {
			lblGirasDeDe = new JLabel("Descubre los conciertos de nuestros artistas");
			lblGirasDeDe.setBackground(SystemColor.inactiveCaption);
			lblGirasDeDe.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
			lblGirasDeDe.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGirasDeDe;
	}
}
