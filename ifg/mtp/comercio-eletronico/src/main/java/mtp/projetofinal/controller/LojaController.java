package mtp.projetofinal.controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import mtp.projetofinal.model.Endereco;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Create;
import mtp.projetofinal.model.crud.Delete;
import mtp.projetofinal.model.crud.Update;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.utils.Msg;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author luiz
 */
public class LojaController {

    private Usuario usuario;

    /**
     * Com base no e-mail do usuário recebido, envia para a model atualizá-lo.
     *
     * @param usuario um usuário com nome ou senha modificado
     * @return true - deu certo<br>false - deu errado
     */
    public Boolean alterarDados(Usuario usuario) {

        Update u = new Update();

        u.atualizar(usuario, "email", usuario.getEmail());

        if (u.getResult()) {
            Read r = new Read();
            r.ler(usuario, "email", usuario.getEmail());
            this.usuario = (Usuario) r.getResult().get(0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna o usuário atualizado
     *
     * @return o usuário atualizado
     */
    public Usuario getUsuarioAtualizado() {
        return this.usuario;
    }

    /**
     * Cria um novo endereço para o usuário modificar e salvar depois
     *
     * @param user Em quem será adicionado o novo endereço
     * @return true deu certo<br> false deu errado
     */
    public static Boolean adicionarEndereco(Usuario user) {

        Create c = new Create();

        Endereco e = new Endereco();

        e.setIdusuario(user.getId());
        e.setIdentificador("novo endereço");
        e.setEstado("");
        e.setCidade("");
        e.setBairro("");
        e.setRua("");
        e.setNumero("");
        e.setComplemento("");

        c.inserir(e);

        return c.getResult();
    }

    public static Boolean enderecoJaFoiUsado(Endereco e) {
        Read r = new Read();
        
        r.ler(new Pedido(), "idendereco", e.getId());
        
        return !r.getResult().isEmpty();
    }
    
    /**
     * Permite fazer alterações em um endereço do usuário caso ele ainda não
     * tenha nenhum pedido vinculado.
     *
     * @param user usuário dono do endereço
     * @param e endereço a ser atualizado
     * @return true deu certo<br> false deu errado
     */
    public Boolean salvarEndereco(Usuario user, Endereco e) {

        if (enderecoJaFoiUsado(e)) {
            Msg.exibirMensagem("Não foi possível editar este endereço pois ele já foi utilizado em algum pedido.", "Aviso", 2);
            return false;
        }

        Update u = new Update();

        u.atualizar(e, new Object[][]{{"id", e.getId()}, {"idusuario", user.getId()}});

        return u.getResult();
    }

    /**
     * Apaga um endereço caso o mesmo não tenha nenhum pedido relacionado a ele
     *
     * @param e o endereço a ser excluido
     * @return true deu certo<br>false deu errado
     */
    public Boolean excluirEndereco(Endereco e) {

        if (enderecoJaFoiUsado(e)) {
            Msg.exibirMensagem("Não foi possível excluir este endereço pois ele já foi utilizado em algum pedido.", "Aviso", 2);
            return false;
        }

        Delete d = new Delete();

        d.apagar(e, new Object[][]{{"id", e.getId()}});

        return true;
    }

    /**
     * Te dá uma lista de produtos
     *
     * @param pagina qual página será buscada
     * @param qtd quantos produtos terá na lista
     * @return a lista contendo a qtd de produtos desejada
     */
    public static ArrayList<Produto> getProdutos(int pagina, int qtd) {
        Read r = new Read();
        r.ler(new Produto(), pagina, qtd);

        ArrayList<Produto> produtos = new ArrayList<>();

        for (Object obj : r.getResult()) {
            Produto p = (Produto) obj;
            produtos.add(p);

        }
        return produtos;
    }

    /**
     * Busca quantos produtos existem
     *
     * @return a quantidade de produtos existentes no banco de dados
     */
    public static int getCountProdutos() {
        Read r = new Read();
        return r.ler(new Produto());
    }

    /**
     * Cadastra um novo produto no banco de dados com base nas informações
     * passadas pela view
     *
     * @param produto o produto a ser cadastrado
     * @return true cadastrou com sucesso <br> false falha ao cadastrar
     */
    public Boolean novoProduto(Produto produto) {
        Create c = new Create();

        c.inserir(produto);

        return c.getResult();
    }

    /**
     * Salva a foto no diretório produtos/
     *
     * @param arquivo foto a ser salva
     * @return O nome da foto no diretório para ser localizada futuramente
     */
    public String salvarFoto(File arquivo) {

        String nomeFoto = null;

        try {

            BufferedImage imagem = ImageIO.read(arquivo);
            BufferedImage imagemRedimensionada = redimensionarImagemProporcional(imagem, 180, 155);

            File diretorioProdutos = new File("produtos/");

            if (!diretorioProdutos.exists()) {
                diretorioProdutos.mkdir();
            }

            nomeFoto = RandomStringUtils.random(100, true, true) + ".jpg";

            String caminhoDestino = "produtos/" + nomeFoto;

            File novaImagem = new File(caminhoDestino);

            ImageIO.write(imagemRedimensionada, "jpg", novaImagem);

        } catch (IOException | NullPointerException ex) {
            Msg.exibirMensagem("Não foi possível utilizar esta imagem, tente outra.", "Erro", 0);
            nomeFoto = null;
        } catch (IllegalArgumentException e) {
            Msg.exibirMensagem("Não foi possível identificar o tipo dessa imagem.", "Erro", 0);
            nomeFoto = null;
        }

        return nomeFoto;
    }

    /**
     * Altera as dimensões da imagem para ela caber dentro dos Panels de produto
     *
     * @param imagem Imagem a ser modificada
     * @param larguraMaxima
     * @param alturaMaxima
     * @return a imagem modificada
     */
    public static BufferedImage redimensionarImagemProporcional(BufferedImage imagem, int larguraMaxima, int alturaMaxima) {
        int larguraOriginal = imagem.getWidth();
        int alturaOriginal = imagem.getHeight();

        // Calcular as novas dimensões mantendo a proporção
        double proporcaoLargura = (double) larguraMaxima / larguraOriginal;
        double proporcaoAltura = (double) alturaMaxima / alturaOriginal;
        double proporcao = Math.min(proporcaoLargura, proporcaoAltura);

        // Calcular a nova largura e altura
        int novaLargura = (int) (larguraOriginal * proporcao);
        int novaAltura = (int) (alturaOriginal * proporcao);

        // Criar a imagem redimensionada
        BufferedImage imagemRedimensionada = new BufferedImage(novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagemRedimensionada.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(imagem, 0, 0, novaLargura, novaAltura, null);
        g2d.dispose();

        return imagemRedimensionada;
    }
}
