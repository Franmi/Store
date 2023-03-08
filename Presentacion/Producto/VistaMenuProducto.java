/**
 * 
 */
package presentacion.Producto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuProducto extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;
	public VistaMenuProducto() {

		setTitle("Producto");
		JPanel panel=new JPanel(new GridLayout(1, 2));
		JButton AddProd=new JButton("Alta Producto");
		JButton read=new JButton("leer Producto");
		JButton delete=new JButton("eliminar Producto");
		JButton readAll=new JButton("leer todos Producto");
		JButton update=new JButton("Modificar Producto");
		JButton atras=new JButton("Atras");
		
		panel.add(AddProd);
		panel.add(read);
		panel.add(delete);
		panel.add(readAll);
		panel.add(update);
		panel.add(atras);
		
		getContentPane().add(panel);
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		AddProd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ALTA_PRODUCTO,null);
			}
		});
		
		read.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_PRODUCTO,null);
			}
		});
		
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_PRODUCTO,null);
			}
		});
		
		readAll.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_PRODUCTO,null);
			}
		});
		update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_PRODUCTO,null);
			}
		});
		
		atras.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.MENU_TIENDA,null);
			}
		});
	}
	
	@Override
	public void actualizar(int evento, Object datos) {
		// TODO Auto-generated method stub
		
	}
}