package mx.com.cursodia.gamersapi.GamersAPIREST.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//constructor
	public ResourceNotFoundException(String message)
	{
		//Aqui se llama al constructor de la clase padre y le esta pasando el message
		super(message);
	}
}
