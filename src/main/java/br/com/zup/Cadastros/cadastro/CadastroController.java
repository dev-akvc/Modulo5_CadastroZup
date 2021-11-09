package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPessoa(@RequestBody @Valid CadastroDTO cadastroDTO) {
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
        cadastroService.cadastrarPessoa(cadastro);
    }

//    @GetMapping
//    public List<CadastroResumoDTO> buscarCadastros(@RequestParam boolean moraSozinho, boolean temPet, int idade) {
//        List<CadastroResumoDTO> cadastrosResumoDTO = new ArrayList<>();
//        if(cadastroService.buscarCadastros(moraSozinho, temPet, idade)){
//
//        }
//
//    }

    //método delete

}
