/**
 * 
 */
package presentacion.Producto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadAllProducto extends JFrame implements IGUI {
	private static final int height = 480;
	private static final int width = 480;

	public VistaReadAllProducto() {
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LISTAR Producto");
		
		JPanel mainpanel=new JPanel();
		JLabel showpanel=new JLabel("Mostrar todos los productos");
		
		JButton read= new JButton("Mostrar");
		JButton atras=new JButton("Atras");
		
		mainpanel.add(showpanel);
		mainpanel.add(read);
		mainpanel.add(atras);
		
		getContentPane().add(mainpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		read.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try{
				Controlador.getInstance().accion(Evento.LISTAR_PRODUCTO,null);
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_PRODUCTO,null);
			}
		});
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_PRODUCTO, null);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	

	@Override
	public void actualizar(int evento, Object datos) {
		// TODO Auto-generated method stub
		setVisible(false);
		switch(evento){
		case Evento.RES_LISTAR_PRODUCTO_OK:{
			JTextArea textArea = new JTextArea(datos.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "Productos", JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_LISTAR_PRODUCTO_KO:{
			JOptionPane.showMessageDialog(this, "No hay existencias de nuestros productos");
			break;
		}
		default:
			break;
		}
	}
}