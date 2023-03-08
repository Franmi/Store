package presentacion.FacturaJPA;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuFacturaJPA extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;
	
	public VistaMenuFacturaJPA(){
		setTitle("Menu Factura");
		
		JPanel panel = new JPanel(new GridLayout(3, 3));
		
		JButton abrirVentaButton = new JButton("Abrir venta");
		JButton buscarFactura = new JButton("Buscar por ID");
		JButton buscarPorProducto= new JButton("Buscar por producto");
		JButton mostrarFacturaCompleta= new JButton("Mostrar factura completa");
		JButton devolverProducto= new JButton("Devolver producto");
		JButton modificarFactura = new JButton("Modificar factura");
		JButton bajaFactura = new JButton("Baja factura");
		JButton listarFactura = new JButton("Listar facturas");
		JButton atrasButton = new JButton("Atrás");
		
		panel.add(abrirVentaButton);
		panel.add(buscarFactura);
		panel.add(buscarPorProducto);
		panel.add(mostrarFacturaCompleta);
		panel.add(devolverProducto);
		panel.add(modificarFactura);
		panel.add(bajaFactura);
		panel.add(listarFactura);
		panel.add(atrasButton);
		
		
		atrasButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.MENU_TIENDA, null);
				dispose();
			}
			
		});
		
		buscarFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_FACTURA_JPA, null);
				dispose();
			}
			
		});
		
		mostrarFacturaCompleta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_MOSTRAR_FACTURA_COMPLETA_JPA, null);
				dispose();
			}
			
		});
		
		buscarPorProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_FACTURA_PRODUCTO_JPA, null);
				dispose();
			}
			
		});
		
		devolverProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_DEVOLVER_PRODUCTO, null);
				dispose();
			}
			
		});
		
		abrirVentaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_ABRIR_VENTA_FACTURA_JPA, null);
				dispose();
			}
			
		});
		
		modificarFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_FACTURA_JPA, null);
				dispose();
			}
			
		});
		
		listarFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_FACTURAS_JPA, null);
				dispose();
			}
			
		});
		
		bajaFactura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_FACTURA_JPA, null);
				dispose();
			}
			
		});
		
		
		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	}
	@Override
	public void actualizar(int evento, Object datos) {		
	}

}
