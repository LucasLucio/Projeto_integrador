/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukas
 */
@Entity
@Table(name = "servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicos.findAll", query = "SELECT s FROM Servicos s")
    , @NamedQuery(name = "Servicos.findByIdServicos", query = "SELECT s FROM Servicos s WHERE s.idServicos = :idServicos")
    , @NamedQuery(name = "Servicos.findByNome", query = "SELECT s FROM Servicos s WHERE s.nome = :nome")
    , @NamedQuery(name = "Servicos.findByPreco", query = "SELECT s FROM Servicos s WHERE s.preco = :preco")})
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicos")
    private Integer idServicos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private float preco;

    public Servicos() {
    }

    public Servicos(Integer idServicos) {
        this.idServicos = idServicos;
    }

    public Servicos(Integer idServicos, String nome, float preco) {
        this.idServicos = idServicos;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(Integer idServicos) {
        this.idServicos = idServicos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicos != null ? idServicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicos)) {
            return false;
        }
        Servicos other = (Servicos) object;
        if ((this.idServicos == null && other.idServicos != null) || (this.idServicos != null && !this.idServicos.equals(other.idServicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idServicos + ";" + nome + ";" + preco;
    }

}
