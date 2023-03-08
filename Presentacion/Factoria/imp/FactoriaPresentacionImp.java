package presentacion.Factoria.imp;

import presentacion.Factoria.FactoriaPresentacion;
import presentacion.Factura.VistaAbrirVenta;
import presentacion.Factura.VistaAñadirEspectaculoFactura;
import presentacion.Factura.VistaBuscarFactura;
import presentacion.Factura.VistaCerrarVenta;
import presentacion.Factura.VistaDevolverEspectaculo;
import presentacion.Factura.VistaEliminarEspectaculoFactura;
import presentacion.Factura.VistaEliminarFactura;
import presentacion.Factura.VistaMenuFactura;
import presentacion.Factura.VistaModificarFactura;
import presentacion.Factura.VistaMostrarFacturas;
import presentacion.Factura.VistaQueryEntradas;
import presentacion.FacturaJPA.BuscarFactura;
import presentacion.FacturaJPA.VistaAbrirVentaFacturaJPA;
import presentacion.FacturaJPA.VistaAnadirProductoFacturaJPA;
import presentacion.FacturaJPA.VistaBajaFacturaJPA;
import presentacion.FacturaJPA.VistaBuscarFacturaProducto;
import presentacion.FacturaJPA.VistaConfirmarVentaFacturaJPA;
import presentacion.FacturaJPA.VistaDevolverProducto;
import presentacion.FacturaJPA.VistaEliminarProductoFacturaJPA;
import presentacion.FacturaJPA.VistaMenuFacturaJPA;
import presentacion.FacturaJPA.VistaModificarFacturaJPA;
import presentacion.FacturaJPA.VistaMostrarFacturaCompleta;
import presentacion.FacturaJPA.VistaMostrarFacturasJPA;
import presentacion.Pez.VistaMenuPez;
import presentacion.Pez.VistaModificarPez;
import presentacion.Pez.VistaMostrarPeces;
import presentacion.Pez.VistaMostrarPecesPorEspectaculo;
import presentacion.Producto.VistaAddProducto;
import presentacion.Producto.VistaDeleteProducto;
import presentacion.Producto.VistaMenuProducto;
import presentacion.Producto.VistaReadAllProducto;
import presentacion.Producto.VistaReadProducto;
import presentacion.Producto.VistaUpdateProducto;
import presentacion.Tienda.VistaTienda;
import presentacion.Turno.VistaAddTurno;
import presentacion.Turno.VistaCalcularNomina;
import presentacion.Turno.VistaDeleteTurno;
import presentacion.Turno.VistaMenuTurno;
import presentacion.Turno.VistaReadAllTurnos;
import presentacion.Turno.VistaReadByEmpleado;
import presentacion.Turno.VistaReadTurno;
import presentacion.Turno.VistaUpdateTurno;

import java.util.HashMap;

import presentacion.IGUI;
import presentacion.Acuario.VistaAcuario;
import presentacion.Aplicacion.VistaAplicacion;
import presentacion.Controlador.Evento;
import presentacion.Empleado.VistaAltaEmpleado;
import presentacion.Empleado.VistaBajaEmpleado;
import presentacion.Empleado.VistaLeerEmpleado;
import presentacion.Empleado.VistaLeerEmpleadoPorDNI;
import presentacion.Empleado.VistaLeerTodosEmpleado;
import presentacion.Empleado.VistaMenuEmpleado;
import presentacion.Empleado.VistaUpdateEmpleado;
import presentacion.EmpleadoJPA.VistaAddEmpleado;
import presentacion.EmpleadoJPA.VistaCalcularNominaEmpleado;
import presentacion.EmpleadoJPA.VistaDeleteEmpleado;
import presentacion.EmpleadoJPA.VistaDesvincularTurno;
import presentacion.EmpleadoJPA.VistaMenuEmpleadoJPA;
import presentacion.EmpleadoJPA.VistaReadAllEmpleado;
import presentacion.EmpleadoJPA.VistaReadEmpleado;
import presentacion.EmpleadoJPA.VistaReadEmpleadoByTurno;
import presentacion.EmpleadoJPA.VistaUpdateEmpleadoJPA;
import presentacion.EmpleadoJPA.VistaVincularTurno;
import presentacion.Pez.VistaAltaPez;
import presentacion.Pez.VistaBuscarPez;
import presentacion.Pez.VistaEliminarPez;
import presentacion.Espectaculo.VistaAltaEspectaculo;
import presentacion.Espectaculo.VistaAsignarPezEnEspectaculo;
import presentacion.Espectaculo.VistaBajaEspectaculo;
import presentacion.Espectaculo.VistaDesasignarPezDeEspectaculo;
import presentacion.Espectaculo.VistaLeerEspectaculo;
import presentacion.Espectaculo.VistaLeerTodosEspectaculo;
import presentacion.Espectaculo.VistaMenuEspectaculo;
import presentacion.Espectaculo.VistaModificarEspectaculo;
import presentacion.Espectaculo.VistaMostrarEspectaculosPorEmpleado;
import presentacion.Espectaculo.VistaQueryEspectaculo;

public class FactoriaPresentacionImp extends FactoriaPresentacion {

	private HashMap<Integer, IGUI> mapa_vistas;

	public FactoriaPresentacionImp() {
		mapa_vistas = new HashMap<Integer, IGUI>();
	}

	public IGUI generarVista(int id) {
		IGUI igui;
		switch (id) {

		// APLICACION
		case Evento.MENU_APLICACION:
			return new VistaAplicacion();
		
		// ACUARIO
		case Evento.MENU_ACUARIO:
			return new VistaAcuario();

		// TIENDA
		case Evento.MENU_TIENDA:
			return new VistaTienda();
			
		// FACTURA	
		case Evento.VISTA_MENU_FACTURA:
			return new VistaMenuFactura();
		case Evento.VISTA_ABRIR_VENTA_FACTURA:
			return new VistaAbrirVenta();
		case Evento.VISTA_AÑADIR_ESPECTACULO_FACTURA:
			return new VistaAñadirEspectaculoFactura();
		case Evento.VISTA_ELIMINAR_ESPECTACULO_FACTURA:
			return new VistaEliminarEspectaculoFactura();
		case Evento.VISTA_CERRAR_VENTA_FACTURA:
		case Evento.ALTA_FACTURA:
			return new VistaCerrarVenta();
		case Evento.VISTA_ELIMINAR_FACTURA:
		case Evento.ELIMINAR_FACTURA:
			return new VistaEliminarFactura();
		case Evento.VISTA_BUSCAR_FACTURA:
		case Evento.MOSTRAR_FACTURA:
			return new VistaBuscarFactura();
		case Evento.VISTA_MODIFICAR_FACTURA:
		case Evento.MODIFICAR_FACTURA:
			return new VistaModificarFactura();
		case Evento.VISTA_DEVOLVER_ESPECTACULO_FACTURA:
		case Evento.DEVOLVER_ESPECTACULO_FACTURA:
			return new VistaDevolverEspectaculo();
		case Evento.VISTA_LISTAR_FACTURAS:
		case Evento.LISTAR_FACTURAS:
			return new VistaMostrarFacturas();

		// QUERIES
		case Evento.VISTA_QUERY_ENTRADAS:
			igui = new VistaQueryEntradas();
			mapa_vistas.put(Evento.VISTA_QUERY_ENTRADAS, igui);
			return igui;
		case Evento.QUERY_ENTRADAS:
			return mapa_vistas.get(Evento.VISTA_QUERY_ENTRADAS);
		case Evento.VISTA_QUERY_ESPECTACULO:
			igui = new VistaQueryEspectaculo();
			mapa_vistas.put(Evento.VISTA_QUERY_ESPECTACULO, igui);
			return igui;
		case Evento.QUERY_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_QUERY_ESPECTACULO);

		// PEZ
		case Evento.VISTA_MENU_PEZ:
			return new VistaMenuPez();
		case Evento.VISTA_LEER_PEZ:
			igui = new VistaBuscarPez();
			mapa_vistas.put(Evento.VISTA_LEER_PEZ, igui);
			return igui;
		case Evento.MOSTRAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_LEER_PEZ);
		case Evento.VISTA_BAJA_PEZ:
			igui = new VistaEliminarPez();
			mapa_vistas.put(Evento.VISTA_BAJA_PEZ, igui);
			return igui;
		case Evento.ELIMINAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_BAJA_PEZ);
		case Evento.VISTA_ALTA_PEZ:
			igui = new VistaAltaPez();
			mapa_vistas.put(Evento.VISTA_ALTA_PEZ, igui);
			return igui;
		case Evento.ALTA_PEZ:
			return mapa_vistas.get(Evento.VISTA_ALTA_PEZ);
		case Evento.VISTA_MODIFICAR_PEZ:
			igui = new VistaModificarPez();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_PEZ, igui);
			return igui;
		case Evento.MODIFICAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_PEZ);
		case Evento.VISTA_LEER_TODOS_PEZ:
			igui = new VistaMostrarPeces();
			mapa_vistas.put(Evento.VISTA_LEER_TODOS_PEZ, igui);
			return igui;
		case Evento.VISTA_LEER_PECES_ESPECTACULO:
			igui = new VistaMostrarPecesPorEspectaculo();
			mapa_vistas.put(Evento.VISTA_LEER_PECES_ESPECTACULO, igui);
			return igui;
		case Evento.LEER_PECES_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_LEER_PECES_ESPECTACULO);

		case Evento.LISTAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_LEER_TODOS_PEZ);

		// ESPECTACULO
		case Evento.VISTA_MENU_ESPECTACULO:
			return new VistaMenuEspectaculo();
		case Evento.VISTA_ALTA_ESPECTACULO:
		case Evento.ALTA_ESPECTACULO:
			return new VistaAltaEspectaculo();
		case Evento.VISTA_ELIMINAR_ESPECTACULO:
			igui = new VistaBajaEspectaculo();
			mapa_vistas.put(Evento.VISTA_ELIMINAR_ESPECTACULO, igui);
			return igui;
		case Evento.ELIMINAR_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_ELIMINAR_ESPECTACULO);
		case Evento.VISTA_LEER_ESPECTACULO:
			igui = new VistaLeerEspectaculo();
			mapa_vistas.put(Evento.VISTA_LEER_ESPECTACULO, igui);
			return igui;
		case Evento.MOSTRAR_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_LEER_ESPECTACULO);
		case Evento.VISTA_MODIFICAR_ESPECTACULO:
			igui = new VistaModificarEspectaculo();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_ESPECTACULO, igui);
			return igui;
		case Evento.MODIFICAR_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_ESPECTACULO);
		case Evento.VISTA_MOSTRAR_ESPECTACULO_POR_EMPLEADO:
			igui = new VistaMostrarEspectaculosPorEmpleado();
			mapa_vistas.put(Evento.VISTA_MOSTRAR_ESPECTACULO_POR_EMPLEADO, igui);
			return igui;
		case Evento.MOSTRAR_ESPECTACULO_POR_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_MOSTRAR_ESPECTACULO_POR_EMPLEADO);
		case Evento.VISTA_LISTAR_ESPECTACULOS:
			igui = new VistaLeerTodosEspectaculo();
			mapa_vistas.put(Evento.VISTA_LISTAR_ESPECTACULOS, igui);
			return igui;
		case Evento.LISTAR_ESPECTACULO:
			return mapa_vistas.get(Evento.VISTA_LISTAR_ESPECTACULOS);
		case Evento.VISTA_ASIGNAR_PEZ:
			igui = new VistaAsignarPezEnEspectaculo();
			mapa_vistas.put(Evento.VISTA_ASIGNAR_PEZ, igui);
			return igui;
		case Evento.ASIGNAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_ASIGNAR_PEZ);
		case Evento.VISTA_DESASIGNAR_PEZ:
			igui = new VistaDesasignarPezDeEspectaculo();
			mapa_vistas.put(Evento.VISTA_DESASIGNAR_PEZ, igui);
			return igui;
		case Evento.DESASIGNAR_PEZ:
			return mapa_vistas.get(Evento.VISTA_DESASIGNAR_PEZ);

		//EMPLEADO	
		case Evento.VISTA_MENU_EMPLEADO:
			return new VistaMenuEmpleado();

		//////
		//case Evento.VISTA_LEER_EMPLEADO:
		//	return new VistaLeerEmpleado();

		case Evento.VISTA_LEER_EMPLEADO:
			igui = new VistaLeerEmpleado();
			mapa_vistas.put(Evento.VISTA_LEER_EMPLEADO, igui);
			return igui;
		case Evento.MOSTRAR_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_LEER_EMPLEADO);
		/////

		case Evento.VISTA_MOSTRAR_EMPLEADO_DNI:
			igui = new VistaLeerEmpleadoPorDNI();
			mapa_vistas.put(Evento.MOSTRAR_EMPLEADO_DNI, igui);
			return igui;
		case Evento.MOSTRAR_EMPLEADO_DNI:
			return mapa_vistas.get(Evento.MOSTRAR_EMPLEADO_DNI);

		/////
		case Evento.VISTA_ELIMINAR_EMPLEADO:
			igui = new VistaBajaEmpleado();
			mapa_vistas.put(Evento.VISTA_ELIMINAR_EMPLEADO, igui);
			return igui;
		case Evento.ELIMINAR_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_ELIMINAR_EMPLEADO);

		//////
		/**/ case Evento.ALTA_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_ALTA_EMPLEADO);
		//return new VistaAltaEmpleado();
		case Evento.VISTA_ALTA_EMPLEADO:
			//return new VistaAltaEmpleado();
			igui = new VistaAltaEmpleado();
			mapa_vistas.put(Evento.VISTA_ALTA_EMPLEADO, igui);
			return igui;
		//////

		/**/ case Evento.VISTA_MODIFICAR_EMPLEADO:
			igui = new VistaUpdateEmpleado();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_EMPLEADO, igui);
			return igui;
		case Evento.MODIFICAR_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_EMPLEADO);

		//////
		//case Evento.VISTA_LEER_TODOS_EMPLEADOS:
		//return new VistaLeerTodosEmpleado();
		/**/ case Evento.VISTA_LEER_TODOS_EMPLEADOS:
			igui = new VistaLeerTodosEmpleado();
			mapa_vistas.put(Evento.VISTA_LEER_TODOS_EMPLEADOS, igui);
			return igui;
		case Evento.LISTAR_EMPLEADO:
			return mapa_vistas.get(Evento.VISTA_LEER_TODOS_EMPLEADOS);

			
		// TURNO
		case Evento.VISTA_MENU_TURNO:
			return new VistaMenuTurno();
		case Evento.VISTA_ALTA_TURNO:
		case Evento.ALTA_TURNO:
			return new VistaAddTurno();
		case Evento.MODIFICAR_TURNO:
		case Evento.VISTA_MODIFICAR_TURNO:
			return new VistaUpdateTurno();
		case Evento.VISTA_CALCULAR_NOMINA_TURNO:
		case Evento.CALCULAR_NOMINA_TURNO:
			return new VistaCalcularNomina();
		case Evento.ELIMINAR_TURNO:
		case Evento.VISTA_ELIMINAR_TURNO:
			return new VistaDeleteTurno();
		case Evento.BUSCAR_TURNO:
		case Evento.VISTA_BUSCAR_TURNO:
			return new VistaReadTurno();
		case Evento.LISTAR_TURNOS:
		case Evento.VISTA_LISTAR_TURNOS:
			return new VistaReadAllTurnos();
		case Evento.MOSTRAR_TURNOS_EMPLEADO:
		case Evento.VISTA_MOSTRAR_TURNOS_EMPLEADO:
			return new VistaReadByEmpleado();
			
			
			
			
		//FACTURAJPA
		case Evento.VISTA_MENU_FACTURA_JPA:
			return new VistaMenuFacturaJPA();
		case Evento.VISTA_ABRIR_VENTA_FACTURA_JPA:
			igui = new VistaAbrirVentaFacturaJPA();
			mapa_vistas.put(Evento.VISTA_ABRIR_VENTA_FACTURA_JPA, igui);
			return igui;
		case Evento.BUSCAR_FACTURA_JPA:
			return mapa_vistas.get(Evento.VISTA_BUSCAR_FACTURA_JPA);
		case Evento.VISTA_BUSCAR_FACTURA_JPA:
			igui = new BuscarFactura();
			mapa_vistas.put(Evento.VISTA_BUSCAR_FACTURA_JPA, igui);
			return igui;
		case Evento.BUSCAR_FACTURA_PRODUCTO_JPA:
			return mapa_vistas.get(Evento.VISTA_BUSCAR_FACTURA_PRODUCTO_JPA);
		case Evento.VISTA_BUSCAR_FACTURA_PRODUCTO_JPA:
			igui = new VistaBuscarFacturaProducto();
			mapa_vistas.put(Evento.VISTA_BUSCAR_FACTURA_PRODUCTO_JPA, igui);
			return igui;
		case Evento.DEVOLVER_PRODUCTO:
			return mapa_vistas.get(Evento.VISTA_DEVOLVER_PRODUCTO);
		case Evento.VISTA_DEVOLVER_PRODUCTO:
			igui = new VistaDevolverProducto();
			mapa_vistas.put(Evento.VISTA_DEVOLVER_PRODUCTO, igui);
			return igui;
		case Evento.VISTA_AÑADIR_PRODUCTO_FACTURA_JPA:
			return new VistaAnadirProductoFacturaJPA();
		case Evento.VISTA_ELIMINAR_PRODUCTO_FACTURA_JPA:
			return new VistaEliminarProductoFacturaJPA();
		case Evento.VISTA_CERRAR_VENTA_FACTURA_JPA:
			return new VistaConfirmarVentaFacturaJPA();
		case Evento.ALTA_FACTURA_JPA:
			return new VistaAbrirVentaFacturaJPA();
		case Evento.VISTA_MODIFICAR_FACTURA_JPA:
			igui = new VistaModificarFacturaJPA();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_FACTURA_JPA, igui);
			return igui;
		case Evento.MODIFICAR_FACTURA_JPA:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_FACTURA_JPA);
		case Evento.VISTA_MOSTRAR_FACTURA_COMPLETA_JPA:
			igui = new VistaMostrarFacturaCompleta();
			mapa_vistas.put(Evento.VISTA_MOSTRAR_FACTURA_COMPLETA_JPA, igui);
			return igui;

		case Evento.MOSTRAR_FACTURA_COMPLETA_JPA:
			return mapa_vistas.get(Evento.VISTA_MOSTRAR_FACTURA_COMPLETA_JPA);
		case Evento.VISTA_LISTAR_FACTURAS_JPA:
			igui = new VistaMostrarFacturasJPA();
			mapa_vistas.put(Evento.VISTA_LISTAR_FACTURAS_JPA, igui);
			return igui;
		case Evento.LISTAR_FACTURA_JPA:
			return mapa_vistas.get(Evento.VISTA_LISTAR_FACTURAS_JPA);
		case Evento.VOLVER_MENU_ABRIR_VENTA:
			return mapa_vistas.get(Evento.VISTA_ABRIR_VENTA_FACTURA_JPA);
		case Evento.VISTA_ELIMINAR_FACTURA_JPA:
			igui = new VistaBajaFacturaJPA();
			mapa_vistas.put(Evento.VISTA_ELIMINAR_FACTURA_JPA, igui);
			return igui;
		case Evento.ELIMINAR_FACTURA_JPA:
			return mapa_vistas.get(Evento.VISTA_ELIMINAR_FACTURA_JPA);
			
			
			
		//EMPLEADOJPA
		
		//**** 1
		case Evento.VISTA_MENU_EMPLEADO_JPA:
			return new VistaMenuEmpleadoJPA();
		//**** 2
		case Evento.ALTA_EMPLEADO_JPA:
			return mapa_vistas.get(Evento.VISTA_ALTA_EMPLEADO_JPA);
		case Evento.VISTA_ALTA_EMPLEADO_JPA:
			igui = new VistaAddEmpleado();
			mapa_vistas.put(Evento.VISTA_ALTA_EMPLEADO_JPA, igui);
			return igui;
		//**** 3
		case Evento.VISTA_BUSCAR_EMPLEADO_JPA:
			igui = new VistaReadEmpleado();
			mapa_vistas.put(Evento.VISTA_BUSCAR_EMPLEADO_JPA, igui);
			return igui;
		case Evento.BUSCAR_EMPLEADO_JPA:
			return mapa_vistas.get(Evento.VISTA_BUSCAR_EMPLEADO_JPA);
		//**** 4
		case Evento.VISTA_VINCULAR_TURNO:
			igui = new VistaVincularTurno();
			mapa_vistas.put(Evento.VISTA_VINCULAR_TURNO, igui);
			return igui;
		case Evento.VINCULAR_TURNO:
			return mapa_vistas.get(Evento.VISTA_VINCULAR_TURNO);
		//**** 5
		case Evento.VISTA_ELIMINAR_EMPLEADO_JPA:
			igui = new VistaDeleteEmpleado();
			mapa_vistas.put(Evento.VISTA_ELIMINAR_EMPLEADO_JPA, igui);
			return igui;
		case Evento.ELIMINAR_EMPLEADO_JPA:
			return mapa_vistas.get(Evento.VISTA_ELIMINAR_EMPLEADO_JPA);
		//**** 6
		case Evento.VISTA_MOSTRAR_EMPLEADOS_TURNO:
			igui =  new VistaReadEmpleadoByTurno();
			mapa_vistas.put(Evento.VISTA_MOSTRAR_EMPLEADOS_TURNO, igui);
			return igui;
		case Evento.MOSTRAR_EMPLEADOS_TURNO:
			return mapa_vistas.get(Evento.VISTA_MOSTRAR_EMPLEADOS_TURNO);
		//**** 6
		case Evento.VISTA_DESVINCULAR_TURNO:
			igui = new VistaDesvincularTurno();
			mapa_vistas.put(Evento.VISTA_DESVINCULAR_TURNO, igui);
			return igui;
		case Evento.DESVINCULAR_TURNO:
			return mapa_vistas.get(Evento.VISTA_DESVINCULAR_TURNO);
		//**** 7
		case Evento.VISTA_LISTAR_EMPLEADO_JPA:
			igui = new VistaReadAllEmpleado();
			mapa_vistas.put(Evento.VISTA_LISTAR_EMPLEADO_JPA, igui);
			return igui;
		case Evento.LISTAR_EMPLEADO_JPA:
			return mapa_vistas.get(Evento.VISTA_LISTAR_EMPLEADO_JPA);
		//**** 8
		case Evento.VISTA_MODIFICAR_EMPLEADO_JPA:
			igui =  new VistaUpdateEmpleadoJPA();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_EMPLEADO_JPA, igui);
			return igui;
		case Evento.MODIFICAR_EMPLEADO_JPA:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_EMPLEADO_JPA);
		//**** 9
		case Evento.VISTA_CALCULAR_NOMINA:
			igui = new VistaCalcularNominaEmpleado();
			mapa_vistas.put(Evento.VISTA_CALCULAR_NOMINA, igui);
			return igui;
		case Evento.CALCULAR_NOMINA:
			return mapa_vistas.get(Evento.VISTA_CALCULAR_NOMINA);
		//************************************************************	

		
		
		//Producto JPA
		
		case Evento.VISTA_MENU_PRODUCTO:			
			return new VistaMenuProducto();
		case Evento.VISTA_ALTA_PRODUCTO:
		case Evento.ALTA_PRODUCTO:
			return new VistaAddProducto();
		case Evento.VISTA_ELIMINAR_PRODUCTO:
			igui=new VistaDeleteProducto();
			mapa_vistas.put(Evento.VISTA_ELIMINAR_PRODUCTO, igui);
			return igui;
		case Evento.ELIMINAR_PRODUCTO:
			return mapa_vistas.get(Evento.VISTA_ELIMINAR_PRODUCTO);
		case Evento.VISTA_LISTAR_PRODUCTO:
			igui=new VistaReadAllProducto();
			mapa_vistas.put(Evento.VISTA_LISTAR_PRODUCTO, igui);
			return igui;
		case Evento.LISTAR_PRODUCTO:
			return mapa_vistas.get(Evento.VISTA_LISTAR_PRODUCTO);
		case Evento.VISTA_BUSCAR_PRODUCTO:
			igui=new VistaReadProducto();
			mapa_vistas.put(Evento.VISTA_BUSCAR_PRODUCTO, igui);
			return igui;
		case Evento.BUSCAR_PRODUCTO:
			return mapa_vistas.get(Evento.VISTA_BUSCAR_PRODUCTO);
		case Evento.VISTA_MODIFICAR_PRODUCTO:
			igui=new VistaUpdateProducto();
			mapa_vistas.put(Evento.VISTA_MODIFICAR_PRODUCTO, igui);
			return igui;
		case Evento.MODIFICAR_PRODUCTO:
			return mapa_vistas.get(Evento.VISTA_MODIFICAR_PRODUCTO);
		}

		return null;
		
	}
}