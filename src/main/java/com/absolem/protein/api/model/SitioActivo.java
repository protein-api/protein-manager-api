package com.absolem.protein.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sitios_activos")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"proteina"})
public class SitioActivo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "proteina_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Sitio_act_can", length = 1024)
    private String sitiosActCan;

    @Column(name = "Sitio_act_prom", length = 1024)
    private String sitiosActProm;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Proteina proteina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proteina getProteina() {
        return proteina;
    }

    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }

    public String getSitiosActCan() {
        return sitiosActCan;
    }

    public void setSitiosActCan(String sitiosActCan) {
        this.sitiosActCan = sitiosActCan;
    }

    public String getSitiosActProm() {
        return sitiosActProm;
    }

    public void setSitiosActProm(String sitiosActProm) {
        this.sitiosActProm = sitiosActProm;
    }
}
