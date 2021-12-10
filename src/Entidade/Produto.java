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
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "situacao")
    private Character situacao;
    @JoinColumn(name = "id_tipo_produto", referencedColumnName = "id_tipo_produto")
    @ManyToOne(optional = false)
    private TipoProduto id_tipo_produto;
 
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
    
    public TipoProduto getId_tipo_produto() {
        return id_tipo_produto;
    }

    public void setId_tipo_produto(TipoProduto id_tipo_produto) {
        this.id_tipo_produto = id_tipo_produto;
    }
    
}
