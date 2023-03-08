package presentacion.Espectaculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Espectaculo.TParticipa;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaDesasignarPezDeEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaDesasignarPezDeEspectaculo() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ELIMINAR PEZ DE ESPECTÁCULO");
		JPanel panel = new JPanel();
		JLabel idEspectaculo = new JLabel("Id del espectáculo del que desea eliminar pez:");
		final JTextField idEspectaculoText = new JTextField(20);
		JLabel idPez = new JLabel("Id del pez a desvincular:");
		final JTextField idPezText = new JTextField(20);
		
		JButton add = new JButton("ACEPTAR");
		JButton cancel = new JButton("CANCELAR");
		
		panel.add(idEspectaculo);
		panel.add(idEspectaculoText);
		panel.add(idPez);
		panel.add(idPezText);
		panel.add(add);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false); 
			
			try {
				int idEspectaculo = Integer.parseInt(idEspectaculoText.getText());
				int idPez = Integer.parseInt(idPezText.getText());
				
				Controlador.getInstance().accion(Evento.DESASIGNAR_PEZ, new TParticipa(idPez, idEspectaculo));
			
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
		}
	});
	
	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			setVisible(false);
			
			try {
				Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
			
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	});	
}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento){
		case Evento.RES_DESVINCULAR_PEZ_OK:{
			JOptionPane.showMessageDialog(this, "Se desvinculo correctamente el pez", " Desvincular Pez ", JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_DESVICULAR_PEZ_KO:{
			JOptionPane.showMessageDialog(this, "No hay pez para desvincular",
					"Desvincular Pez", JOptionPane.ERROR_MESSAGE);
		}
		default:
			break;
		}
		
	}
}
