package mx.com.cursodia.gamersapi.GamersAPIREST.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//este es el punto de contacto con el aspecto y el lugar donde se centralizan las excepciones
@ControllerAdvice
public class GlobalExceptionHandler 
{
	//le decimos que va a heredar del ResourceNotFoundException.class
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		//ESTE SERIA NUESTRO CONTROLADOR DE EXCEPCIONES
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<String> handleMissingPropertyException(PropertyValueException e)
	{
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//Aqui se podria poner otros manejadores de excepciones+
}
