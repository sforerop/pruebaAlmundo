package com.pruebaAlmundo.negocio;


public class HiloLlamada extends Thread {

	@Override
	public void run() {
		System.out.println( Thread.currentThread() +" DENTRO");
	}

}
