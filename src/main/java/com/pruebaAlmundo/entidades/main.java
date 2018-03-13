package com.pruebaAlmundo.entidades;

import java.util.LinkedList;
import java.util.List;

import com.pruebaAlmundo.constantes.EstadoEmpleado;
import com.pruebaAlmundo.constantes.EstadoLlamada;
import com.pruebaAlmundo.constantes.TipoEmpleado;
import com.pruebaAlmundo.negocio.Dispatcher;

/**
 * @author Sergio Forero
 *
 */
public class main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		List<Llamada> llamadas = new LinkedList<>();
		llamadas.add(new Llamada("1", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("2", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("3", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("4", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("5", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("6", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("7", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("8", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("9", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("10", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("11", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("12", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("13", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("14", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("15", EstadoLlamada.ENTRANTE));
		List<Empleado> emps = new LinkedList<>();
		emps.add(new Empleado("Sergio", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("Esteban", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("Forero", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("Pinzon", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("daniel", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("carlos", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("manuel", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("pedro", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("francisco", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("pablo", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("alvaro", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		emps.add(new Empleado("miguel", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		Dispatcher inicio = new Dispatcher();
		inicio.iniciarListaEmpleados(emps);
		for (Llamada llamada : llamadas) {
			inicio.dispatchCall(llamada);
		}
	}

}
