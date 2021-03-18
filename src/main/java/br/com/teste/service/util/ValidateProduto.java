package br.com.teste.service.util;

import br.com.teste.entidade.Produto;
import br.com.teste.Error.InvalidParameterException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ValidateProduto {

public void validate(Produto produto){


        String nome  = produto.getNome();
        Integer quantidade = produto.getQuantidade();

        if(nome == null){
            throw new InvalidParameterException("Nome é obrigatório");
    }
        if(quantidade == null){
            throw new InvalidParameterException("quantidade é obrigatório");
        }

}

}
