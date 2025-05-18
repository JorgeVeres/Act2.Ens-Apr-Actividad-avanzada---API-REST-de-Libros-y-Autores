package com.dam.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dam.bibliotecaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}