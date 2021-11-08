package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionUsageException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PutMapping
    public void cadastrarPessoa(@RequestBody @Valid CadastroDTO cadastroDTO) {
        cadastroService.cadastrarPessoa(cadastroDTO);
    }

    @GetMapping
    public List<CadastroResumoDTO> buscarCadastros(@RequestParam boolean moraSozinho, boolean temPet, int idade) {
        List<CadastroResumoDTO> cadastrosResumoDTO = new ArrayList<>();
        for (Cadastro cadastro : cadastroService.buscarCadastros(moraSozinho, temPet, idade)) {
            if (moraSozinho) {
                cadastrosResumoDTO.add(
                        new CadastroResumoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
            else if (temPet) {
                cadastrosResumoDTO.add(
                        new CadastroResumoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
            else if(idade != 0){
                cadastrosResumoDTO.add(
                        new CadastroResumoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
            }
        }
        return cadastrosResumoDTO;
    }

    //método delete

}
