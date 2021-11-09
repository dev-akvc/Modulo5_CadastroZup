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

    public List<Cadastro> buscarCadastros (Boolean moraSozinho, Boolean temPet, Integer idade){
        if(moraSozinho != null){
            return  cadastroRepository.findAllByMoraSozinho(moraSozinho);
        }
        if(temPet != null){
            return cadastroRepository.findAllByTemPet(temPet);
        }
        if(idade != null){
            return cadastroRepository.findAllByIdade(idade);
        }
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }



}
