package quarto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/createCliente") 
    public ModelAndView createCliente(){
        return new ModelAndView("createCliente");
    }
	
	@RequestMapping("/createQuarto") 
    public ModelAndView createQuarto(){
        return new ModelAndView("createQuarto");
    }
	
	@RequestMapping("/createProduto") 
    public ModelAndView createProduto(){
        return new ModelAndView("createProduto");
    }
	
}
