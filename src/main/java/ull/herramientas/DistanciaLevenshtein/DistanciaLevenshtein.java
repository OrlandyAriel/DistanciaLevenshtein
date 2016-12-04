package ull.herramientas.DistanciaLevenshtein;
/**
 * \class DistanciaLevenshtein
 * \brief Clase que calcula la distancia entre una cadena de texto y otra
 * Haciendo uso del algoritmo de V.Levenshtein, este calcula la distancia 
 * o el mínimo número de operaciones que se necesita para transformar una cadena
 * en la otra.
 * \author Orlandy Ariel Sánchez A.
 *
 */
public class DistanciaLevenshtein
{
	/**
	 * \brief método que calcula el minimo de los 3 valores pasados por parámetro
	 * @param a
	 * @param b
	 * @param c
	 * @return devuelve el valor mínimio de entre los 3 parámetros
	 */
	private  int minima(int a, int b, int c) {
        if(a<=b && a<=c)
        {
            return a;
        } 
        if(b<=a && b<=c)
        {
            return b;
        }
        return c;
    }
	/**
	 * \brief Método que recibe 2 cadenas
	 * @param cadena1
	 * @param cadena2
	 * @return, retorna la distancia entre una cadena y otra.
	 */
    public  int calcularDistanciaLevenshtein(String cadena1, String cadena2) {
    	if(cadena1.isEmpty() && cadena2.isEmpty())
    		throw new RuntimeException("Las cadenas son vacias, no hay distancias");
    	
        return calcularDistanciaLevenshtein(cadena1.toCharArray(),
                                          cadena2.toCharArray());
    }
    /**
     * \brief Método interno que se encarga de realizar las operaciones 
     * para calcular la distancia
     * @param str1
     * @param str2
     * @return, devuelve la distancia entre una cadena y la otra
     */
    private  int calcularDistanciaLevenshtein(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++)
        {
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++)
        {
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++)
        {
            for(int j=1;j<=str2.length;j++)
            { 
                  distance[i][j]= minima(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
    }
}
