package com.cenfotec.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cenfotec.app.domain.IMC;
import com.cenfotec.app.services.ImcService;

@Controller
public class ImcController {

    @Autowired
    ImcService imcService;

    @RequestMapping("/imc")
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody IMC imc){
    	imcService.saveProcedure(imc);
        return new ResponseEntity("IMC creado", HttpStatus.CREATED);
    }
    
    @RequestMapping("/imcHistorial/{id}")
    public String listIMC(Model model, @PathVariable long id) {
    	model.addAttribute("imclist", imcService.getById(id));
    	return "imcHistorial";
    }
    
}