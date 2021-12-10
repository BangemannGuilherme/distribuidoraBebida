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
import javax.persistence.Table;

/**
 *
 * @author Gui
 */
@Entity
@Table(name = "tipo_produto")
public class TipoProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_produto")
    private Integer id_tipo_produto;
    @Column(name = "marca")
    private String marca;
    @Column(name = "recipiente")
    private String recipiente;
    @Column(name = "volume")
    private String volume;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "situacao")
    private Character situacao;
 
    public int getId_tipo_produto() {
        return id_tipo_produto;
    }

    public void setId_tipo_produto(int id_tipo_produto) {
        this.id_tipo_produto = id_tipo_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
     public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }
    
     public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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
    
}
