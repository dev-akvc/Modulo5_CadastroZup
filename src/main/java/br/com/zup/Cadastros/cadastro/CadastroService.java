package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    LocalDate dataDoCadastro = LocalDate.now();

    public void cadastrarPessoa(Cadastro cadastro) {
        if(cadastroRepository.existsById(cadastro.getCpf())){
            throw new CadastroDuplicadoException();
        }
        cadastro.setDataDoCadastro(dataDoCadastro);
        cadastroRepository.save(cadastro);

    }

    public List<Cadastro> buscarCadastros (Boolean moraSozinho, boolean temPet, int idade){
        if(moraSozinho){
            return  cadastroRepository.findAllByMoraSozinho(moraSozinho);
        }
        if(temPet){
            return cadastroRepository.findAllByTemPet(temPet);
        }
        if(idade != 0){
            return cadastroRepository.findAllByIdade(idade);
        }
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }



}
