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
public class Fornecedor {
    
    private int id;
    private String razaosocial;
    private String cnpj;
    private String telefone;
    private String email;
    // private String situacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public String getRazaoSocial() {
        return razaosocial;
    }

    public void setRazaoSocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // public String getSituacao() {
    //     return situacao;
    // }

    // public void setSituacao(String situacao) {
    //     this.situacao = situacao;
    // }
}
