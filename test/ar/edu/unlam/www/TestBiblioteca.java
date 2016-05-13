package ar.edu.unlam.www;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBiblioteca {
	private Biblioteca myBiblioteca;

	@Before
	public void init() {
		myBiblioteca = new Biblioteca();
	}

	@Test
	public void testCrearSeccion() {

		myBiblioteca.createSection("Fantasia Medieval");
		Assert.assertTrue(myBiblioteca.existKey("Fantasia Medieval"));
	}
	
 	@Test
 	public void testAgregarLibro() {
 		
 		myBiblioteca.createSection("Fantasia Medieval");
 		myBiblioteca.addLibro("Fantasia Medieval", "1234567890123", "El Señor de los Chorizos");
		Assert.assertTrue(myBiblioteca.existLibro("Fantasia Medieval", "1234567890123", "El Señor de los Chorizos"));
 	}
 	
 	@Test
 	public void testGetLibro() throws Exception{
 		
 		myBiblioteca.createSection("Porno");
 		myBiblioteca.addLibro("Porno", "123", "Los mas turbados");
 		Libro resultadoGet = myBiblioteca.getLibro("123");
 		Assert.assertEquals("123",resultadoGet.getIsbn());
 	}
}
