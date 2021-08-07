package com.cenfotec.app.repo;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cenfotec.app.domain.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long>{
    
	@Query(value = "{call lista_procedure}", nativeQuery = true)
	List<Atleta> listaProcedure();
    
    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Atleta idProcedure(@Param("idIn") long id);

    @Query(value = "{call save_procedure(:cedulaParam, :nombreParam, :apellidos1Param, :apellidos2Param, :fechaNacimientoParam, :deporteParam, "
    		+ ":estaturaParam, :pesoParam, :sexoParam, :provinciaParam, :cantonParam, :distritoParam, :telefonoParam, :correoParam )}", nativeQuery = true)
    void save(
            @Param("cedulaParam")long cedulaParam,   
            @Param("nombreParam")String nombreParam,
            @Param("apellidos1Param")String apellidos1Param,
            @Param("apellidos2Param")String apellidos2Param,
            @Param("fechaNacimientoParam")Date fechaNacimientoParam,
            @Param("deporteParam")String deporteParam,
            @Param("estaturaParam")double estaturaParam,
            @Param("pesoParam")double pesoParam,
            @Param("sexoParam")char sexoParam,
            @Param("provinciaParam")String provinciaParam,
            @Param("cantonParam")String cantonParam,
            @Param("distritoParam")String distritoParam,
            @Param("telefonoParam")String telefonoParam,
            @Param("correoParam")String correoParam
    );
    
    @Query(value = "{call search_procedure(:nombreParam)}", nativeQuery = true)
    List<Atleta> searchProcedure(@Param("nombreParam") String nombreParam);

    @Query(value = "{call update_procedure(:cedulaParam, :pesoParam, :provinciaParam, :cantonParam, :distritoParam, :telefonoParam, :correoParam )}", nativeQuery = true)
    void updateProcedure(
            @Param("cedulaParam")long cedulaParam,   
            @Param("pesoParam")double pesoParam,
            @Param("provinciaParam")String provinciaParam,
            @Param("cantonParam")String cantonParam,
            @Param("distritoParam")String distritoParam,
            @Param("telefonoParam")String telefonoParam,
            @Param("correoParam")String correoParam
    );
    

    
}