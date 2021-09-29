/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Gui
 */
public class Login {
    
    private int id;
    private String usuario;
    private String senha;
    // private String situacao;
    //private String funcionario_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // public String getSituacao() {
    //     return situacao;
    // }

    // public void setSituacao(String situacao) {
    //     this.situacao = situacao;
    // }

    /*public String getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(String funcionario_id) {
        this.funcionario_id = funcionario_id;
    }*/
}

   