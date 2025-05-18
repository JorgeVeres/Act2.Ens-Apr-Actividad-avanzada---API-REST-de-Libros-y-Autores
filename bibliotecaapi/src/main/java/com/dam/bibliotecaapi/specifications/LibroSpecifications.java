package com.dam.bibliotecaapi.specifications;

import org.springframework.data.jpa.domain.Specification;
import com.dam.bibliotecaapi.model.Libro;

public class LibroSpecifications {
    public static Specification<Libro> hasTituloContaining(String titulo) {
        return (root, query, cb) -> 
            titulo == null ? null : cb.like(root.get("titulo"), "%" + titulo + "%");
    }

    public static Specification<Libro> hasAnioPublicacion(Integer anio) {
        return (root, query, cb) -> 
            anio == null ? null : cb.equal(root.get("anioPublicacion"), anio);
    }
}
