package com.absolem.protein.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by murmu on 16/07/17.
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true, value = {"proteina"})
public class EstructuraPDB {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column(length = 2500)
    private String url;

    @ManyToOne
    @JoinColumn(name= "proteina_id")
    private Proteina proteina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
