package es.unican.ps.seminarioMockito;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ClienteTest {

	private static Cliente sut;
	private static Seguro mockSeguro1;
	private static Seguro mockSeguro2;
	private static Seguro mockSeguro3;
	private static final double REDUCCION_MINUSVALIA = 0.75;

	@BeforeClass
	public static void inicializa() {

		// 1. Creaci�n de los objetos Mock
		mockSeguro1 = mock(Seguro.class);
		mockSeguro2 = mock(Seguro.class);
		mockSeguro3 = mock(Seguro.class);

		// 2. Programaci�n del comportamiento de los objetos Mock
		when(mockSeguro1.getPrecio()).thenReturn(105.0);
		when(mockSeguro2.getPrecio()).thenReturn(340.0);
		when(mockSeguro3.getPrecio()).thenReturn(200.0);
	
	}

	@Test
	public void testAddSeguroYGetSeguros() {
		sut = new Cliente(false);

		// 4. Ejecuci�n de casos de prueba
		assertTrue(sut.addSeguro(mockSeguro1));
		assertTrue(sut.getSeguros().size() == 1);

		sut.addSeguro(mockSeguro2);
		sut.addSeguro(mockSeguro3);
		assertTrue(sut.getSeguros().size() == 3);
	}

	@Test
	public void testGetTotal() {
		// cliente no minusv�lido
		sut = new Cliente(false);
		
		assertTrue(sut.getTotal() == 0);
		
		sut.addSeguro(mockSeguro1);
		assertTrue(sut.getTotal() == 105);

		sut.addSeguro(mockSeguro2);
		sut.addSeguro(mockSeguro3);
		assertTrue(sut.getTotal() == 645.0);

		// Cliente minusvalido
		sut.setMinusvalia(true);
		assertTrue(sut.getTotal() == 645.0*REDUCCION_MINUSVALIA);
		
	}
	

}
