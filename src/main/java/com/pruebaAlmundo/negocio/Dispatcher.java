package com.pruebaAlmundo.negocio;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pruebaAlmundo.constantes.EstadoEmpleado;
import com.pruebaAlmundo.constantes.TipoEmpleado;
import com.pruebaAlmundo.entidades.Empleado;
import com.pruebaAlmundo.entidades.Llamada;

/**
 * Clase Dispatcher encargada de recibir las llamadas y asignarlas a los
 * empleados disponibles.
 * 
 * @version 1.0
 * @author Sergio Forero
 */
public class Dispatcher {

	/** Logger **/
	private Logger logger = Logger.getLogger(this.getClass().toString());

	/** variable manipulada unicamente en la clase Dispatcher **/
	protected int llamadas_en_curso = 0;

	/** Lista de Empleados-operadores-Supervisores-Directores **/
	List<Empleado> colaDeEmpleados = new LinkedList<>();
	Queue<Llamada> llamadasEnEspera = new LinkedList<>();

	/**
	 * Metodo principal de la clase, encargado de recibir las llamadas que
	 * entran en el call center.
	 * 
	 * @param llamadaEntrante
	 */
	public void dispatchCall(Llamada llamadaEntrante) {
		if (verificarCantidadLlamadasEnCurso()) {
			Empleado empDisp = encontrarEmpleadoDisponible();
			if (empDisp == null) {
				llamadasEnEspera.offer(llamadaEntrante);
				logger.log(Level.INFO, "No hay empleados disponibles, llamada # "
						+ llamadaEntrante.getNumLlamadaEntrante() + " encolada");
			} else {
				contestarLlamada(empDisp, llamadaEntrante);
			}
		} else {
			llamadasEnEspera.offer(llamadaEntrante);
			logger.log(Level.INFO, "Se Alcanzo el Maximo de llamadas disponibles, llamada # "
					+ llamadaEntrante.getNumLlamadaEntrante() + " encolada");
		}
	}

	/**
	 * Metodo encargado de encontrar el empleado disponible se prioriza por
	 * operador luego supervisor y por ultimo director
	 * 
	 * @return Empleado empleado encontrado
	 */
	private Empleado encontrarEmpleadoDisponible() {
		Empleado asignar = encontrarEmpleadoDisponible(TipoEmpleado.OPERADOR);
		if (asignar == null) {
			asignar = encontrarEmpleadoDisponible(TipoEmpleado.SUPERVISOR);
			if (asignar == null) {
				asignar = encontrarEmpleadoDisponible(TipoEmpleado.DIRECTOR);
			}
		}
		return asignar;
	}

	/**
	 * Metodo que encuentra un empleado dispnible segun el tipo de empleado
	 * recibido
	 * 
	 * @param TipoEmpleado
	 * @return Empleado empleado encontrado
	 */
	private Empleado encontrarEmpleadoDisponible(String tipoEmpleado) {
		for (Empleado empleado : colaDeEmpleados) {
			if (empleado.isEstado() == EstadoEmpleado.DISPONIBLE && empleado.getTipo().equals(tipoEmpleado)) {
				return empleado;
			}
		}
		return null;
	}

	/**
	 * retorna True si las llamadas en curso son menor a 10 de lo contrario
	 * retorna False
	 * 
	 * @return boolean
	 */
	private boolean verificarCantidadLlamadasEnCurso() {
		return llamadas_en_curso < 10;
	}

	/**
	 * Metodo encargado de asignarle la llamada al empleado se genera un hilo
	 * por cada llamada contestada
	 * 
	 * @param empleado
	 *            asignado
	 * @param llamada
	 *            recibida
	 */
	private void contestarLlamada(Empleado emp, Llamada llamada) {
		llamadas_en_curso++;
		emp.setEstado(EstadoEmpleado.OCUPADO);
		llamada.asignarEmpleado(emp);
		llamada.guardarEstadoDispatcher(this);
		(new Thread(llamada)).start();
	}

	/**
	 * Metodo encargado de verificar si se encuentran llamadas en espera Si se
	 * encuentran se vuelven a enviar al metodo dispatchCall
	 */
	public void verificarLlamadasEnEspera() {
		if (!llamadasEnEspera.isEmpty()) {
			this.dispatchCall(llamadasEnEspera.poll());
		}
	}

	/**
	 * Metodo encargado de restar las llamadas finalizadas al contador de
	 * llamadas en curso
	 */
	public void colgarLlamada() {
		llamadas_en_curso--;
	}

	/**
	 * Metodo que se encarga de iniciar la lista de empleados del call center
	 * 
	 * @param empleados
	 */
	public void iniciarListaEmpleados(List<Empleado> empleados) {
		colaDeEmpleados.addAll(empleados);
	}

	public Queue<Llamada> getLlamadasEnEspera() {
		return llamadasEnEspera;
	}

	public int getLlamadas_en_curso() {
		return llamadas_en_curso;
	}	

}
