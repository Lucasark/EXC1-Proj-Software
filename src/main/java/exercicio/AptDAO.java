package exercicio;

import java.util.List;


public interface AptDAO {
    long inclui(Apt umApt);

//    void altera(Produto umProduto)
//            throws ProdutoNaoEncontradoException;
//
//    void exclui(long id)
//            throws ProdutoNaoEncontradoException;
//
//    Produto recuperaUmProduto(long numero)
//            throws ProdutoNaoEncontradoException;
//
    List<Apt> recuperaApts();
}