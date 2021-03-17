package es.studium.CamellosPractica;

import java.util.Random;

public class HiloCamellos implements Runnable {
	private Camellos camello;
	private int nombre;
	private static int listaCamellos[] = new int[Main.nCamellos];
	private boolean ganador = false;
	private static boolean Final = false;
	
	public HiloCamellos(int n, Camellos c)
	{
		nombre = n;
		camello = c;
	}	
	public void run() 
	{
		while(Final == false)
		{
			Carrera();
		}
		if(Final && ganador == false)
		{
			System.out.println("El camello número " + nombre + " se ha quedado a " + (Main.casillasRecorridas - camello.getPosicionCamellos()) + " posiciones de la meta");
			Thread.interrupted();
		}
	}

	public static int funcionAvanzar()
	{
		int movimiento = 0;
		Random r = new Random();
		int prob = r.nextInt(100);
		if(prob >= 0 && prob < 30)
		{
			movimiento = 0;
		}
		else if(prob >= 30 && prob < 70)
		{
			movimiento = 1;
		}
		else if(prob >= 70 && prob < 90)
		{
			movimiento = 2;
		}
		else
		{
			movimiento = 3;
		}
		return movimiento;
	}
	public int avanceCamello(int movimiento)
	{
		int posicion = camello.getPosicionCamellos();
		int movimientoCamello = posicion + movimiento;
		camello.setPosicionCamellos(movimientoCamello);
		return movimientoCamello;
	}	
	public int Camello1()
	{
		int lider = 0;
		for(int i=0; i<listaCamellos.length; i++)
		{
			if(listaCamellos[i] > lider)
			{
				lider = listaCamellos[i];
			}
		}
		return lider;
	}	
	public synchronized void Carrera()
	{
		int av = funcionAvanzar();
		listaCamellos[nombre - 1] = avanceCamello(av);
		System.out.println("El camello " + nombre + " avanza " + av + " posiciones, lleva " + camello.getPosicionCamellos() + " posiciones y va a " + (Camello1() - camello.getPosicionCamellos()) + " posiciones del líder");
		if(camello.getPosicionCamellos() >= Main.casillasRecorridas)
		{					
			Final = true;
			ganador = true;
			try 
			{			
				Thread.sleep(300);			
				System.out.println("\nHa ganado un camello");
				System.out.println("El Camello número " + nombre + " ha ganado.");
				System.out.println("\nEl resto de camellos han quedado así:");				
				Thread.interrupted();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}			
		}
		try 
		{
			Thread.sleep(1000);							
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}