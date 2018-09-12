package com.absolem.protein.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by murmu on 13/07/17.
 */
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"reaccion"})
public class Cinetica {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional=false)
    @JoinColumn(name="MOLECULA_ID",  nullable=false)
    private Molecula molecula;
    @Column
    private String km;
    @Column
    private String kcat;
    @Column
    private String kmKcat;
    @ManyToOne
    @JoinColumn(name= "reaccion_id")
    private Reaccion reaccion;

    @Column
    private TipoCinetica tipo;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="moleculas_similares", joinColumns=@JoinColumn(name="cinetica_id"), inverseJoinColumns=@JoinColumn(name="molecula_id"))
    private List<Molecula> moleculasSimilares;

    @Column(name= "parejita_id")
    private Long parejitaId;

    @Column(name= "proteina_id")
    private Long proteinaId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getKcat() {
        return kcat;
    }

    public void setKcat(String kcat) {
        this.kcat = kcat;
    }

    public String getKmKcat() {
        return kmKcat;
    }

    public void setKmKcat(String kmKcat) {
        this.kmKcat = kmKcat;
    }

    public Reaccion getReaccion() {
        return reaccion;
    }

    public void setReaccion(Reaccion reaccion) {
        this.reaccion = reaccion;
    }

    public Molecula getMolecula() {
        return molecula;
    }

    public void setMolecula(Molecula molecula) {
        this.molecula = molecula;
    }

    public TipoCinetica getTipo() {
        return tipo;
    }

    public void setTipo(TipoCinetica tipo) {
        this.tipo = tipo;
    }

    public List<Molecula> getMoleculasSimilares() {
        return moleculasSimilares;
    }

    public void setMoleculasSimilares(List<Molecula> moleculasSimilares) {
        this.moleculasSimilares = moleculasSimilares;
    }

    public Long getParejitaId() {
        return parejitaId;
    }

    public void setParejitaId(Long parejitaId) {
        this.parejitaId = parejitaId;
    }

    public Long getProteinaId() {
        return proteinaId;
    }

    public void setProteinaId(Long proteinaId) {
        this.proteinaId = proteinaId;
    }
}
