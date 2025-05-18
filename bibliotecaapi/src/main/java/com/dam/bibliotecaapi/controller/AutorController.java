package com.dam.bibliotecaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dam.bibliotecaapi.model.Autor;
import com.dam.bibliotecaapi.service.AutorService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable Long id) {
        Optional<Autor> autor = autorService.findById(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.save(autor));
    }
}