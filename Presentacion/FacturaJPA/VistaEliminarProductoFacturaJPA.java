package presentacion.FacturaJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;


public class VistaEliminarProductoFacturaJPA extends JFrame implements IGUI {
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	private JTextField cantidadTextField;

	public VistaEliminarProductoFacturaJPA(){
		setTitle("ELIMINAR PRODUCTO DEL CARRITO");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("Id del producto:");
		idTextField = new JTextField(20);
		JLabel cantidadLabel = new JLabel("Cantidad a eliminar:");
		cantidadTextField = new JTextField(20);
		
		JButton add = new JButton("Eliminar");
		JButton cancel = new JButton("Cancelar");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigoProducto = Integer.parseInt(idTextField.getText());
					int cantidad = Integer.parseInt(cantidadTextField.getText());
					
					if(VistaAbrirVentaFacturaJPA.carrito.containsKey(codigoProducto)){
						VistaAbrirVentaFacturaJPA.carrito.put(codigoProducto, Math.max(VistaAbrirVentaFacturaJPA.carrito.get(codigoProducto)-cantidad, 0));
						VistaAbrirVentaFacturaJPA.carrito.remove(codigoProducto, 0);
					};
					dispose();
					Controlador.getInstance().accion(Evento.VOLVER_MENU_ABRIR_VENTA, null);
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
		
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actualizar(int evento, Object datos) {
		
	}
}