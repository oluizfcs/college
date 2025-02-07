package mtp.projetofinal.model;

import java.util.ArrayList;
import mtp.projetofinal.model.crud.Read;

/**
 *
 * @author luiz
 */
public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Boolean admin;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     *
     * @return todos os endereços do usuário
     */
    public ArrayList<Endereco> enderecos() {

        ArrayList<Endereco> enderecos = new ArrayList<>();

        Read r = new Read();

        r.ler(new Endereco(), "idusuario", getId());

        for (Object obj : r.getResult()) {

            Endereco e = (Endereco) obj;

            enderecos.add(e);
        }

        return enderecos;
    }

    public Integer pegarIdCarrinho() {
        Read r = new Read();

        r.ler(new Pedido(), new Object[][]{{"idusuario", getId()}, {"idstatus", 1}});

        if (!r.getResult().isEmpty()) {
            Pedido p = (Pedido) r.getResult().get(0);
            return p.getId();
        } else {
            return null;
        }
    }
}
