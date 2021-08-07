package com.cenfotec.app.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cenfotec.app.domain.IMC;

@Repository
public interface ImcRepository extends JpaRepository<IMC, Long>{

    @Query(value = "{call save_procedure_imc(:indiceParam, :idAtletaParam)}", nativeQuery = true)
    void saveProcedure(
            @Param("indiceParam")double indiceParam,
            @Param("idAtletaParam")long idAtletaParam  
    );
    
    @Query(value = "{call id_procedure_IMC(:idIn)}", nativeQuery = true)
    List<IMC> idProcedure(@Param("idIn") long idIn);
    
}