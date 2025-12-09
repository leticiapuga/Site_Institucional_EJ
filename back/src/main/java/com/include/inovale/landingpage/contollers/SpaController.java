package com.include.inovale.landingpage.contollers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    // Regex atualizado: "/**/{path:[^\\.]*}"
    // Isso significa: "Pegue qualquer caminho, de qualquer profundidade, 
    // desde que NÃO tenha um ponto (extensão de arquivo) no final"
    @RequestMapping(value = "/**/{path:[^\\.]*}")
    public String redirect() {
        // Redireciona tudo para o React
        return "forward:/index.html";
    }
}