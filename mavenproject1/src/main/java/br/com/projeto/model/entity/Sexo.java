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
import javax.persistence.FetchType;
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
@Table(name = "Sexo")
public class Sexo implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "idSexo",nullable = false)
    private Integer idSexo;
    
    @Column(name = "descrica",unique = true,length = 9)
    private String decricao;
    
    @OneToMany(mappedBy = "sexo",fetch =FetchType.LAZY)
    @ForeignKey(name = "PessoaSexo")
    private List<Pessoa> pessoas;


    public Sexo(){
    }
    

    public Integer getIdSexo() {
        return idSexo;
    }

    public String getDecricao() {
        return decricao;
    }
    
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
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
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }
    
    
    
}
