/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gui
 */
@Entity
@Table(name = "entidade")
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidade")
    private Integer id_entidade;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "situacao")
    private Character situacao;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne(optional = false)
    private Cidade id_cidade;

    public Integer getId_entidade() {
        return id_entidade;
    }

    public void setId_entidade(Integer id_entidade) {
        this.id_entidade = id_entidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situaca0) {
        this.situacao = situaca0;
    }

    public Integer getUsuarioCadastro() {
        return id_usuario_cadastro;
    }

    public void setUsuarioCadastro(Integer id_usuario_cadastro) {
        this.id_usuario_cadastro = id_usuario_cadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Cidade id_cidade) {
        this.id_cidade = id_cidade;
    }
    
}