package com.absolem.protein.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true, value = {"proteina"})
public class SitioActivo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024)
    private String valor;
    @Column
    private  TipoSitioActivo tipo;
    @ManyToOne
    @JoinColumn(name= "proteina_id")
    private Proteina proteina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoSitioActivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoSitioActivo tipo) {
        this.tipo = tipo;
    }

    public Proteina getProteina() {
        return proteina;
    }

    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }
}
