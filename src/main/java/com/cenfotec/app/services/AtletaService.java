package com.cenfotec.app.services;

import com.cenfotec.app.domain.Atleta;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AtletaService {

    public List<Atleta> getAll();
    public Atleta getById(long id);
    public void save(Atleta atleta);
    public List<Atleta> getSearch(String nombre);
    public void updateProcedure(Atleta atleta);
    
}