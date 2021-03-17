package es.studium.CamellosPractica;


public class Camellos {
	private int nombreCamello;
	private int posicionCamello;
	//Getters y setters
	
	public Camellos()
	{
		nombreCamello = 0;
		posicionCamello = 0;
	}
	public int getNombreCamellos()
	{
		return nombreCamello;
	}

	public void setNombreCamellos(int nC)
	{
		nombreCamello = nC;
	}

	public int getPosicionCamellos()
	{
		return posicionCamello;
	}

	public void setPosicionCamellos(int pC)
	{
		posicionCamello = pC;
	}
}