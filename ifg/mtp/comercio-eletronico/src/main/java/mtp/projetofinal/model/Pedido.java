package mtp.projetofinal.model;

import java.math.BigDecimal;

/**
 *
 * @author luiz
 */
public class Pedido {
    
    private Integer id;
    private Integer idusuario;
    private Integer idendereco;
    private BigDecimal valortotal;
    private Integer idstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(Integer idendereco) {
        this.idendereco = idendereco;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }
}
