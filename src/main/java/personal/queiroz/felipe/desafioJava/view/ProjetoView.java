package personal.queiroz.felipe.desafioJava.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoProjetoDTO;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.repository.ProjetoRepository;
import personal.queiroz.felipe.desafioJava.service.ProjetoService;

import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/projetos")
public class ProjetoView {

    @Autowired
    private  ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoService projetoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Projeto> projetos = projetoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("projetos");
        modelAndView.addObject("projetos", projetos);
        return modelAndView;
    }


}
