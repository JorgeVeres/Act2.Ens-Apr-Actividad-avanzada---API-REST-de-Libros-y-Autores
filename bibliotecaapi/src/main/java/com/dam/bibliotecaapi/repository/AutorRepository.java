package main.java.com.dam.bibliotecaapi.repository;

import com.tuapp.bibliotecaapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}