package br.com.teste.service;

import java.util.List;

import javax.validation.Valid;

import br.com.teste.entidade.Produto;

public interface ProdutoService {

	List<Produto> buscarProdutos();

	String cadastrarProduto(@Valid Produto produto);

	Produto buscarProduto(long id);

	void atualizarProduto(@Valid Produto produto, Long id);

	void apagarProduto(Long id);
}
