package com.absolem.protein.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by murmu on 10/06/17.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true, value = {"proteina"})
public class Enlace {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String codigo;
    @Column
    private String link;

    @Column
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "proteina_id")
    private Proteina proteina;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Proteina getProteina() {
        return proteina;
    }

    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
