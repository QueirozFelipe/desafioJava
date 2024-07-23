package personal.queiroz.felipe.desafioJava.view;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin
@Controller
public class IndexView {
    @GetMapping("/")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        return "index";
    }
}
