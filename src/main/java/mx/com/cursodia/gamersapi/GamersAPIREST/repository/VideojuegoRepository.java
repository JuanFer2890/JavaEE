package mx.com.cursodia.gamersapi.GamersAPIREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.cursodia.gamersapi.GamersAPIREST.beans.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> 
{

}
