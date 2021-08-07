package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.domain.IMC;
import com.cenfotec.app.services.AtletaService;
import com.cenfotec.app.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class AtletaController {

    @Autowired
    AtletaService atletaService;
    
    @Autowired
    ImcService imcService;
       
    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
    model.addAttribute("atletas", atletaService.getAll());
    return "listar";
    }
    
    @RequestMapping("/detalleAtleta/{id}")
    public String verId(Model model, @PathVariable long id) {
    model.addAttribute("atleta", atletaService.getById(id));
    return "detalleAtleta";
    }
    
    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertar";
    }
    
    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String save(Atleta atleta, BindingResult result, Model model) {
    	atletaService.save(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
        return "index";
    }
    
    @RequestMapping("/search/{name}")
    public String search(Model model, @PathVariable("name") String name) {
    	model.addAttribute("search", atletaService.getSearch(name));
    	return "listar";
    }
    
    @RequestMapping(value = "/update",  method = RequestMethod.GET)
    public String update(Atleta atleta, BindingResult result, Model model) {
    	atletaService.updateProcedure(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
    	return "index";
    }
    
    @RequestMapping( value="/update/{id}", method = RequestMethod.PUT)
    public String update(Atleta atleta, BindingResult result, Model model, @PathVariable String id) {
    	atletaService.updateProcedure(atleta);
    	imcService.saveProcedure(new IMC(atleta.getId(),atleta.getPeso(),atleta.getEstatura()));
    	return "index";
    }
    
}



