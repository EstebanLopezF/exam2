package com.cenfotec.app.controllers;

import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.domain.IMC;
import com.cenfotec.app.services.AtletaService;
import com.cenfotec.app.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    

	@GetMapping("/search/{name}")
    public ResponseEntity<List<Atleta>> getList(@PathVariable("name") String name){
        List<Atleta> atletas = atletaService.getSearch(name);
        return new ResponseEntity(atletas, HttpStatus.OK);
    }
    
	
	
	
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Atleta atleta){
    	atletaService.updateProcedure(atleta);
        return new ResponseEntity("atleta actualizado", HttpStatus.OK);
    }
    
    

}



