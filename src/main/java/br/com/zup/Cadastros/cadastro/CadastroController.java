package br.com.zup.Cadastros.cadastro;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<CadastroResumoDTO> buscarCadastros(@RequestParam(required = false) Boolean moraSozinho,
                                                   @RequestParam(required = false) Boolean temPet,
                                                   @RequestParam(required = false) Integer idade) {
        List<CadastroResumoDTO> cadastrosResumoDTO = new ArrayList<>();

        for(Cadastro cadastro: cadastroService.buscarCadastros(moraSozinho, temPet, idade)){
            CadastroResumoDTO resumoDTO = modelMapper.map(cadastro, CadastroResumoDTO.class);
            cadastrosResumoDTO.add(resumoDTO);
        }
        return cadastrosResumoDTO;

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro(@PathVariable String cpf){
        cadastroService.deletarCadastro(cpf);
    }

}
