package ar.com.dperalta.conversor.controller;

import ar.com.dperalta.conversor.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
    @Autowired
    private ConversorService conversorService;

    @PostMapping
    public String conversorNumerico (@RequestBody String data){
        return conversorService.convertir(data);
    }
}
