package com.richard.agroleite.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ordenha")
public class Ordenha implements Serializable, Entidade {

    @Id
    @Column(name = "id_ordenha")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cd_ordenha", unique = true)
    private String codigo;
    @Column(name = "dt_ordenha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtOrdenha;
    @Column(name = "nr_litros", length = 5)
    private Integer litros;
    @Column(name = "observacao")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_vaca", nullable=false)
    private Vaca vaca;
    
    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Vaca getVaca() {
        return vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }
    
    @Override
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

    public Date getDtOrdenha() {
        return dtOrdenha;
    }

    public void setDtOrdenha(Date dtOrdenha) {
        this.dtOrdenha = dtOrdenha;
    }

      
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.dtOrdenha);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + Objects.hashCode(this.vaca);
        return 97 * hash + Objects.hashCode(this.litros);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordenha other = (Ordenha) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dtOrdenha, other.dtOrdenha)) {
            return false;
        }
        if (!Objects.equals(this.litros, other.litros)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return Objects.equals(this.vaca, other.vaca);
    }
    
}
