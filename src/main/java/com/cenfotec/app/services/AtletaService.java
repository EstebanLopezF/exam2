package com.cenfotec.app.services;

import com.cenfotec.app.domain.Atleta;
import java.util.List;

public interface AtletaService {

    public List<Atleta> getAll();
    public Atleta getById(long id);
    public void save(Atleta atleta);
    public List<Atleta> getSearch(String nombre);
    public void updateProcedure(Atleta atleta);
    
}