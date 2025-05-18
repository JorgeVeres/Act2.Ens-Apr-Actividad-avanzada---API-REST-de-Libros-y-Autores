package com.dam.bibliotecaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dam.bibliotecaapi.model.Autor;
import com.dam.bibliotecaapi.repository.AutorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
}