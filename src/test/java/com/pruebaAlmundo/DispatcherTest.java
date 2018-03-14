package com.pruebaAlmundo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.pruebaAlmundo.constantes.EstadoEmpleado;
import com.pruebaAlmundo.constantes.EstadoLlamada;
import com.pruebaAlmundo.constantes.TipoEmpleado;
import com.pruebaAlmundo.entidades.Empleado;
import com.pruebaAlmundo.entidades.Llamada;
import com.pruebaAlmundo.negocio.Dispatcher;

import junit.framework.Assert;

public class DispatcherTest {

	List<Llamada> llamadas = new LinkedList<>();
	List<Empleado> empleados = new LinkedList<>();
	Dispatcher dispatcher = new Dispatcher();

	@Test
	public void atenderLlamadas() {
		llamadas.add(new Llamada("1", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("2", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("3", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("4", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("5", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("6", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("7", EstadoLlamada.ENTRANTE));
		llamadas.add(new Llamada("8", EstadoLlamada.ENTRANTE));

		empleados.add(new Empleado("Sergio", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Esteban", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Forero", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pinzon", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Daniel", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Carlos", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Manuel", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pedro", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));

		dispatcher.iniciarListaEmpleados(empleados);
		for (Llamada llamada : llamadas) {
			dispatcher.dispatchCall(llamada);
		}
		Assert.assertEquals("Todas las llamadas son atendidas", 0, dispatcher.getLlamadasEnEspera().size());
	}

	@Test
	public void encolarLlamadas() {
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

		empleados.add(new Empleado("Sergio", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Esteban", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Forero", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pinzon", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Daniel", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Carlos", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Manuel", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pedro", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		dispatcher.iniciarListaEmpleados(empleados);
		for (Llamada llamada : llamadas) {
			dispatcher.dispatchCall(llamada);
		}
		Assert.assertEquals("Se encolan 2 llamadas", 2, dispatcher.getLlamadasEnEspera().size());
	}

	@Test
	public void masDeDiesLlamadasConcurrentes() {
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
		
		empleados.add(new Empleado("Sergio", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Esteban", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Forero", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pinzon", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Daniel", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Carlos", TipoEmpleado.DIRECTOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Manuel", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Pedro", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Alejandro", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Miguel", TipoEmpleado.SUPERVISOR, EstadoEmpleado.DISPONIBLE));
		empleados.add(new Empleado("Alvaro", TipoEmpleado.OPERADOR, EstadoEmpleado.DISPONIBLE));
		dispatcher.iniciarListaEmpleados(empleados);
		for (Llamada llamada : llamadas) {
			dispatcher.dispatchCall(llamada);
		}
		Assert.assertEquals("10 llamadas concurrentes", 10, dispatcher.getLlamadas_en_curso());
	}

}
