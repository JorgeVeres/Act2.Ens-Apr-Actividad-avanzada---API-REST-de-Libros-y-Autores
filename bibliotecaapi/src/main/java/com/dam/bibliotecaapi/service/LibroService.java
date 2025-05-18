package com.dam.bibliotecaapi.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.dam.bibliotecaapi.model.Autor;
import com.dam.bibliotecaapi.model.Libro;
import com.dam.bibliotecaapi.repository.AutorRepository;
import com.dam.bibliotecaapi.repository.LibroRepository;
import com.dam.bibliotecaapi.specifications.LibroSpecifications;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    @Transactional
    public Libro save(Libro libro) {
        Autor autor = autorRepository.findById(libro.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        libro.setAutor(autor);
        return libroRepository.save(libro);
    }

    @Transactional
    public Libro update(Long id, Libro libroDetails) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setTitulo(libroDetails.getTitulo());
        libro.setIsbn(libroDetails.getIsbn());
        libro.setAnioPublicacion(libroDetails.getAnioPublicacion());

        if (libroDetails.getAutor() != null) {
            Autor autor = autorRepository.findById(libroDetails.getAutor().getId())
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
            libro.setAutor(autor);
        }

        return libroRepository.save(libro);
    }

    @Transactional
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscarLibros(String titulo, Integer anio, String sortBy, String order) {
        Specification<Libro> spec = Specification.where(null);

        if (titulo != null && !titulo.isEmpty()) {
            spec = spec.and(LibroSpecifications.hasTituloContaining(titulo));
        }
        if (anio != null) {
            spec = spec.and(LibroSpecifications.hasAnioPublicacion(anio));
        }

        Sort sort = Sort.by(sortBy != null ? sortBy : "id");
        sort = order != null && order.equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();

        return libroRepository.findAll(spec, sort);
    }
}