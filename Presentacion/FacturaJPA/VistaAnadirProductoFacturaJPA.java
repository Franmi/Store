
package presentacion.FacturaJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Factura.TLineaFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;
import presentacion.Factura.VistaAbrirVenta;


public class VistaAnadirProductoFacturaJPA extends JFrame implements IGUI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	private JTextField cantidadTextField;

	public VistaAnadirProductoFacturaJPA(){
		setTitle("AÑADIR PRODUCTO AL CARRITO");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("Id producto:");
		idTextField = new JTextField(20);
		JLabel cantidadLabel = new JLabel("Cantidad a comprar:");
		cantidadTextField = new JTextField(20);
		
		JButton add = new JButton("Añadir");
		JButton cancel = new JButton("Cancelar");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigoProducto = Integer.parseInt(idTextField.getText());
					int cantidad = Integer.parseInt(cantidadTextField.getText());
					if(cantidad<1){JOptionPane.showMessageDialog(null, "Error, la cantidad debe ser positiva", "ERROR", JOptionPane.ERROR_MESSAGE);}
					else{
						if(!VistaAbrirVentaFacturaJPA.carrito.containsKey(codigoProducto)){
							VistaAbrirVentaFacturaJPA.carrito.put(codigoProducto, cantidad);
						}else VistaAbrirVentaFacturaJPA.carrito.put(codigoProducto, cantidad+VistaAbrirVentaFacturaJPA.carrito.get(codigoProducto));
						Controlador.getInstance().accion(Evento.VOLVER_MENU_ABRIR_VENTA, null);
						dispose();
					}
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
		panel.add(cantidadLabel);
		panel.add(cantidadTextField);
		panel.add(add);
		panel.add(cancel);
		
		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actualizar(int evento, Object datos) {

	}
}