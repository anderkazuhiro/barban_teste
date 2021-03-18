package br.com.teste.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false, length = 250)
    String nome;
    @Column(nullable = false, length = 150)
    Integer quantidade;
    @Column(nullable = true, length = 20)
    Date DataDeCadastro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataDeCadastro() {
        return DataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        DataDeCadastro = dataDeCadastro;
    }
}
