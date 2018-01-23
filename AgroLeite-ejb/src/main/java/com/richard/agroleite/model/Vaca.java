package com.richard.agroleite.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vacas")
public class Vaca implements Serializable, Entidade {
    @Id
    @Column(name = "id_vaca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nm_vaca", length = 80, nullable = false)
    private String nome;
    @Column(name = "nr_brinco", length = 20, nullable = false)
    private String brinco;
    @Column(name = "nr_crias", length = 5)
    private Integer crias;
    @Column(name = "raca", length = 300)
    private String raca;
    @Column(name = "dt_nascimento",  nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBrinco() {
        return brinco;
    }

    public void setBrinco(String brinco) {
        this.brinco = brinco;
    }

    public Integer getCrias() {
        return crias;
    }

    public void setCrias(Integer crias) {
        this.crias = crias;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.brinco);
        hash = 41 * hash + Objects.hashCode(this.crias);
        hash = 41 * hash + Objects.hashCode(this.raca);
        return 41 * hash + Objects.hashCode(this.dtNascimento);
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
        final Vaca other = (Vaca) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.brinco, other.brinco)) {
            return false;
        }
        if (!Objects.equals(this.crias, other.crias)) {
            return false;
        }
        if (!Objects.equals(this.dtNascimento, other.dtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
