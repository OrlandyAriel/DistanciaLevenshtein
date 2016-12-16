package ull.herramientas.DistanciaLevenshtein;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * \class DistanciaLevenshteinTest
 * \author Orlandy Ariel Sánchez A.
 * \brief Test de pruebas para la clase DistanciaLevenshtein
 */
public class DistanciaLevenshteinTest
{
	private DistanciaLevenshtein m_distancia1;
	/**
	 * \brief crea el objeto
	 */
	@Before
	public void config()
	{
		m_distancia1 = new DistanciaLevenshtein();
	}
	/**
	 * \brief test que prueba el funcionamiento normal.
	 */
	@Test
	public void pruebaFuncionamientoNormal()
	{
		int t_dis1 = m_distancia1.calcularDistanciaLevenshtein("hola", "casa");
		int t_dis2 = 3;
		int t_dis3 = m_distancia1.calcularDistanciaLevenshtein("casa", "hola");
		assertEquals(t_dis1, t_dis2);
		assertEquals(t_dis1, t_dis3);
	}
	
}
