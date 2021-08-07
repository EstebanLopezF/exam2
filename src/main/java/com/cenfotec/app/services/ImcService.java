package com.cenfotec.app.services;

import java.util.List;
import com.cenfotec.app.domain.IMC;

public interface ImcService {

	public void saveProcedure(IMC imc);
    public List<IMC> getById(long id);
}
