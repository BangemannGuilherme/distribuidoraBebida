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
public class Venda {
    
    private int cod;
    private String data_venda;
    private char status;
    private String pessoa_cod;
    private String cliente_cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getPessoa_cod() {
        return pessoa_cod;
    }

    public void setPessoa_cod(String pessoa_cod) {
        this.pessoa_cod = pessoa_cod;
    }

    public String getCliente_cod() {
        return cliente_cod;
    }

    public void setCliente_cod(String cliente_cod) {
        this.cliente_cod = cliente_cod;
    }
}

   