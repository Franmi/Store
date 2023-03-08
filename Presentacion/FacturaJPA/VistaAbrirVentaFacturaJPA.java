package presentacion.FacturaJPA;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAbrirVentaFacturaJPA extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	protected static Map<Integer, Integer> carrito;
	
	public VistaAbrirVentaFacturaJPA(){
		setTitle("Menu abrir venta");
		carrito = new HashMap<Integer,Integer>();

		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		JButton addProductoButton = new JButton("Añadir producto");
		JButton deleteProductoButton = new JButton("Eliminar producto");
		JButton showProductosButton = new JButton("Mostrar carrito");
		JButton confirmarVentaButton = new JButton("Confirmar Venta");
		JButton atrasButton = new JButton("Atrás");
		
		panel.add(addProductoButton);
		panel.add(deleteProductoButton);
		panel.add(showProductosButton);
		panel.add(confirmarVentaButton);
		panel.add(atrasButton);
		
		
		atrasButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
				dispose();
			}
			
		});
		
		addProductoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_AÑADIR_PRODUCTO_FACTURA_JPA, null);
				setVisible(false);

			}
			
		});
		
		deleteProductoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_PRODUCTO_FACTURA_JPA, null);
				setVisible(false);
			}
			
		});
		
		showProductosButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if(carrito.entrySet().isEmpty())JOptionPane.showMessageDialog(null, "El carrito esta vacío", "Carrito", JOptionPane.DEFAULT_OPTION);

				else{
					String s = "";
					for(Entry<Integer, Integer> entry:carrito.entrySet()){
						s+="Id Producto: "+ entry.getKey()+ " Cantidad: "+ entry.getValue() +"\n";
					}
					JTextArea textArea = new JTextArea(s);
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setPreferredSize(new Dimension(200, 100));
					JOptionPane.showMessageDialog(null, scrollPane, "Carrito", JOptionPane.DEFAULT_OPTION);
				}
				
			}
			
		});
		
		confirmarVentaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_CERRAR_VENTA_FACTURA_JPA, null);
				setVisible(false);
			}
			
		});
		
		
		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	}
	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(true);
		if(evento == Evento.RES_ALTA_FACTURA_JPA_OK) {
			int id = (int) datos;
			JOptionPane.showMessageDialog(this, "Factura dada de alta correctamente, con id: " + id);
		} 
		else if(evento == Evento.RES_ALTA_FACTURA_JPA_KO){
			String str = datos.toString();
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
