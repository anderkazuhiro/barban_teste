package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/estudantes/")
public class EstudanteRestController {

    @Autowired
    EstudandeService service;


    @GetMapping(value="listar",produces = {"application/json","application/xml"})
    public List<Estudante> listarEstudantes() {
        return service.buscarEstudantes();
    }

    @PostMapping(value="add",produces = {"application/json","application/xml"})
    public ResponseEntity<String> adicionarEstudante(@RequestBody Estudante estudante) {

        String id =  service.cadastrarEstudante(estudante);
        return new ResponseEntity<>("Id do estudante : " + id,HttpStatus.CREATED);

    }

    @GetMapping(value="buscar/{id}",produces = {"application/json","application/xml"})
    public Estudante exibirEdicaoEstudante(@PathVariable long id) {
        Estudante estudante = service.buscarEstudante(id);
        return estudante;
    }

    @PutMapping(value="atualizar/{id}",produces = {"application/json","application/xml"})
    public ResponseEntity<String>  atualizarEstudante(@PathVariable("id") long id, @RequestBody Estudante estudante, BindingResult result) {

        service.atualizarEstudante(estudante,id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="apagar/{id}",produces = {"application/json","application/xml"})
    public ResponseEntity apagarEstudante(@PathVariable("id") long id) {
        service.apagarEstudante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
