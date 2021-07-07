package br.com.mentorama.apiFilmes.controllers;

import br.com.mentorama.apiFilmes.entities.Filmes;
import br.com.mentorama.apiFilmes.services.IFilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    private final List<Filmes>  filmesList;

    @Autowired
    private final IFilmesService filmesService;

    public FilmesController(IFilmesService filmesService) {
        this.filmesService = filmesService;
        this.filmesList = new ArrayList<>();
    }

    @GetMapping
    public List<Filmes> findAll(@RequestParam(required = false) Filmes filmes){
        return filmesService.findAll(filmes);
    }

    @GetMapping("/{id}")
    public Filmes findId(@PathVariable("id") Integer id){
        return filmesService.findId(id);
    }

    @PostMapping
    public ResponseEntity<Filmes> add(@RequestBody final Filmes filmes) {
           filmesService.add(filmes);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateNome(@RequestBody final Filmes nome) {
        filmesService.updateName(nome);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping
//    public ResponseEntity updateDiretor(@RequestBody final Filmes diretor) {
//        filmesService.updateDiretor(diretor);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    @PutMapping
//    public ResponseEntity updateAno(@RequestBody final Filmes ano) {
//        filmesService.updateAno(ano);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping
//    public ResponseEntity updateNota(@RequestBody final Filmes nota) {
//        filmesService.updateNota(nota);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        filmesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    //conferir documentação
    //http://localhost:8080/v3/api-docs
    //conferir documentacao com interface grafica
    //http://localhost:8080/swagger-ui.html
}
