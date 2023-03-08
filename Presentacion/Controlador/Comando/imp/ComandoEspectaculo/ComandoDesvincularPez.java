package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import negocio.Espectaculo.TParticipa;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDesvincularPez implements Comando {

	@Override
	public Contexto ejecutar(Object datos) {
		TParticipa p= (TParticipa) datos;
		int result=FactoriaNegocio.getInstance().createSAEspectaculo().eliminarPez(p);
		Contexto contexto;
		if(result>0){
			contexto=new Contexto(Evento.RES_DESVINCULAR_PEZ_OK,result);
		}else{
			contexto=new Contexto(Evento.RES_DESVICULAR_PEZ_KO,result);
		}
		
		return contexto;
	}

}
