package com.cenfotec.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.app.domain.Atleta;
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