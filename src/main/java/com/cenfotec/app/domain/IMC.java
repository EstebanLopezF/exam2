package com.cenfotec.app.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IMC {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long idAtleta;
    private double indice;
    private LocalDate fechaToma;
    
    public IMC(){
    }
    
    public IMC(long idAtleta, double peso, double estatura){
    	this.idAtleta=idAtleta;
    	this.indice=calculateIMC(peso, estatura);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
    }
    
    public double getIindice() {
        return indice;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }
    
    public LocalDate getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(LocalDate fechaToma) {
        this.fechaToma = fechaToma;
    }
    
    private double calculateIMC(double peso, double estatura) {
    	return peso/(estatura*estatura);
    }
    
}
