package personal.queiroz.felipe.desafioJava.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoPessoaDTO;
import personal.queiroz.felipe.desafioJava.service.PessoaService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/cadastroPessoa")
public class CadastroPessoaView {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cadastro() {
        List<DetalhamentoPessoaDTO> cadastro = pessoaService.listarPessoas();
        ModelAndView modelAndView = new ModelAndView("cadastroPessoa");
        modelAndView.addObject("cadastroPessoa", cadastro);
        return modelAndView;
    }

}
