/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.model.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Funcionario
 */
@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(table = "idPessoa",nullable = false)
    private Integer idPessoa;
    
    @Column(name = "nome",nullable = false,length = 80)
    private String nome;
   
    @Column(name = "email",nullable = false,length = 80)
    private String email;
    @Column(name = "telefone",nullable = false,length = 15)
    private String telefone;
    @Column(name = "cpf",nullable = false,length = 14)
    private String cpf;
    @Column(name = "dataDeNascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name = "dataDeCadastro",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

   

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
}
