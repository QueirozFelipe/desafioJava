package personal.queiroz.felipe.desafioJava.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoProjetoDTO;
import personal.queiroz.felipe.desafioJava.service.ProjetoService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/cadastroProjeto")
public class CadastroProjetoView {

    @Autowired
    private ProjetoService projetoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cadastro() {
        List<DetalhamentoProjetoDTO> cadastro = projetoService.listarProjetos();
        ModelAndView modelAndView = new ModelAndView("cadastroProjeto");
        modelAndView.addObject("cadastroProjeto", cadastro);
        return modelAndView;
    }

}
