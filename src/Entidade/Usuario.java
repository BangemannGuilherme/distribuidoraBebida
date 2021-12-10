/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gui
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "dt_criacao")
    private Date dt_criacao;
    @Column(name = "dt_alteracao_senha")
    private Date dt_alteracao_senha;
    @Column(name = "situacao")
    private Character situacao;
    @Column(name = "id_funcionario")
    private Integer id_funcionario;
    @Column(name = "permissao")
    private Integer permissao;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_alteracao_senha() {
        return dt_alteracao_senha;
    }

    public void setDt_alteracao_senha(Date dt_alteracao_senha) {
        this.dt_alteracao_senha = dt_alteracao_senha;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return this.login;
    }

    public Integer getPermissao() {
        return permissao;
    }

    public void setPermissao(Integer permissao) {
        this.permissao = permissao;
    }

}
