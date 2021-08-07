package com.cenfotec.app.services;

import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.repo.AtletaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService {

    @Autowired
    AtletaRepository repo;

    @Override
    public List<Atleta> getAll() {
        return repo.listaProcedure();
    }
    
    public Atleta getById(long id){
        return repo.idProcedure(id);
    }

    public void save(Atleta atleta){
        repo.save(atleta.getId(), atleta.getNombre(), atleta.getApellidos1(), atleta.getApellidos2(), atleta.getFechaNacimiento(),
        		atleta.getDeporte(), atleta.getEstatura(), atleta.getPeso(), atleta.getSexo(), atleta.getProvincia(), atleta.getCanton(), atleta.getDistrito(), 
        		atleta.getTelefono(), atleta.getCorreo());
    }
    
    public List<Atleta> getSearch(String nombre){
        return repo.searchProcedure(nombre);
    }

    public void updateProcedure(Atleta atleta){
        repo.updateProcedure(atleta.getId(), atleta.getPeso(), atleta.getProvincia(), atleta.getCanton(), atleta.getDistrito(), atleta.getTelefono(), atleta.getCorreo());
    }
    
    
}

