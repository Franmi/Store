package presentacion.Controlador.FactoriaComando.imp;

import presentacion.Controlador.FactoriaComando.FactoriaComando;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoAnyadirPez;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoCreateEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoDeleteEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoDesvincularPez;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoEspectaculoPorEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoQueryEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoReadAllEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComandoUpdateEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoEspectaculo.ComnadoReadEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoBuscarFactura;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoCerrarVenta;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoDevolverEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoEliminarFactura;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoListarFacturas;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoModificarFactura;
import presentacion.Controlador.Comando.imp.ComandoFactura.ComandoQueryEntradas;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoAñadirPez;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoBuscarPez;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoEliminarPez;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoModificarPez;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoMostrarPeces;
import presentacion.Controlador.Comando.imp.ComandoPez.ComandoMostrarPecesEspectaculo;
import presentacion.Controlador.Comando.imp.ComandoProducto.ComandoAddProducto;
import presentacion.Controlador.Comando.imp.ComandoProducto.ComandoDeleteProducto;
import presentacion.Controlador.Comando.imp.ComandoProducto.ComandoReadAllProducto;
import presentacion.Controlador.Comando.imp.ComandoProducto.ComandoReadProducto;
import presentacion.Controlador.Comando.imp.ComandoProducto.ComandoUpdateProducto;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoAddTurno;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoCalcularNomina;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoDeleteTurno;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoModificarTurno;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoReadAllTurnos;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoReadTurno;
import presentacion.Controlador.Comando.imp.ComandoTurno.ComandoReadTurnosByEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoAddEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoDeleteEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoReadAllEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoReadEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoReadEmpleadoPorDNI;
import presentacion.Controlador.Comando.imp.ComandoEmpleado.ComandoUpdateEmpleado;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoAddEmpleadoJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoCalcularNominaJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoDeleteEmpladoJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoDesvincularTurno;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoReadAllEmpleadosJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoReadEmpleadoByTurno;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoReadEmpleadoJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoUpdateEmpleadoJPA;
import presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA.ComandoVincularTurno;
import presentacion.Controlador.Comando.imp.ComandoFacturaJPA.*;


public class FactoriaComandoImp extends FactoriaComando {

	public Comando createComando(int evento) {

		switch (evento) {

		// FACTURA
		case Evento.ALTA_FACTURA: {
			return new ComandoCerrarVenta();
		}
		case Evento.MOSTRAR_FACTURA: {
			return new ComandoBuscarFactura();
		}
		case Evento.MODIFICAR_FACTURA: {
			return new ComandoModificarFactura();
		}
		case Evento.ELIMINAR_FACTURA: {
			return new ComandoEliminarFactura();
		}
		case Evento.DEVOLVER_ESPECTACULO_FACTURA: {
			return new ComandoDevolverEspectaculo();
		}
		case Evento.LISTAR_FACTURAS: {
			return new ComandoListarFacturas();
		}

		// ESPECTÁCULO
		case Evento.ALTA_ESPECTACULO: {
			return new ComandoCreateEspectaculo();
		}

		case Evento.ELIMINAR_ESPECTACULO: {
			return new ComandoDeleteEspectaculo();
		}

		case Evento.MODIFICAR_ESPECTACULO: {
			return new ComandoUpdateEspectaculo();
		}

		case Evento.MOSTRAR_ESPECTACULO: {
			return new ComnadoReadEspectaculo();
		}

		case Evento.LISTAR_ESPECTACULO: {
			return new ComandoReadAllEspectaculo();
		}

		case Evento.ASIGNAR_PEZ: {
			return new ComandoAnyadirPez();
		}

		case Evento.DESASIGNAR_PEZ: {
			return new ComandoDesvincularPez();
		}

		// EMPLEADO
		case Evento.ALTA_EMPLEADO: {
			return new ComandoAddEmpleado();
		}

		case Evento.ELIMINAR_EMPLEADO: {
			return new ComandoDeleteEmpleado();
		}

		case Evento.MODIFICAR_EMPLEADO: {
			return new ComandoUpdateEmpleado();
		}

		case Evento.MOSTRAR_EMPLEADO: {
			return new ComandoReadEmpleado();
		}

		case Evento.LISTAR_EMPLEADO: {
			return new ComandoReadAllEmpleado();
		}

		case Evento.MOSTRAR_EMPLEADO_DNI: {
			return new ComandoReadEmpleadoPorDNI();
		}

		case Evento.MOSTRAR_ESPECTACULO_POR_EMPLEADO: {
			return new ComandoEspectaculoPorEmpleado();
		}

		// PEZ
		case Evento.ALTA_PEZ:
			return new ComandoAñadirPez();
		case Evento.ELIMINAR_PEZ:
			return new ComandoEliminarPez();
		case Evento.MODIFICAR_PEZ:
			return new ComandoModificarPez();
		case Evento.MOSTRAR_PEZ:
			return new ComandoBuscarPez();
		case Evento.LISTAR_PEZ:
			return new ComandoMostrarPeces();
		case Evento.LEER_PECES_ESPECTACULO:
			return new ComandoMostrarPecesEspectaculo();
			
		// TURNO
		case Evento.ELIMINAR_TURNO:
			return new ComandoDeleteTurno();
		case Evento.ALTA_TURNO:
			return new ComandoAddTurno();
		case Evento.MODIFICAR_TURNO:
			return new ComandoModificarTurno();
		case Evento.BUSCAR_TURNO:
			return new ComandoReadTurno();
		case Evento.LISTAR_TURNOS:
			return new ComandoReadAllTurnos();
		case Evento.MOSTRAR_TURNOS_EMPLEADO:
			return new ComandoReadTurnosByEmpleado();
		case Evento.CALCULAR_NOMINA_TURNO:
			return new ComandoCalcularNomina();
			
		//FACTURA JPA
		case Evento.ALTA_FACTURA_JPA:
			return new ComandoCerrarVentaJPA();
		case Evento.BUSCAR_FACTURA_JPA:
			return new ComandoBuscarFacturaJPA();
		case Evento.BUSCAR_FACTURA_PRODUCTO_JPA:
			return new ComandoBuscarFacturaProducto();
		case Evento.MODIFICAR_FACTURA_JPA:
			return new ComandoModificarFacturaJPA();
		case Evento.DEVOLVER_PRODUCTO:
			return new ComandoDevolverProducto();
		case Evento.MOSTRAR_FACTURA_COMPLETA_JPA:
			return new ComandoMostrarFacturaCompleta();
		case Evento.LISTAR_FACTURA_JPA:
			return new ComandoListarFacturaJPA();
		case Evento.VOLVER_MENU_ABRIR_VENTA:
			return new ComandoVolverMenuVenta();
		case Evento.ELIMINAR_FACTURA_JPA:
			return new ComandoEliminarFacturaJPA();

		// QUERIES
		case Evento.QUERY_ENTRADAS:
			return new ComandoQueryEntradas();
		case Evento.QUERY_ESPECTACULO:
			return new ComandoQueryEspectaculo();
			

	

		// EMPLEADOJPA
		
		case Evento.ALTA_EMPLEADO_JPA:
			return new ComandoAddEmpleadoJPA();
		case Evento.BUSCAR_EMPLEADO_JPA:
			return new ComandoReadEmpleadoJPA();
		case Evento.LISTAR_EMPLEADO_JPA:
			return new ComandoReadAllEmpleadosJPA();
		case Evento.VINCULAR_TURNO:
			return new ComandoVincularTurno();
		case Evento.ELIMINAR_EMPLEADO_JPA:
			return new ComandoDeleteEmpladoJPA();
		case Evento.DESVINCULAR_TURNO:
			return new ComandoDesvincularTurno();
		case Evento.MOSTRAR_EMPLEADOS_TURNO:
			return new ComandoReadEmpleadoByTurno();
		case Evento.MODIFICAR_EMPLEADO_JPA:
			return new ComandoUpdateEmpleadoJPA();
		case Evento.CALCULAR_NOMINA:
			return new ComandoCalcularNominaJPA();
		
		//Producto JPA
		case Evento.ALTA_PRODUCTO:
			return new ComandoAddProducto();
		case Evento.ELIMINAR_PRODUCTO:
			return new ComandoDeleteProducto();
		case Evento.LISTAR_PRODUCTO:
			return new ComandoReadAllProducto();
		case Evento.BUSCAR_PRODUCTO:
			return new ComandoReadProducto();
		case Evento.MODIFICAR_PRODUCTO:
			return new ComandoUpdateProducto();
			
			
			
			
		}	
		return null;
	}
}