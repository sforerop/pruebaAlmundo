/**
 * 
 */
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
 * @author Usuario
 *
 */
public class Dispatcher {

	private Logger logger = Logger.getLogger(Dispatcher.class.getName());
	protected int LLAMADAS_EN_CURSO = 0;

	List<Empleado> colaDeEmpleados = new LinkedList<>();
	Queue<Llamada> llamadasEnEspera = new LinkedList<>();

	public void dispatchCall(Llamada llamadaEntrante) {
		if (verificarCantidadLlamadasEnCurso()) {
			Empleado empDisp = encontrarEmpleadoDisponible();
			if (empDisp == null) {
				llamadasEnEspera.offer(llamadaEntrante);
				System.out.println("No hay empleados disponibles, llamada # " + llamadaEntrante.getNumLlamadaEntrante()
						+ " encolada");
			} else {
				contestarLlamada(empDisp, llamadaEntrante);
			}
		} else {
			llamadasEnEspera.offer(llamadaEntrante);
			System.out.println("Maximo de llamadas disponibles");
			// logger.log(Level.INFO, "Maximo de llamadas disponibles");
		}

	}

	private Empleado encontrarEmpleadoDisponible() {
		Empleado asignar = encontrarOperadorDisponible();
		if (asignar == null) {
			asignar = encontrarSupervisorDisponible();
			if (asignar == null) {
				asignar = encontrarDirectorDisponible();
			}
		}
		return asignar;
	}

	private Empleado encontrarOperadorDisponible() {
		for (Empleado empleado : colaDeEmpleados) {
			if (empleado.isEstado() == EstadoEmpleado.DISPONIBLE && empleado.getTipo().equals(TipoEmpleado.OPERADOR)) {
				return empleado;
			}
		}
		return null;
	}

	private Empleado encontrarSupervisorDisponible() {
		for (Empleado empleado : colaDeEmpleados) {
			if (empleado.isEstado() == EstadoEmpleado.DISPONIBLE
					&& empleado.getTipo().equals(TipoEmpleado.SUPERVISOR)) {
				return empleado;
			}
		}
		return null;
	}

	private Empleado encontrarDirectorDisponible() {
		for (Empleado empleado : colaDeEmpleados) {
			if (empleado.isEstado() == EstadoEmpleado.DISPONIBLE && empleado.getTipo().equals(TipoEmpleado.DIRECTOR)) {
				return empleado;
			}
		}
		return null;
	}

	private boolean verificarCantidadLlamadasEnCurso() {
		return LLAMADAS_EN_CURSO < 10;
	}

	private void contestarLlamada(Empleado emp, Llamada llamada) {
		LLAMADAS_EN_CURSO++;
		emp.setEstado(EstadoEmpleado.OCUPADO);
		llamada.asignarEmpleado(emp);
		llamada.guardarEstadoDispatcher(this);
		(new Thread(llamada)).start();
	}

	public void verificarLlamadasEnEspera() {
		if (!llamadasEnEspera.isEmpty()) {
			this.dispatchCall(llamadasEnEspera.poll());
		}
	}

	public void colgarLlamada() {
		LLAMADAS_EN_CURSO--;
	}

	public void iniciarListaEmpleados(List<Empleado> empleados) {
		colaDeEmpleados.addAll(empleados);
	}
}
