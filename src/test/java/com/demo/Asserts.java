package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserts {
	private int numeroUno = 5;
	private int numeroDos = 3;
	
	@Test
	public void testNumeroVerdadero() {
		Assert.assertTrue(numeroUno==numeroDos+2, numeroUno + " != " + (numeroDos+2));
	}
	
	@Test
	public void testNumeroFalso() {
		Assert.assertFalse(numeroUno==numeroDos, "Ambos números son iguales");
	}
	
	@Test
	public void testNumerosIguales() {
		Assert.assertEquals(numeroUno+10, numeroDos+12);
	}
	
	@Test
	public void testNumerosNoIguales() {
		Assert.assertNotEquals(numeroUno-1, numeroDos*12);
	}
	
	@Test
	public void testNoNulo() {
		Personas personas = new Personas("Edgar", "Garza");
		Assert.assertNotNull(personas);
	}
	
	@Test
	public void testDeNulo() {
		Personas personas = null;
		Assert.assertNull(personas);
	}
	
	@Test
	public void testNotMismoObjeto() {
		Personas personas = new Personas("Edgar", "Garza");
		Personas personas2 = new Personas("Edgar", "Garza");
		Assert.assertNotSame(personas, personas2);
	}
	
	@Test
	public void testMismoObjeto() {
		Personas personas = new Personas("Edgar", "Garza");
		Personas personas2 = personas;
		Assert.assertSame(personas, personas2);
	}

}
