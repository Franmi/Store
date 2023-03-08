package presentacion.EmpleadoJPA;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.EmpleadoJPA.TTiempoCompleto;
import negocio.EmpleadoJPA.TTiempoParcial;
import negocio.Turno.TTurno;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaUpdateEmpleadoJPA extends JFrame implements IGUI {

	JTextField id, nombre, apellido, dni;
	JTextField sueldoBase,complemento,sueldo,horasTrabajadas;
	ButtonGroup buttonGroup;

	public VistaUpdateEmpleadoJPA() {
		setTitle("Modificar Empleado");
		JPanel panel = new JPanel();

		JPanel informacion = new JPanel();
		JLabel idLabel = new JLabel("Id: ");
		id = new JTextField(5);
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombre = new JTextField(10);
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellido = new JTextField(25);
		JLabel dniLabel = new JLabel("DNI: ");
		dni = new JTextField(11);
		informacion.add(idLabel);
		informacion.add(id);
		informacion.add(nombreLabel);
		informacion.add(nombre);
		informacion.add(apellidoLabel);
		informacion.add(apellido);
		informacion.add(dniLabel);
		informacion.add(dni);

		JPanel botones = new JPanel();
		JButton aceptarButton = new JButton("Aceptar");
		JButton cancelarButton = new JButton("Cancelar");
		
		buttonGroup = new ButtonGroup();
		JRadioButton tempCompleto = new JRadioButton("Tiempo Completo");
		buttonGroup.add(tempCompleto);
		JRadioButton tempParcial = new JRadioButton("Tiempo Parcial");
		buttonGroup.add(tempParcial);
		JLabel tCompletoBase = new JLabel("Sueldo Base: ");
		JLabel tCompletoComplemento = new JLabel("Complemento: ");
		JLabel tParcialSueldo = new JLabel("Sueldo: ");
		JLabel tParcialBase = new JLabel("Horas Trabajadas: ");
		
		
		JPanel tempCompletoPanel= new JPanel();
		JPanel tempParcialPanel= new JPanel();
		sueldoBase= new JTextField(10);
		complemento = new JTextField(10);
		sueldo = new JTextField(7);
		horasTrabajadas = new JTextField(7);
		
		tempCompletoPanel.add(tCompletoBase);
		tempCompletoPanel.add(sueldoBase);
		tempCompletoPanel.add(tCompletoComplemento);
		tempCompletoPanel.add(complemento);
		tempParcialPanel.add(tParcialSueldo);
		tempParcialPanel.add(sueldo);
		tempParcialPanel.add(tParcialBase);
		tempParcialPanel.add(horasTrabajadas);
		
		
		CardLayout tipos= new CardLayout();
		JPanel tipoPanel= new JPanel(tipos);
		tipoPanel.add(tempCompletoPanel,"tempCompleto");
		tipoPanel.add(tempParcialPanel,"tempParcial");

		informacion.add(tempCompleto);
		informacion.add(tempParcial);
		botones.add(aceptarButton);
		botones.add(cancelarButton);
		
		
		tempCompleto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipos.show(tipoPanel, "tempCompleto");
			}
		});
		
		tempParcial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipos.show(tipoPanel, "tempParcial");

			}
		});
		
		aceptarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					if (id.getText().length()!= 0 && nombre.getText().length() != 0 && apellido.getText().length() != 0 && ((sueldoBase.getText().length() != 0 && 
							complemento.getText().length() !=0)||(sueldo.getText().length()!= 0 && horasTrabajadas.getText().length()!=0))) {

						TEmpleadoJPA tEmpleado = null;
						if(tempCompleto.isSelected()){
							tEmpleado = new TTiempoCompleto(Integer.parseInt(id.getText()), nombre.getText(),apellido.getText(), dni.getText(),true,
									Double.parseDouble(sueldoBase.getText()),Double.parseDouble(complemento.getText()));
						}
						else if(tempParcial.isSelected()){
							tEmpleado = new TTiempoParcial(Integer.parseInt(id.getText()),nombre.getText(),apellido.getText(),dni.getText(),true,
									Double.parseDouble(sueldo.getText()),Integer.parseInt(horasTrabajadas.getText()));
						}
						Controlador.getInstance().accion(Evento.MODIFICAR_EMPLEADO_JPA, tEmpleado);
					}
					else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "El id debe ser un número");
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			}
		});

		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
				dispose();
			}
		});

		panel.add(informacion);
		panel.add(tipoPanel);
		panel.add(botones);

		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_MODIFICAR_EMPLEADO_JPA_OK) {
			JOptionPane.showMessageDialog(this, "Se ha modificado correctamente el Empleado con id " + (Integer) datos);
		} else if (evento == Evento.RES_MODIFICAR_EMPLEADO_JPA_KO) {
			JOptionPane.showMessageDialog(this, "No se ha podido modificar el empleado");
		}

	}
}