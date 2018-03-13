package com.pruebaAlmundo.entidades;

import java.util.Random;

import com.pruebaAlmundo.constantes.EstadoEmpleado;
import com.pruebaAlmundo.constantes.EstadoLlamada;
import com.pruebaAlmundo.negocio.Dispatcher;

/**
 * @author Sergio Forero
 *
 */
public class Llamada implements Runnable {

	public static final int MAX_DURACION_LLAMADA = 10;
	public static final int MIN_DURACION_LLAMADA = 5;
	public static final int MAXIMAS_LLAMADAS = 10;

	private String numLlamadaEntrante;
	private String estadoLlamada;	
	private Empleado empleadoAtiende;
	private Dispatcher dispatchercache;

	public Llamada(String numLlamadaEntrante, String estadoLlamada) {
		super();
		this.numLlamadaEntrante = numLlamadaEntrante;
		this.estadoLlamada = estadoLlamada;
	}

	public String getNumLlamadaEntrante() {
		return numLlamadaEntrante;
	}

	public void setNumLlamadaEntrante(String numLlamadaEntrante) {
		this.numLlamadaEntrante = numLlamadaEntrante;
	}

	public String getEstadoLlamada() {
		return estadoLlamada;
	}

	public void setEstadoLlamada(String estadoLlamada) {
		this.estadoLlamada = estadoLlamada;
	}
	
	public void asignarEmpleado(Empleado emp){
		empleadoAtiende = emp;
	}
	
	public void guardarEstadoDispatcher(Dispatcher dis){
		dispatchercache = dis;
	}
	
	@Override
	public void run() {
		this.setEstadoLlamada(EstadoLlamada.EN_CURSO);
		System.out.println("Llamada "+ this.numLlamadaEntrante + " iniciada por "+this.empleadoAtiende.getNombre());
		Random random = new Random();
		int tiempo = (random.nextInt(5) + 5) * 1000;
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException ex) {
			System.out.println("FLAG DE INTERRUPCIÓN VALE " + Thread.interrupted());
		}
		System.out.println("FIN Llamada "+ this.numLlamadaEntrante + " de "+this.empleadoAtiende.getNombre() +" Tiempo:"+ tiempo);
		this.empleadoAtiende.setEstado(EstadoEmpleado.DISPONIBLE);
		this.setEstadoLlamada(EstadoLlamada.FINALIZADA);
		dispatchercache.colgarLlamada();
		dispatchercache.verificarLlamadasEnEspera();
	}

}
