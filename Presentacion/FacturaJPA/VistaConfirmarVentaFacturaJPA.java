package presentacion.FacturaJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.FacturaJPA.TFacturaConCarrito;
import negocio.FacturaJPA.TFacturaJPA;
import negocio.FacturaJPA.TLineaFacturaJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaConfirmarVentaFacturaJPA extends JFrame implements IGUI {
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;

	public VistaConfirmarVentaFacturaJPA(){
		setTitle("Confirmar venta");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("Id del empleado que emite la factura:");
		idTextField = new JTextField(10);

		JButton add = new JButton("Confirmar");
		JButton cancel = new JButton("Cancelar");
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idEmpleado = Integer.parseInt(idTextField.getText());
					DateFormat formato= new SimpleDateFormat("dd/MM/yyyy");  
					TFacturaJPA tFactura= new TFacturaJPA(idEmpleado, formato.format(new Date()));
					TFacturaConCarrito datos= new TFacturaConCarrito(tFactura,VistaAbrirVentaFacturaJPA.carrito);
					Controlador.getInstance().accion(Evento.ALTA_FACTURA_JPA,datos);
					dispose();
				}catch(NumberFormatException parseExc){
					JOptionPane.showMessageDialog(null, "Error, los datos introducidos deben ser numéricos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Evento.VOLVER_MENU_ABRIR_VENTA, null);
				dispose();
			}
		});
		
		panel.add(idLabel);
		panel.add(idTextField);
		panel.add(add);
		panel.add(cancel);
		
		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@Override
	public void actualizar(int evento, Object datos) {

	}
}
