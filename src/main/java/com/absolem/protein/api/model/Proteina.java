package com.absolem.protein.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by murmu on 22/05/17.
 */
@Entity
@Table
public class Proteina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigoUniProt;

    @Column
    private String nombre;

    @Column(length = 1024)
    private String secuencia;

    @Column
    private String organismo;

    @Column
    private String familia;

    @Column
    private String codigoKegg;

    @OneToMany (mappedBy = "proteina",cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
    private List<Enlace> dois;

    @OneToMany (mappedBy = "proteina",cascade ={ CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
    private List<Reaccion> reacciones;

    @OneToMany (mappedBy = "proteina",cascade ={ CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
    private List<EstructuraPDB> estructurasPDB;

    @OneToOne (mappedBy = "proteina",cascade ={ CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },fetch = FetchType.LAZY)
    private SitioActivo sitiosActivo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoUniProt() {
        return codigoUniProt;
    }

    public void setCodigoUniProt(String codigoUniProt) {
        this.codigoUniProt = codigoUniProt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getOrganismo() {
        return organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getCodigoKegg() {
        return codigoKegg;
    }

    public void setCodigoKegg(String codigoKegg) {
        this.codigoKegg = codigoKegg;
    }


    public List<Reaccion> getReacciones() {
        return reacciones;
    }

    public void setReacciones(List<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }

    public List<Enlace> getDois() {
        return dois;
    }

    public void setDois(List<Enlace> dois) {
        this.dois = dois;
    }

    public List<EstructuraPDB> getEstructurasPDB() {
            return estructurasPDB;
    }

    public void setEstructurasPDB(List<EstructuraPDB> estructurasPDB) {
        this.estructurasPDB = estructurasPDB;
    }

    public SitioActivo getSitiosActivo() {
        return sitiosActivo;
    }

    public void setSitiosActivo(SitioActivo sitiosActivo) {
        this.sitiosActivo = sitiosActivo;
    }
}
