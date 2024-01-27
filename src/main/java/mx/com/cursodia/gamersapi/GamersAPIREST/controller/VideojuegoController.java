package mx.com.cursodia.gamersapi.GamersAPIREST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.cursodia.gamersapi.GamersAPIREST.beans.Videojuego;
import mx.com.cursodia.gamersapi.GamersAPIREST.repository.VideojuegoRepository;

@RestController
@RequestMapping("/videojuegos") //ruta que se mapea
public class VideojuegoController 
{
	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	@GetMapping //verbo a mappear
	public List<Videojuego> getAllVideojuegos()
	{
		return videojuegoRepository.findAll();
	}
	
	//Get ONE
	//hay dos formas de pasar parametros en una ruta en java: Query Param y Path Param
	//En este caso usamos un Query Param
	@GetMapping("/{id}")
	public ResponseEntity<Videojuego> getVideojuegoById(@PathVariable Long id)
	{
		//Optional es un objeto que puede o no existir. Su uso es para darle un tratamiento si llega a ser nulo como
		//por ejemplo, asignarle un valor default en caso de ser nulo. En este caso, traemos otra informacion
		Optional<Videojuego> videojuego = videojuegoRepository.findById(id);
		
		//Si no se encuentra un videojuego, redirigimos a un not_found que es un status de http
		return videojuego.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//Borrar Videojuego
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteVideojuego(@PathVariable Long id)
	{
		return videojuegoRepository.findById(id)
				.map(videojuego -> {videojuegoRepository.delete(videojuego);
				return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
				}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
}
