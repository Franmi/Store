package presentacion.Controlador;

public class Evento {

	public static final int MENU_APLICACION = 1;
	
	public static final int MENU_ACUARIO = 2;
	public static final int MENU_TIENDA = 3;

	// Evento Especie [100-150)
	public static final int ALTA_ESPECIE = 100;
	public static final int ELIMINAR_ESPECIE = 101;
	public static final int MOSTRAR_ESPECIE = 102;
	public static final int MODIFICAR_ESPECIE = 103;
	public static final int LISTAR_ESPECIES = 104;
	public static final int RES_ALTA_ESPECIE_OK = 105;
	public static final int RES_ALTA_ESPECIE_KO = 106;
	public static final int RES_ELIMINAR_ESPECIE_OK = 107;
	public static final int RES_ELIMINAR_ESPECIE_KO = 108;
	public static final int RES_MOSTRAR_ESPECIE_OK = 109;
	public static final int RES_MOSTRAR_ESPECIE_KO = 110;
	public static final int RES_MODIFICAR_ESPECIE_OK = 111;
	public static final int RES_MODIFICAR_ESPECIE_KO = 112;

	// Evento Factura [150-200)
	public static final int ALTA_FACTURA = 150;
	public static final int ELIMINAR_FACTURA = 151;
	public static final int MOSTRAR_FACTURA = 152;
	public static final int MODIFICAR_FACTURA = 153;
	public static final int DEVOLVER_ESPECTACULO_FACTURA = 154;
	public static final int LISTAR_FACTURAS = 155;
	public static final int RES_ALTA_FACTURA_OK = 156;
	public static final int RES_ALTA_FACTURA_KO = 157;
	public static final int RES_ELIMINAR_FACTURA_OK = 158;
	public static final int RES_ELIMINAR_FACTURA_KO = 159;
	public static final int RES_MOSTRAR_FACTURA_OK = 160;
	public static final int RES_MOSTRAR_FACTURA_KO = 161;
	public static final int RES_MODIFICAR_FACTURA_OK = 162;
	public static final int RES_MODIFICAR_FACTURA_KO = 163;
	public static final int RES_DEVOLVER_ESPECTACULO_FACTURA_OK = 164;
	public static final int RES_DEVOLVER_ESPECTACULO_FACTURA_KO = 165;
	public static final int RES_LISTAR_FACTURAS_OK = 166;
	public static final int RES_LISTAR_FACTURAS_KO = 167;
	public static final int VISTA_ABRIR_VENTA_FACTURA = 168;
	public static final int VISTA_AÑADIR_ESPECTACULO_FACTURA = 169;
	public static final int VISTA_ELIMINAR_ESPECTACULO_FACTURA = 170;
	public static final int VISTA_CERRAR_VENTA_FACTURA = 171;
	public static final int VISTA_BUSCAR_FACTURA = 172;
	public static final int VISTA_MODIFICAR_FACTURA = 173;
	public static final int VISTA_ELIMINAR_FACTURA = 174;
	public static final int VISTA_DEVOLVER_ESPECTACULO_FACTURA = 175;
	public static final int VISTA_LISTAR_FACTURAS = 176;
	public static final int VISTA_MENU_FACTURA = 199;

	// Evento Pez [200-250) 
	public static final int ALTA_PEZ = 200;
	public static final int ELIMINAR_PEZ = 201;
	public static final int MOSTRAR_PEZ = 202;
	public static final int MODIFICAR_PEZ = 203;
	public static final int LISTAR_PEZ = 204;
	public static final int RES_ALTA_PEZ_OK = 205;
	public static final int RES_ALTA_PEZ_KO = 206;
	public static final int RES_ELIMINAR_PEZ_OK = 207;
	public static final int RES_ELIMINAR_PEZ_KO = 208;
	public static final int RES_MOSTRAR_PEZ_OK = 209;
	public static final int RES_MOSTRAR_PEZ_KO = 210;
	public static final int RES_MODIFICAR_PEZ_OK = 211;
	public static final int RES_MODIFICAR_PEZ_KO = 212;
	public static final int VISTA_ALTA_PEZ = 213;
	public static final int VISTA_BAJA_PEZ = 214;
	public static final int VISTA_MODIFICAR_PEZ = 215;
	public static final int VISTA_LEER_PEZ = 216;
	public static final int VISTA_LEER_TODOS_PEZ = 217;
	public static final int VISTA_LEER_PECES_ESPECTACULO = 218;
	public static final int LEER_PECES_ESPECTACULO = 219;
	public static final int RES_MOSTRAR_PECES_OK = 220;
	public static final int RES_MOSTRAR_PECES_KO = 221;
	public static final int RES_MOSTRAR_PECES_ESPECTACULO_OK = 220;
	public static final int RES_MOSTRAR_PECES_ESPECTACULO_KO = 221;
	public static final int VISTA_MENU_PEZ = 249;

	// Evento Empleado [250-300)
	public static final int ALTA_EMPLEADO = 250;
	public static final int ELIMINAR_EMPLEADO = 251;
	public static final int MOSTRAR_EMPLEADO = 252;
	public static final int MODIFICAR_EMPLEADO = 253;
	public static final int LISTAR_EMPLEADO = 254;
	public static final int RES_ALTA_EMPLEADO_OK = 255;
	public static final int RES_ALTA_EMPLEADO_KO = 256;
	public static final int RES_ELIMINAR_EMPLEADO_OK = 257;
	public static final int RES_ELIMINAR_EMPLEADO_KO = 258;
	public static final int RES_MOSTRAR_EMPLEADO_OK = 259;
	public static final int RES_MOSTRAR_EMPLEADO_KO = 260;
	public static final int RES_MODIFICAR_EMPLEADO_OK = 261;
	public static final int RES_MODIFICAR_EMPLEADO_KO = 262;
	public static final int RES_LISTAR_EMPLEADOS_OK = 263;
	public static final int RES_LISTAR_EMPLEADOS_KO = 264;
	public static final int VISTA_ALTA_EMPLEADO = 265;
	public static final int VISTA_ELIMINAR_EMPLEADO = 266;
	public static final int VISTA_MODIFICAR_EMPLEADO = 267;
	public static final int VISTA_LEER_EMPLEADO = 268;
	public static final int VISTA_LEER_TODOS_EMPLEADOS = 269;
	public static final int MOSTRAR_EMPLEADO_DNI = 270;
	public static final int VISTA_MOSTRAR_EMPLEADO_DNI = 271;
	public static final int RES_MOSTRAR_EMPLEADO_DNI_OK = 272;
	public static final int RES_MOSTRAR_EMPLEADO_DNI_KO = 273;
	public static final int VISTA_MENU_EMPLEADO = 299;

	// Evento Cliente [300-350)
	public static final int ALTA_CLIENTE = 305;
	public static final int ELIMINAR_CLIENTE = 306;
	public static final int MOSTRAR_CLIENTE = 307;
	public static final int MODIFICAR_CLIENTE = 308;
	public static final int LISTAR_CLIENTE = 309;
	public static final int RES_ALTA_CLIENTE_OK = 310;
	public static final int RES_ALTA_CLIENTE_KO = 311;
	public static final int RES_ELIMINAR_CLIENTE_OK = 312;
	public static final int RES_ELIMINAR_CLIENTE_KO = 313;
	public static final int RES_MOSTRAR_CLIENTE_OK = 314;
	public static final int RES_MOSTRAR_CLIENTE_KO = 315;
	public static final int RES_MODIFICAR_CLIENTE_OK = 316;
	public static final int RES_MODIFICAR_CLIENTE_KO = 317;
	public static final int VISTA_MENU_CLIENTE = 318;
	public static final int VISTA_ALTA_CLIENTE = 319;
	public static final int VISTA_LEER_CLIENTE = 320;
	public static final int VISTA_BORRAR_CLIENTE = 321;
	public static final int VISTA_LEER_TODOS_CLIENTE = 322;
	public static final int VISTA_UPDATE_CLIENTE = 323;
	public static final int RES_MOSTRAR_TODOS_CLIENTE_OK = 324;
	public static final int RES_MOSTRAR_TODOS_CLIENTE_KO = 325;

	// Evento Espectaculo [350-400)
	public static final int ALTA_ESPECTACULO = 350;
	public static final int ELIMINAR_ESPECTACULO = 351;
	public static final int MOSTRAR_ESPECTACULO = 352;
	public static final int MODIFICAR_ESPECTACULO = 353;
	public static final int LISTAR_ESPECTACULO = 354;
	public static final int RES_ALTA_ESPECTACULO_OK = 355;
	public static final int RES_ALTA_ESPECTACULO_KO = 356;
	public static final int RES_ELIMINAR_ESPECTACULO_OK = 357;
	public static final int RES_ELIMINAR_ESPECTACULO_KO = 358;
	public static final int RES_MOSTRAR_ESPECTACULO_OK = 359;
	public static final int RES_MOSTRAR_ESPECTACULO_KO = 360;
	public static final int RES_LISTAR_ESPECTACULOS_OK = 361;
	public static final int RES_LISTAR_ESPECTACULOS_KO = 362;
	public static final int RES_MODIFICAR_ESPECTACULO_OK = 363;
	public static final int RES_MODIFICAR_ESPECTACULO_KO = 364;
	public static final int RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_OK = 365;
	public static final int RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_KO = 366;
	public static final int VISTA_ALTA_ESPECTACULO = 367;
	public static final int VISTA_BAJA_ESPECTACULO = 368;
	public static final int VISTA_LEER_ESPECTACULO = 369;
	public static final int VISTA_ELIMINAR_ESPECTACULO = 370;
	public static final int VISTA_MODIFICAR_ESPECTACULO = 371;
	public static final int VISTA_MOSTRAR_ESPECTACULO_POR_EMPLEADO = 373;
	public static final int VISTA_LISTAR_ESPECTACULOS = 374;
	public static final int VISTA_MENU_ESPECTACULO = 399;
	public static final int VISTA_ASIGNAR_PEZ = 398;
	public static final int VISTA_DESASIGNAR_PEZ = 397;
	public static final int ASIGNAR_PEZ = 396;
	public static final int DESASIGNAR_PEZ = 395;
	public static final int RES_VINCULAR_PEZ_OK = 396;
	public static final int RES_VINCULAR_PEZ_KO = 397;
	public static final int RES_DESVINCULAR_PEZ_OK = 398;
	public static final int RES_DESVICULAR_PEZ_KO = 399;
	public static final int MOSTRAR_ESPECTACULO_POR_EMPLEADO = 400;

	// Evento Queries [400-450)
	public static final int QUERY_ENTRADAS = 401;
	public static final int VISTA_QUERY_ENTRADAS = 402;
	public static final int RES_QUERY_ENTRADAS_OK = 403;
	public static final int RES_QUERY_ENTRADAS_KO = 404;
	public static final int QUERY_ESPECTACULO = 410;
	public static final int VISTA_QUERY_ESPECTACULO = 411;
	public static final int RES_QUERY_ESPECTACULO_OK = 412;
	public static final int RES_QUERY_ESPECTACULO_KO = 413;

	// Evento Turno [450-500)
	public static final int ALTA_TURNO = 450;
	public static final int BUSCAR_TURNO = 451;
	public static final int ELIMINAR_TURNO = 452;
	public static final int MODIFICAR_TURNO = 453;
	public static final int LISTAR_TURNOS = 454;
	public static final int MOSTRAR_TURNOS_EMPLEADO = 455;
	public static final int CALCULAR_NOMINA_TURNO = 456;
	public static final int RES_ALTA_TURNO_OK = 457;
	public static final int RES_ALTA_TURNO_KO = 458;
	public static final int RES_BUSCAR_TURNO_OK = 459;
	public static final int RES_BUSCAR_TURNO_KO = 460;
	public static final int RES_ELIMINAR_TURNO_OK = 461;
	public static final int RES_ELIMINAR_TURNO_KO = 462;
	public static final int RES_MODIFICAR_TURNO_OK = 463;
	public static final int RES_MODIFICAR_TURNO_KO = 464;
	public static final int RES_LISTAR_TURNOS_OK = 465;
	public static final int RES_LISTAR_TURNOS_KO = 466;
	public static final int RES_MOSTRAR_TURNOS_EMPLEADO_OK = 467;
	public static final int RES_MOSTRAR_TURNOS_EMPLEADO_KO = 468;
	public static final int RES_CALCULAR_NOMINA_TURNO_OK = 469;
	public static final int RES_CALCULAR_NOMINA_TURNO_KO = 470;
	public static final int VISTA_ALTA_TURNO = 471;
	public static final int VISTA_BUSCAR_TURNO = 472;
	public static final int VISTA_ELIMINAR_TURNO = 473;
	public static final int VISTA_MODIFICAR_TURNO = 474;
	public static final int VISTA_LISTAR_TURNOS = 475;
	public static final int VISTA_MOSTRAR_TURNOS_EMPLEADO = 476;
	public static final int VISTA_CALCULAR_NOMINA_TURNO = 477;
	public static final int VISTA_MENU_TURNO = 478;
	
	
	//Evento FacturaJPA [500-550)
	public static final int ALTA_FACTURA_JPA = 500;
	public static final int BUSCAR_FACTURA_JPA = 501;
	public static final int ELIMINAR_FACTURA_JPA = 502;
	public static final int MODIFICAR_FACTURA_JPA = 503;
	public static final int LISTAR_FACTURA_JPA = 504;
	public static final int CALCULAR_NOMINA_FACTURA_JPA = 505;
	public static final int VISTA_ABRIR_VENTA_FACTURA_JPA = 506;
	public static final int VISTA_MENU_FACTURA_JPA = 507;
	public static final int VISTA_MODIFICAR_FACTURA_JPA = 508;
	public static final int VISTA_BUSCAR_FACTURA_JPA = 510;
	public static final int RES_BUSCAR_FACTURA_JPA_OK = 511;
	public static final int RES_BUSCAR_FACTURA_JPA_KO = 512;
	public static final int BUSCAR_FACTURA_PRODUCTO_JPA = 513;
	public static final int VISTA_BUSCAR_FACTURA_PRODUCTO_JPA = 514;
	public static final int RES_BUSCAR_FACTURA_PRODUCTO_JPA_OK = 515;
	public static final int RES_BUSCAR_FACTURA_PRODUCTO_JPA_KO = 516;
	public static final int DEVOLVER_PRODUCTO = 517;
	public static final int VISTA_DEVOLVER_PRODUCTO = 518;
	public static final int RES_DEVOLVER_PRODUCTO_OK = 519;
	public static final int RES_DEVOLVER_PRODUCTO_KO = 520;
	public static final int VISTA_AÑADIR_PRODUCTO_FACTURA_JPA = 521;
	public static final int VISTA_ELIMINAR_PRODUCTO_FACTURA_JPA = 522;
	public static final int VISTA_CERRAR_VENTA_FACTURA_JPA = 523;
	public static final int RES_MODIFICAR_FACTURA_JPA_OK = 524;
	public static final int RES_MODIFICAR_FACTURA_JPA_KO = 525;
	public static final int RES_ALTA_FACTURA_JPA_OK = 526;
	public static final int RES_ALTA_FACTURA_JPA_KO = 527;
	public static final int MOSTRAR_FACTURA_COMPLETA_JPA= 528;
	public static final int RES_MOSTRAR_FACTURA_COMPLETA_JPA_OK= 529;
	public static final int RES_MOSTRAR_FACTURA_COMPLETA_JPA_KO= 530;
	public static final int VISTA_MOSTRAR_FACTURA_COMPLETA_JPA= 531;
	public static final int VISTA_LISTAR_FACTURAS_JPA= 532;
	public static final int RES_LISTAR_FACTURAS_JPA_OK= 533;
	public static final int RES_LISTAR_FACTURAS_JPA_KO= 534;
	public static final int VOLVER_MENU_ABRIR_VENTA= 535;
	public static final int RES_ELIMINAR_FACTURA_JPA_OK= 536;
	public static final int RES_ELIMINAR_FACTURA_JPA_KO= 537;
	public static final int VISTA_ELIMINAR_FACTURA_JPA= 538;
	

	// Evento Producto [550 - 560)
	public static final int ALTA_PRODUCTO = 550;
	public static final int BUSCAR_PRODUCTO = 551;
	public static final int ELIMINAR_PRODUCTO = 552;
	public static final int MODIFICAR_PRODUCTO = 553;
	public static final int LISTAR_PRODUCTO = 554;
	public static final int RES_ALTA_PRODUCTO_OK = 555;
	public static final int RES_ALTA_PRODUCTO_KO = 556;
	public static final int RES_BUSCAR_PRODUCTO_OK = 557;
	public static final int RES_BUSCAR_PRODUCTO_KO = 558;
	public static final int RES_ELIMINAR_PRODUCTO_OK = 559;
	public static final int RES_ELIMINAR_PRODUCTO_KO = 560;
	public static final int RES_MODIFICAR_PRODUCTO_OK = 561;
	public static final int RES_MODIFICAR_PRODUCTO_KO= 562;
	public static final int RES_LISTAR_PRODUCTO_OK = 563;
	public static final int RES_LISTAR_PRODUCTO_KO = 564;
	public static final int VISTA_ALTA_PRODUCTO = 565;
	public static final int VISTA_BUSCAR_PRODUCTO = 566;
	public static final int VISTA_ELIMINAR_PRODUCTO = 567;
	public static final int VISTA_MODIFICAR_PRODUCTO = 568;
	public static final int VISTA_LISTAR_PRODUCTO = 569;
	public static final int VISTA_MENU_PRODUCTO = 570;
	
	
	// Evento EmpleadoJPA [600 - 650)
	public static final int ALTA_EMPLEADO_JPA = 600;
	public static final int BUSCAR_EMPLEADO_JPA = 601;
	public static final int ELIMINAR_EMPLEADO_JPA = 602;
	public static final int MODIFICAR_EMPLEADO_JPA = 603;
	public static final int LISTAR_EMPLEADO_JPA = 604;
	public static final int VINCULAR_TURNO = 605;
	public static final int DESVINCULAR_TURNO = 635;
	public static final int MOSTRAR_EMPLEADOS_TURNO = 606;
	public static final int CALCULAR_NOMINA = 638;
	public static final int RES_ALTA_EMPLEADO_JPA_OK = 607;
	public static final int RES_ALTA_EMPLEADO_JPA_KO = 608;
	public static final int RES_BUSCAR_EMPLEADO_JPA_OK = 610;
	public static final int RES_BUSCAR_EMPLEADO_JPA_KO = 611;
	public static final int RES_ELIMINAR_EMPLEADO_JPA_OK = 612;
	public static final int RES_ELIMINAR_EMPLEADO_JPA_KO = 613;
	public static final int RES_MODIFICAR_EMPLEADO_JPA_OK = 614;
	public static final int RES_MODIFICAR_EMPLEADO_JPA_KO = 615;
	public static final int RES_LISTAR_EMPLEADO_JPA_OK = 616;
	public static final int RES_LISTAR_EMPLEADO_JPA_KO = 617;
	public static final int RES_VINCULAR_TURNO_OK = 618;
	public static final int RES_VINCULAR_TURNO_KO = 619;
	public static final int RES_DESVINCULAR_TURNO_OK = 620;
	public static final int RES_DESVINCULAR_TURNO_KO = 621;
	public static final int RES_MOSTRAR_EMPLEADOS_TURNO_OK = 622;
	public static final int RES_MOSTRAR_EMPLEADOS_TURNO_KO = 623;
	public static final int RES_CALCULAR_NOMINA_OK = 633;
	public static final int RES_CALCULAR_NOMINA_KO = 634;
	public static final int VISTA_ALTA_EMPLEADO_JPA = 624;
	public static final int VISTA_BUSCAR_EMPLEADO_JPA = 625;
	public static final int VISTA_ELIMINAR_EMPLEADO_JPA = 626;
	public static final int VISTA_MODIFICAR_EMPLEADO_JPA = 627;
	public static final int VISTA_LISTAR_EMPLEADO_JPA = 628;
	public static final int VISTA_MOSTRAR_EMPLEADOS_TURNO = 629;
	public static final int VISTA_VINCULAR_TURNO = 630;
	public static final int VISTA_DESVINCULAR_TURNO = 631;
	public static final int VISTA_CALCULAR_NOMINA = 636;
	public static final int VISTA_MENU_EMPLEADO_JPA = 632;
	

}