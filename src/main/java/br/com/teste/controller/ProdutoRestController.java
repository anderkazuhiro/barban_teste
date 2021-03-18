package br.com.teste.controller;

import br.com.teste.entidade.Produto;
import br.com.teste.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Produtos/")
public class ProdutoRestController {

    @Autowired
    ProdutoService service;


    @GetMapping(value="listar",produces = {"application/json","application/xml"})
    public List<Produto> listarProdutos() {
        return service.buscarProdutos();
    }

    @PostMapping(value="add",produces = {"application/json","application/xml"})
    public ResponseEntity<String> adicionarProduto(@RequestBody Produto produto) {

        String id =  service.cadastrarProduto(produto);
        return new ResponseEntity<>("Id do Produto : " + id,HttpStatus.CREATED);

    }

    @GetMapping(value="buscar/{id}",produces = {"application/json","application/xml"})
    public Produto buscarProduto(@PathVariable long id) {
        Produto produto = service.buscarProduto(id);
        return produto;
    }

    @PutMapping(value="atualizar/{id}",produces = {"application/json","application/xml"})
    public ResponseEntity<String> atualizarProduto(@PathVariable("id") long id, @RequestBody Produto produto, BindingResult result) {

        service.atualizarProduto(produto,id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="apagar/{id}",produces = {"application/json","application/xml"})
    public ResponseEntity apagarProduto(@PathVariable("id") long id) {
        service.apagarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
