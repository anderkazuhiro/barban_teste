package br.com.tokiomarine.seguradora.avaliacao.service.util;

import br.com.tokiomarine.seguradora.avaliacao.Error.InvalidParameterException;
import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ValidateEstudante {

public void validate(Estudante estudante){


        String nome  = estudante.getNome();
        String email = estudante.getEmail();
        String matricula = estudante.getMatricula();

        if(nome == null){
            throw new InvalidParameterException("Nome é obrigatório");
    }
        if(email == null){
            throw new InvalidParameterException("email é obrigatório");
        }
        if(matricula==null){
            throw new InvalidParameterException("Matrícula é obrigatória");
        }

        if(!validateEmail(email)){
         throw new InvalidParameterException("email invalido");
        }


}

    private boolean validateEmail(String email){
     final String regex = "^(.+)@(.+)$";
      Pattern pattern = Pattern.compile(regex);

      Matcher matcher = pattern.matcher(email);

      return matcher.find();

}


}