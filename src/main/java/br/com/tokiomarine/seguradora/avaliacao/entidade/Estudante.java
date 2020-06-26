package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="estudante")
public class Estudante implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false, length = 250)
    String nome;
    @Column(nullable = false, length = 150)
    String email;
    @Column(nullable = false, length = 20)
    String telefone;
    @Column(nullable = false, length = 50)
    String matricula;
    @Column(nullable = false, length = 150)
    String curso;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
