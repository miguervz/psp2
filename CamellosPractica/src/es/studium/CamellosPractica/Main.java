package es.studium.CamellosPractica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int nCamellos, casillasRecorridas = 0;

	public static void main(String[] args) throws IOException 
	{			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Seleccione el número de camellos que quiere que corran:");
		nCamellos = Integer.parseInt(br.readLine());
		System.out.println("Seleccione la distancia en unidades de la carrera:");
		
		casillasRecorridas = Integer.parseInt(br.readLine());
		
		
		// Crea un hilo por cada camello
		
		for(int i=0; i<nCamellos; i++) 
			
			{	
				new Thread(new HiloCamellos(i+1, new Camellos())).start();
			}
		
		br.close();
	}
} 