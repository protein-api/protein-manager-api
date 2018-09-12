package com.absolem.protein.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by murmu on 23/05/17.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true, value = {"proteina"})
public class Reaccion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String tipo;

    @Column
    private String ec;


    @ManyToOne
    @JoinColumn(name= "proteina_id")
    private Proteina proteina;

    @OneToMany (mappedBy = "reaccion",cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
    private List<Cinetica> cineticas;

    @Column
    private String notes;


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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public Proteina getProteina() {
        return proteina;
    }

    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }

    public List<Cinetica> getCineticas() {
        return cineticas;
    }

    public void setCineticas(List<Cinetica> cineticas) {
        this.cineticas = cineticas;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
