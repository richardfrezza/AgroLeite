package com.richard.agroleite.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gastos")
public class Gasto implements Serializable, Entidade {

    @Id
    @Column(name = "id_gastos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ds_produto", length = 200, nullable = false)
    private String descricao;
    @Column(name = "vl_preco", precision = 15, scale = 5, nullable = false)
    private BigDecimal preco;
    @Column(name = "qt_utilizada", precision = 15, scale = 5, nullable = false)
    private BigDecimal quantidade;
    @ManyToOne
    @JoinColumn(name = "id_vaca")
    private Vaca vaca;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Vaca getVaca() {
        return vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.preco);
        hash = 17 * hash + Objects.hashCode(this.vaca);
        return 17 * hash + Objects.hashCode(this.quantidade);
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
        final Gasto other = (Gasto) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        if (!Objects.equals(this.vaca, other.vaca)) {
            return false;
        }
        return Objects.equals(this.quantidade, other.quantidade);
    }
    
    
}
