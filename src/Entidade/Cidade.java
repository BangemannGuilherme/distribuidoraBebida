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

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Integer id_cidade;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "situacao")
    private Character situacao;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado id_estado;

    public Integer getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getId_usuario_cadastro() {
        return id_usuario_cadastro;
    }

    public void setId_usuario_cadastro(Integer id_usuario_cadastro) {
        this.id_usuario_cadastro = id_usuario_cadastro;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Estado getId_estado() {
        return id_estado;
    }

    public void setId_estado(Estado id_estado) {
        this.id_estado = id_estado;
    }

}
