package com.cenfotec.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.app.domain.Atleta;
import com.cenfotec.app.domain.IMC;
import com.cenfotec.app.repo.ImcRepository;

@Service
public class ImcServiceImpl implements ImcService {
	
    @Autowired
    ImcRepository repo;

    @Override
    public void saveProcedure(IMC imc){
        repo.saveProcedure(imc.getIindice(), imc.getIdAtleta());
    }
   	
    public List<IMC> getById(long id){
        return repo.idProcedure(id);
    }
	
}
