package br.com.zup.Cadastros.cadastro;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPessoa(@RequestBody @Valid CadastroDTO cadastroDTO) {
        Cadastro cadastro = modelMapper.map(cadastroDTO, Cadastro.class);

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
