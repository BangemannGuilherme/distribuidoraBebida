/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Utils.Calendario;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gui
 */
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer id_funcionario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "dt_nascimento")
    private Date dt_nascimento;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "situacao")
    private Character situacao;    
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @OneToOne
    private Entidade id_entidade;    

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dt_nascimento);
            this.dt_nascimento = date;
        } catch (ParseException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    
    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Entidade getId_entidade() {
        return id_entidade;
    }

    public void setId_entidade(Entidade id_entidade) {
        this.id_entidade = id_entidade;
    }   

}