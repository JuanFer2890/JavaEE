package mx.com.cursodia.gamersapi.GamersAPIREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.cursodia.gamersapi.GamersAPIREST.beans.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>
{
	
}
