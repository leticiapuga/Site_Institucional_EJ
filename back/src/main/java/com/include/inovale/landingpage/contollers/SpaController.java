package com.include.inovale.landingpage.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    // Redireciona rotas que não tem extensão de arquivo (ex: .js, .css) para o index.html
    // Isso permite que o React Router assuma o controle
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}