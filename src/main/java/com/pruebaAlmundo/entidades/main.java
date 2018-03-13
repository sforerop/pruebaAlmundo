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
		Empleado e1 = new Empleado("Sergio", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE);
		Empleado e2 = new Empleado("Esteban", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE);
		Empleado e3 = new Empleado("Forero", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE);
		Empleado e4 = new Empleado("Pinzon", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE);
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		Dispatcher inicio = new Dispatcher();
		inicio.iniciarListaEmpleados(emps);
		for (Llamada llamada : llamadas) {
			inicio.dispatchCall(llamada);
		}
	}

}
