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

    public void cadastrarPessoa(CadastroDTO cadastroDTO) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCpf(cadastroDTO.getCpf());
        cadastro.setNome(cadastroDTO.getNome());
        cadastro.setSobrenome(cadastroDTO.getSobrenome());
        cadastro.setCidade(cadastroDTO.getCidade());
        cadastro.setBairro(cadastroDTO.getBairro());
        cadastro.setNomeDoParenteProximo(cadastroDTO.getNomeDoParenteProximo());
        cadastro.setMoraSozinho(cadastroDTO.isMoraSozinho());
        cadastro.setTemPet(cadastroDTO.isTemPet());
        cadastro.setIdade(cadastroDTO.getIdade());
        cadastro.setDataDoCadastro(dataDoCadastro);

        cadastroRepository.save(cadastro);

    }

    public List<Cadastro> buscarCadastros (boolean moraSozinho, boolean temPet, int idade){
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
