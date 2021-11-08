package br.com.zup.Cadastros.cadastro;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CadastroRepository extends CrudRepository<Cadastro, String> {
    List<Cadastro> findAllByMoraSozinho(boolean moraSozinho);

    List<Cadastro> findAllByTemPet(boolean temPet);

    List<Cadastro> findAllByIdade(int idade);
}
