import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Ventana {
	
	private GestorFacutras gestorFacutras;
	private Factura factura;
	
	private CardLayout car;

	private JFrame frmEjercicio;
	private JPanel pnRegistroTrabajo;
	private JButton btnAadirAFactura;
	private JButton btnCerrarFactura;
	private JTextField txtTipo;
	private JLabel lblNewLabel;
	private JTextField txtMetrosCuadrados;
	private JLabel lblMetrosCuadrados;
	private JTextField txtCostePintura;
	private JLabel lblCosteDePintura;
	private JTextField txtHorasTrabajadas;
	private JLabel lblHorasTrabajadas;
	private JTextField txtHoraTraba;
	private JLabel lblPrecioPorHora;
	private JPanel pnHome;
	private JPanel pnCerrarFactura;
	private JTextField txtDireccion;
	private JLabel lblDireccin;
	private JLabel lblFecha;
	private JDateChooser dateChooser;
	private JButton btnTerminar;
	private JButton btnAadirMs;
	private JScrollPane scrollPane;
	private JTextArea txtPrevisualizacion;
	private JLabel lblCompletaLosCampos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
		car = ((CardLayout) pnHome.getLayout());
		factura=new Factura(new ArrayList<Trabajo>(), null, null);
		gestorFacutras=new GestorFacutras();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEjercicio = new JFrame();
		frmEjercicio.setTitle("Ejercicio 4");
		frmEjercicio.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmEjercicio.setBounds(100, 100, 633, 389);
		frmEjercicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEjercicio.getContentPane().add(getPnHome(), BorderLayout.CENTER);
	}

	private JPanel getPnRegistroTrabajo() {
		if (pnRegistroTrabajo == null) {
			pnRegistroTrabajo = new JPanel();
			pnRegistroTrabajo.setBackground(Color.WHITE);
			GridBagLayout gbl_pnRegistroTrabajo = new GridBagLayout();
			gbl_pnRegistroTrabajo.columnWidths = new int[]{94, 111, 13, 127, 0, 100, 0, 0};
			gbl_pnRegistroTrabajo.rowHeights = new int[]{65, 20, 20, 28, 20, 20, 36, 23, 0, 0};
			gbl_pnRegistroTrabajo.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnRegistroTrabajo.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			pnRegistroTrabajo.setLayout(gbl_pnRegistroTrabajo);
			GridBagConstraints gbc_lblCompletaLosCampos = new GridBagConstraints();
			gbc_lblCompletaLosCampos.anchor = GridBagConstraints.WEST;
			gbc_lblCompletaLosCampos.insets = new Insets(0, 0, 5, 5);
			gbc_lblCompletaLosCampos.gridwidth = 5;
			gbc_lblCompletaLosCampos.gridx = 1;
			gbc_lblCompletaLosCampos.gridy = 0;
			pnRegistroTrabajo.add(getLblCompletaLosCampos(), gbc_lblCompletaLosCampos);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			pnRegistroTrabajo.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_txtTipo = new GridBagConstraints();
			gbc_txtTipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTipo.insets = new Insets(0, 0, 5, 5);
			gbc_txtTipo.gridwidth = 2;
			gbc_txtTipo.gridx = 2;
			gbc_txtTipo.gridy = 1;
			pnRegistroTrabajo.add(getTxtTipo(), gbc_txtTipo);
			GridBagConstraints gbc_lblMetrosCuadrados = new GridBagConstraints();
			gbc_lblMetrosCuadrados.anchor = GridBagConstraints.EAST;
			gbc_lblMetrosCuadrados.insets = new Insets(0, 0, 5, 5);
			gbc_lblMetrosCuadrados.gridx = 1;
			gbc_lblMetrosCuadrados.gridy = 2;
			pnRegistroTrabajo.add(getLblMetrosCuadrados(), gbc_lblMetrosCuadrados);
			GridBagConstraints gbc_txtMetrosCuadrados = new GridBagConstraints();
			gbc_txtMetrosCuadrados.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMetrosCuadrados.insets = new Insets(0, 0, 5, 5);
			gbc_txtMetrosCuadrados.gridwidth = 2;
			gbc_txtMetrosCuadrados.gridx = 2;
			gbc_txtMetrosCuadrados.gridy = 2;
			pnRegistroTrabajo.add(getTxtMetrosCuadrados(), gbc_txtMetrosCuadrados);
			GridBagConstraints gbc_lblCosteDePintura = new GridBagConstraints();
			gbc_lblCosteDePintura.anchor = GridBagConstraints.EAST;
			gbc_lblCosteDePintura.insets = new Insets(0, 0, 5, 5);
			gbc_lblCosteDePintura.gridx = 1;
			gbc_lblCosteDePintura.gridy = 3;
			pnRegistroTrabajo.add(getLblCosteDePintura(), gbc_lblCosteDePintura);
			GridBagConstraints gbc_txtCostePintura = new GridBagConstraints();
			gbc_txtCostePintura.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCostePintura.insets = new Insets(0, 0, 5, 5);
			gbc_txtCostePintura.gridwidth = 2;
			gbc_txtCostePintura.gridx = 2;
			gbc_txtCostePintura.gridy = 3;
			pnRegistroTrabajo.add(getTxtCostePintura(), gbc_txtCostePintura);
			GridBagConstraints gbc_lblHorasTrabajadas = new GridBagConstraints();
			gbc_lblHorasTrabajadas.anchor = GridBagConstraints.EAST;
			gbc_lblHorasTrabajadas.insets = new Insets(0, 0, 5, 5);
			gbc_lblHorasTrabajadas.gridx = 1;
			gbc_lblHorasTrabajadas.gridy = 4;
			pnRegistroTrabajo.add(getLblHorasTrabajadas(), gbc_lblHorasTrabajadas);
			GridBagConstraints gbc_lblPrecioPorHora = new GridBagConstraints();
			gbc_lblPrecioPorHora.anchor = GridBagConstraints.EAST;
			gbc_lblPrecioPorHora.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioPorHora.gridx = 1;
			gbc_lblPrecioPorHora.gridy = 5;
			pnRegistroTrabajo.add(getLblPrecioPorHora(), gbc_lblPrecioPorHora);
			GridBagConstraints gbc_txtHorasTrabajadas = new GridBagConstraints();
			gbc_txtHorasTrabajadas.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHorasTrabajadas.insets = new Insets(0, 0, 5, 5);
			gbc_txtHorasTrabajadas.gridwidth = 2;
			gbc_txtHorasTrabajadas.gridx = 2;
			gbc_txtHorasTrabajadas.gridy = 4;
			pnRegistroTrabajo.add(getTxtHorasTrabajadas(), gbc_txtHorasTrabajadas);
			GridBagConstraints gbc_txtHoraTraba = new GridBagConstraints();
			gbc_txtHoraTraba.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHoraTraba.insets = new Insets(0, 0, 5, 5);
			gbc_txtHoraTraba.gridwidth = 2;
			gbc_txtHoraTraba.gridx = 2;
			gbc_txtHoraTraba.gridy = 5;
			pnRegistroTrabajo.add(getTxtHoraTrabjaCoste(), gbc_txtHoraTraba);
			GridBagConstraints gbc_btnAadirAFactura = new GridBagConstraints();
			gbc_btnAadirAFactura.anchor = GridBagConstraints.NORTH;
			gbc_btnAadirAFactura.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnAadirAFactura.insets = new Insets(0, 0, 5, 5);
			gbc_btnAadirAFactura.gridx = 3;
			gbc_btnAadirAFactura.gridy = 7;
			pnRegistroTrabajo.add(getBtnAadirAFactura(), gbc_btnAadirAFactura);
			GridBagConstraints gbc_btnCerrarFactura = new GridBagConstraints();
			gbc_btnCerrarFactura.insets = new Insets(0, 0, 5, 5);
			gbc_btnCerrarFactura.anchor = GridBagConstraints.NORTH;
			gbc_btnCerrarFactura.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnCerrarFactura.gridx = 5;
			gbc_btnCerrarFactura.gridy = 7;
			pnRegistroTrabajo.add(getBtnCerrarFactura(), gbc_btnCerrarFactura);
		}
		return pnRegistroTrabajo;
	}
	private JButton getBtnAadirAFactura() {
		if (btnAadirAFactura == null) {
			btnAadirAFactura = new JButton("A\u00F1adir a factura");
			btnAadirAFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkEmpty()) {
						try {
							double metrosCuadrados= Double.parseDouble(getTxtMetrosCuadrados().getText());
							double costePinturaMC= Double.parseDouble(getTxtCostePintura().getText());
							double horasTraba= Double.parseDouble(getTxtHorasTrabajadas().getText());
							double horasTrabaCoste= Double.parseDouble(getTxtHoraTrabjaCoste().getText());
							String area = getTxtTipo().getText();
							Trabajo trabajo = new Trabajo(area, metrosCuadrados, costePinturaMC, horasTraba, horasTrabaCoste);
							factura.addTrabajo(trabajo);
							JOptionPane.showMessageDialog(null, "El trabajo se ha añadido a la factura");
							getTxtMetrosCuadrados().setText("");
							getTxtCostePintura().setText("");
							getTxtHorasTrabajadas().setText("");
							getTxtHoraTrabjaCoste().setText("");
							getTxtTipo().setText("");
							
						}catch(Exception pce){
							JOptionPane.showMessageDialog(null, "Algún campo inválido");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Algún campo está vacío");
					}
				}

			});
			btnAadirAFactura.setBackground(Color.WHITE);
		}
		return btnAadirAFactura;
	}
	
	private boolean checkEmpty() {
		if(getTxtCostePintura().getText().isEmpty() || getTxtTipo().getText().isEmpty() || getTxtHorasTrabajadas().getText().isEmpty() ||
				getTxtMetrosCuadrados().getText().isEmpty() || getTxtHoraTrabjaCoste().getText().isEmpty()) {
			return false;
		}
		return true;
	}
	private JButton getBtnCerrarFactura() {
		if (btnCerrarFactura == null) {
			btnCerrarFactura = new JButton("Cerrar factura");
			btnCerrarFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTxtPrevisualizacion().setText(factura.toString());
					car.show(pnHome, "pnCerrarFactura");
				}
			});
			btnCerrarFactura.setBackground(Color.WHITE);
		}
		return btnCerrarFactura;
	}
	private JTextField getTxtTipo() {
		if (txtTipo == null) {
			txtTipo = new JTextField();
			txtTipo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!Character.isLetter(c))
						e.consume();
				}
			});
			txtTipo.setBackground(Color.WHITE);
			txtTipo.setColumns(10);
		}
		return txtTipo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tipo de \u00E1rea:");
			lblNewLabel.setBackground(Color.WHITE);
		}
		return lblNewLabel;
	}
	private JTextField getTxtMetrosCuadrados() {
		if (txtMetrosCuadrados == null) {
			txtMetrosCuadrados = new JTextField();
			txtMetrosCuadrados.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if (((caracter < '0') || (caracter > '9'))
							&& (caracter != '\b' /* corresponde a BACK_SPACE */)
							&& caracter!='.') {
						e.consume();
					}
					
				}
			});
			txtMetrosCuadrados.setBackground(Color.WHITE);
			txtMetrosCuadrados.setColumns(10);
		}
		return txtMetrosCuadrados;
	}
	private JLabel getLblMetrosCuadrados() {
		if (lblMetrosCuadrados == null) {
			lblMetrosCuadrados = new JLabel("Metros cuadrados:");
			lblMetrosCuadrados.setBackground(Color.WHITE);
		}
		return lblMetrosCuadrados;
	}
	private JTextField getTxtCostePintura() {
		if (txtCostePintura == null) {
			txtCostePintura = new JTextField();
			txtCostePintura.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if (((caracter < '0') || (caracter > '9'))
							&& (caracter != '\b' /* corresponde a BACK_SPACE */)
							&& caracter!='.') {
						e.consume();
					}
				}
			});
			txtCostePintura.setBackground(Color.WHITE);
			txtCostePintura.setColumns(10);
		}
		return txtCostePintura;
	}
	private JLabel getLblCosteDePintura() {
		if (lblCosteDePintura == null) {
			lblCosteDePintura = new JLabel("<html><p>Coste de pintura</p><p> por metro cuadrado:</p><html>");
			lblCosteDePintura.setBackground(Color.WHITE);
		}
		return lblCosteDePintura;
	}
	private JTextField getTxtHorasTrabajadas() {
		if (txtHorasTrabajadas == null) {
			txtHorasTrabajadas = new JTextField();
			txtHorasTrabajadas.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if (((caracter < '0') || (caracter > '9'))
							&& (caracter != '\b' /* corresponde a BACK_SPACE */)
							&& caracter!='.') {
						e.consume();
					}
				}
			});
			txtHorasTrabajadas.setBackground(Color.WHITE);
			txtHorasTrabajadas.setColumns(10);
		}
		return txtHorasTrabajadas;
	}
	private JLabel getLblHorasTrabajadas() {
		if (lblHorasTrabajadas == null) {
			lblHorasTrabajadas = new JLabel("Horas trabajadas:");
			lblHorasTrabajadas.setBackground(Color.WHITE);
		}
		return lblHorasTrabajadas;
	}
	private JTextField getTxtHoraTrabjaCoste() {
		if (txtHoraTraba == null) {
			txtHoraTraba = new JTextField();
			txtHoraTraba.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if (((caracter < '0') || (caracter > '9'))
							&& (caracter != '\b' /* corresponde a BACK_SPACE */)
							&& caracter!='.') {
						e.consume();
					}
				}
			});
			txtHoraTraba.setBackground(Color.WHITE);
			txtHoraTraba.setColumns(10);
		}
		return txtHoraTraba;
	}
	private JLabel getLblPrecioPorHora() {
		if (lblPrecioPorHora == null) {
			lblPrecioPorHora = new JLabel("<html><p>Precio por</p><p> hora trabajada:</p><html>");
			lblPrecioPorHora.setBackground(Color.WHITE);
		}
		return lblPrecioPorHora;
	}
	private JPanel getPnHome() {
		if (pnHome == null) {
			pnHome = new JPanel();
			pnHome.setLayout(new CardLayout(0, 0));
			pnHome.add(getPnRegistroTrabajo(), "pnRegistroTrabajo");
			pnHome.add(getPnCerrarFactura(), "pnCerrarFactura");
		}
		return pnHome;
	}
	private JPanel getPnCerrarFactura() {
		if (pnCerrarFactura == null) {
			pnCerrarFactura = new JPanel();
			pnCerrarFactura.setBackground(Color.WHITE);
			GridBagLayout gbl_pnCerrarFactura = new GridBagLayout();
			gbl_pnCerrarFactura.columnWidths = new int[]{0, 136, 109, 83, 175, 0, 0};
			gbl_pnCerrarFactura.rowHeights = new int[]{31, 20, 40, 27, 85, 32, 93, 0, 0};
			gbl_pnCerrarFactura.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_pnCerrarFactura.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			pnCerrarFactura.setLayout(gbl_pnCerrarFactura);
			GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
			gbc_lblDireccin.anchor = GridBagConstraints.EAST;
			gbc_lblDireccin.fill = GridBagConstraints.VERTICAL;
			gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDireccin.gridx = 1;
			gbc_lblDireccin.gridy = 1;
			pnCerrarFactura.add(getLblDireccin(), gbc_lblDireccin);
			GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
			gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
			gbc_txtDireccion.gridwidth = 2;
			gbc_txtDireccion.gridx = 2;
			gbc_txtDireccion.gridy = 1;
			pnCerrarFactura.add(getTxtDireccion(), gbc_txtDireccion);
			GridBagConstraints gbc_lblFecha = new GridBagConstraints();
			gbc_lblFecha.anchor = GridBagConstraints.EAST;
			gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
			gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblFecha.gridx = 1;
			gbc_lblFecha.gridy = 3;
			pnCerrarFactura.add(getLblFecha(), gbc_lblFecha);
			GridBagConstraints gbc_dateChooser = new GridBagConstraints();
			gbc_dateChooser.anchor = GridBagConstraints.WEST;
			gbc_dateChooser.fill = GridBagConstraints.VERTICAL;
			gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
			gbc_dateChooser.gridwidth = 3;
			gbc_dateChooser.gridx = 2;
			gbc_dateChooser.gridy = 3;
			pnCerrarFactura.add(getDateChooser(), gbc_dateChooser);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.gridheight = 3;
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 4;
			pnCerrarFactura.add(getScrollPane(), gbc_scrollPane);
			GridBagConstraints gbc_btnAadirMs = new GridBagConstraints();
			gbc_btnAadirMs.anchor = GridBagConstraints.SOUTH;
			gbc_btnAadirMs.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnAadirMs.insets = new Insets(0, 0, 5, 5);
			gbc_btnAadirMs.gridx = 4;
			gbc_btnAadirMs.gridy = 4;
			pnCerrarFactura.add(getBtnAadirMs(), gbc_btnAadirMs);
			GridBagConstraints gbc_btnTerminar = new GridBagConstraints();
			gbc_btnTerminar.insets = new Insets(0, 0, 5, 5);
			gbc_btnTerminar.anchor = GridBagConstraints.NORTH;
			gbc_btnTerminar.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnTerminar.gridx = 4;
			gbc_btnTerminar.gridy = 6;
			pnCerrarFactura.add(getBtnTerminar(), gbc_btnTerminar);
		}
		return pnCerrarFactura;
	}
	private JTextField getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
		}
		return txtDireccion;
	}
	private JLabel getLblDireccin() {
		if (lblDireccin == null) {
			lblDireccin = new JLabel("Direcci\u00F3n: ");
		}
		return lblDireccin;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha:");
		}
		return lblFecha;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setMinSelectableDate(new Date());
			dateChooser.setDate(new Date());
		}
		return dateChooser;
	}
	private JButton getBtnTerminar() {
		if (btnTerminar == null) {
			btnTerminar = new JButton("Terminar");
			btnTerminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getTxtDireccion().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "No ha indicado la dirección");
					}
					else if(getTxtPrevisualizacion().getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Factura vacía");
					}else {
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String fecha = df.format(getDateChooser().getDate());
					String dir = getTxtDireccion().getText();
					factura.setFecha(fecha);
					factura.setDireccion(dir);
					
					gestorFacutras.addFacturas(factura);
					JOptionPane.showMessageDialog(null, "Factura cerrada --> añadido al xml");
					int resp=JOptionPane.showConfirmDialog(null, "¿Añadirá más facturas?","",JOptionPane.YES_NO_OPTION);
					if(resp==JOptionPane.YES_OPTION){
						car.show(pnHome, "pnRegistroTrabajo");
						factura=new Factura(new ArrayList<Trabajo>(), null, null);
					}else {
						String xml = JOptionPane.showInputDialog("Nombre para el archivo .xml (sin la terminación .xml)");
						gestorFacutras.generarXML(xml);
						JOptionPane.showMessageDialog(null, "Se ha guardado en el archivo: "+xml+".xml");
						car.show(pnHome, "pnRegistroTrabajo");
						getTxtDireccion().setText("");
						getTxtPrevisualizacion().setText("");
					}
				}}
			});
			btnTerminar.setBackground(Color.WHITE);
		}
		return btnTerminar;
	}
	private JButton getBtnAadirMs() {
		if (btnAadirMs == null) {
			btnAadirMs = new JButton("A\u00F1adir m\u00E1s trabajos");
			btnAadirMs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					car.show(pnHome, "pnRegistroTrabajo");
				}
			});
			btnAadirMs.setBackground(Color.WHITE);
		}
		return btnAadirMs;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setViewportView(getTxtPrevisualizacion());
		}
		return scrollPane;
	}
	private JTextArea getTxtPrevisualizacion() {
		if (txtPrevisualizacion == null) {
			txtPrevisualizacion = new JTextArea();
			txtPrevisualizacion.setEditable(false);
		}
		return txtPrevisualizacion;
	}
	private JLabel getLblCompletaLosCampos() {
		if (lblCompletaLosCampos == null) {
			lblCompletaLosCampos = new JLabel("Completa los campos y a\u00F1ade un trabajo a la factura");
			lblCompletaLosCampos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCompletaLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCompletaLosCampos;
	}
}
