package Entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "venda_produto")
public class VendaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda_produto")
    private Integer id_venda_produto;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "vl_venda")
    private Double vl_venda;
    @JoinColumn(name = "id_venda", referencedColumnName = "id_venda")
    @ManyToOne(optional = false)
    private Venda id_venda;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto id_produto;

    public Integer getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(Integer id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Double getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(Double vl_venda) {
        this.vl_venda = vl_venda;
    }

    public Venda getId_venda() {
        return id_venda;
    }

    public void setId_venda(Venda id_venda) {
        this.id_venda = id_venda;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id_venda);
        hash = 17 * hash + Objects.hashCode(this.id_produto);
        hash = 17 * hash + Objects.hashCode(this.quantidade);
        hash = 17 * hash + Objects.hashCode(this.vl_venda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaProduto other = (VendaProduto) obj;
        if (!Objects.equals(this.id_venda, other.id_venda)) {
            return false;
        }
        if (!Objects.equals(this.id_produto, other.id_produto)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.vl_venda, other.vl_venda)) {
            return false;
        }
        return true;
    }
}
