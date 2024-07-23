package personal.queiroz.felipe.desafioJava.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.repository.ProjetoRepository;
import personal.queiroz.felipe.desafioJava.service.ProjetoService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/pessoas")
public class PessoaView {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("pessoas");
        modelAndView.addObject("pessoas", pessoas);
        return modelAndView;
    }


}
