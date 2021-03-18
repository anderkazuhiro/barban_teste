package br.com.teste.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import br.com.teste.Error.ResourceNotFoundException;
import br.com.teste.entidade.Produto;
import br.com.teste.repository.ProdutoRepository;
import br.com.teste.service.util.ValidateProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository repository;

	@Autowired
	ValidateProduto validateProduto;

	@Override
	public String cadastrarProduto(@Valid Produto produto) {
		validateProduto.validate(produto);

		Date data = new Date(System.currentTimeMillis());
		produto.setDataDeCadastro(data);

		produto = repository.save(produto);
		return produto.getId().toString();
	}

	@Override
	public void atualizarProduto(@Valid Produto produto, Long id) {
		validateProduto.validate(produto);
		Produto produtoAtualizado = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado"));

		produtoAtualizado.setNome(produto.getNome());
		produtoAtualizado.setQuantidade(produto.getQuantidade());

		repository.save(produtoAtualizado);
	}

	@Override
	public void apagarProduto(Long id) {

		Produto produto = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado"));
		repository.delete(produto);
	}

	@Override
	public List<Produto> buscarProdutos() {
		List<Produto> produtos = repository.findAll();
		return produtos;
	}

	@Override
	public Produto buscarProduto(long id) {
		Produto produto = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado"));
		return produto;
	}

}
