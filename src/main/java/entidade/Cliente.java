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
public class Cliente {
    
    private int cod;
    private String razaosocial;
    private String cnpj;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

}
