/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author BrayanFSilvaR
 */
@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Column(name = "C_PAIS")
    private String cPais;

    @Column(name = "I_INDICATIVO")
    private Long iIndicativo;

    @Column(name = "I_COD_PAIS_DECEVAL")
    private Long iCodPaisDeceval;

    
    
    
    public Pais() {
    }

        
    public Pais(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getcPais() {
        return cPais;
    }

    public void setcPais(String cPais) {
        this.cPais = cPais;
    }

    public Long getiIndicativo() {
        return iIndicativo;
    }

    public void setiIndicativo(Long iIndicativo) {
        this.iIndicativo = iIndicativo;
    }

    public Long getiCodPaisDeceval() {
        return iCodPaisDeceval;
    }

    public void setiCodPaisDeceval(Long iCodPaisDeceval) {
        this.iCodPaisDeceval = iCodPaisDeceval;
    }

@Override
    public int hashCode() {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.Pais[ iCodigo=" + iCodigo + " ]";
    }
    
    
    
    

}
