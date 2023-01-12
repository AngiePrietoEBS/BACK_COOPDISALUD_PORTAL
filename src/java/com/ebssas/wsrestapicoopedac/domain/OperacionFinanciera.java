/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "OPERACION_FINANCIERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionFinanciera.findAll", query = "SELECT o FROM OperacionFinanciera o"),
    @NamedQuery(name = "OperacionFinanciera.findByICodigo", query = "SELECT o FROM OperacionFinanciera o WHERE o.iCodigo = :iCodigo"),
    @NamedQuery(name = "OperacionFinanciera.findByNSalario", query = "SELECT o FROM OperacionFinanciera o WHERE o.nSalario = :nSalario")})
public class OperacionFinanciera implements Serializable {

    @Column(name = "N_SALARIO")
    private Long nSalario;
    @Column(name = "N_OTROS_INGRESOS")
    private Long nOtrosIngresos;
    @Size(max = 255)
    @Column(name = "C_CONCEPTO_OTROS_INGRESOS")
    private String cConceptoOtrosIngresos;
    @Column(name = "N_TOTAL_ACTIVOS")
    private Long nTotalActivos;
    @Column(name = "N_GASTOS_LABORALES")
    private Long nGastosLaborales;
    @Column(name = "N_GASTOS_FAMILIARES")
    private Long nGastosFamiliares;
    @Column(name = "N_TOTAL_PASIVOS")
    private Long nTotalPasivos;
    @Column(name = "N_DESCUENTOS_LABORALES")
    private Long nDescuentosLaborales;
    @Column(name = "N_GASTOS_FINANCIEROS_CIFIN")
    private Long nGastosFinancierosCifin;
    @Column(name = "N_GASTOS_FINANCIEROS")
    private Long nGastosFinancieros;
    @Column(name = "N_VALOR_INGRESOS")
    private Long nValorIngresos;
    @Column(name = "N_VALOR_EGRESOS")
    private Long nValorEgresos;
    @Column(name = "N_VALOR_ACTIVOS")
    private Long nValorActivos;
    @Column(name = "N_VALOR_PASIVOS")
    private Long nValorPasivos;
    @Column(name = "N_VALOR_OTROS_INGRESOS")
    private Long nValorOtrosIngresos;
    @Column(name = "N_VALOR_GASTOS")
    private Long nValorGastos;
    @Size(max = 2000)
    @Column(name = "C_CONCEPTO_OTROS")
    private String cConceptoOtros;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_OPER_FINANCIERA", sequenceName = "SEC_OPER_FINANCIERA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_OPER_FINANCIERA")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;

    public OperacionFinanciera() {
    }

    public OperacionFinanciera(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getNSalario() {
        return nSalario;
    }

    public void setNSalario(Long nSalario) {
        this.nSalario = nSalario;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
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
        if (!(object instanceof OperacionFinanciera)) {
            return false;
        }
        OperacionFinanciera other = (OperacionFinanciera) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OperacionFinanciera{" + "nSalario=" + nSalario + ", iPersona=" + iPersona + '}';
    }

    public Long getNValorIngresos() {
        return nValorIngresos;
    }

    public void setNValorIngresos(Long nValorIngresos) {
        this.nValorIngresos = nValorIngresos;
    }

    public Long getNValorEgresos() {
        return nValorEgresos;
    }

    public void setNValorEgresos(Long nValorEgresos) {
        this.nValorEgresos = nValorEgresos;
    }

    public Long getNValorActivos() {
        return nValorActivos;
    }

    public void setNValorActivos(Long nValorActivos) {
        this.nValorActivos = nValorActivos;
    }

    public Long getNValorPasivos() {
        return nValorPasivos;
    }

    public void setNValorPasivos(Long nValorPasivos) {
        this.nValorPasivos = nValorPasivos;
    }

    public Long getNValorOtrosIngresos() {
        return nValorOtrosIngresos;
    }

    public void setNValorOtrosIngresos(Long nValorOtrosIngresos) {
        this.nValorOtrosIngresos = nValorOtrosIngresos;
    }

    public Long getNValorGastos() {
        return nValorGastos;
    }

    public void setNValorGastos(Long nValorGastos) {
        this.nValorGastos = nValorGastos;
    }

    public String getCConceptoOtros() {
        return cConceptoOtros;
    }

    public void setCConceptoOtros(String cConceptoOtros) {
        this.cConceptoOtros = cConceptoOtros;
    }

    public Long getNOtrosIngresos() {
        return nOtrosIngresos;
    }

    public void setNOtrosIngresos(Long nOtrosIngresos) {
        this.nOtrosIngresos = nOtrosIngresos;
    }

    public String getCConceptoOtrosIngresos() {
        return cConceptoOtrosIngresos;
    }

    public void setCConceptoOtrosIngresos(String cConceptoOtrosIngresos) {
        this.cConceptoOtrosIngresos = cConceptoOtrosIngresos;
    }

    public Long getNTotalActivos() {
        return nTotalActivos;
    }

    public void setNTotalActivos(Long nTotalActivos) {
        this.nTotalActivos = nTotalActivos;
    }

    public Long getNGastosLaborales() {
        return nGastosLaborales;
    }

    public void setNGastosLaborales(Long nGastosLaborales) {
        this.nGastosLaborales = nGastosLaborales;
    }

    public Long getNGastosFamiliares() {
        return nGastosFamiliares;
    }

    public void setNGastosFamiliares(Long nGastosFamiliares) {
        this.nGastosFamiliares = nGastosFamiliares;
    }

    public Long getNTotalPasivos() {
        return nTotalPasivos;
    }

    public void setNTotalPasivos(Long nTotalPasivos) {
        this.nTotalPasivos = nTotalPasivos;
    }

    public Long getNDescuentosLaborales() {
        return nDescuentosLaborales;
    }

    public void setNDescuentosLaborales(Long nDescuentosLaborales) {
        this.nDescuentosLaborales = nDescuentosLaborales;
    }

    public Long getNGastosFinancierosCifin() {
        return nGastosFinancierosCifin;
    }

    public void setNGastosFinancierosCifin(Long nGastosFinancierosCifin) {
        this.nGastosFinancierosCifin = nGastosFinancierosCifin;
    }

    public Long getNGastosFinancieros() {
        return nGastosFinancieros;
    }

    public void setNGastosFinancieros(Long nGastosFinancieros) {
        this.nGastosFinancieros = nGastosFinancieros;
    }
    
    
}
