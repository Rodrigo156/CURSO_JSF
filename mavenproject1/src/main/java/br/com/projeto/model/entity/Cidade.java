/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Funcionario
 */

@Entity
@Table(name = "Cidade")
public class Cidade implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "idCidade",nullable = false)
    private Integer idCidade;
    @Column(name = "nome",nullable = false,length = 80)
    private String nome;
    
    @OneToMany
    @ForeignKey(name = "CidadeEndereco")
    private List<Endereco> enderecos;

    public Cidade() {
    }
    
    
    public Integer getIdCidade() {
        return idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    
     
     
     
     
    
}
