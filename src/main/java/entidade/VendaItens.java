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
public class VendaItens {
    private int cod;
    private int produto_cod;
    private int venda_cod;
    private int quantidade;
    private float valor_venda;
    
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getProduto_cod() {
        return produto_cod;
    }

    public void setProduto_cod(int produto_cod) {
        this.produto_cod = produto_cod;
    }

    public int getVenda_cod() {
        return venda_cod;
    }

    public void setVenda_cod(int venda_cod) {
        this.venda_cod = venda_cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }   
}
