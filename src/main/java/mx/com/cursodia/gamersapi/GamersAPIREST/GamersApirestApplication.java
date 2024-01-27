package mx.com.cursodia.gamersapi.GamersAPIREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication //PUNTO DE ENTRADA DE LA APLICACION
@EntityScan("mx.com.cursodia.gamersapi.GamersAPIREST.beans")//CUAL ES EL FOLDER QUE TIENE QUE ESCANEAR PARA BUSCAR LOS BEANS
public class GamersApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamersApirestApplication.class, args);
	}

}
