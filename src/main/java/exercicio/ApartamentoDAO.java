package exercicio;

import java.util.List;


public interface ApartamentoDAO {
    long inclui(Apartamento umApartamento);

//    void altera(Produto umProduto)
//            throws ProdutoNaoEncontradoException;
//
//    void exclui(long id)
//            throws ProdutoNaoEncontradoException;
//
//    Produto recuperaUmProduto(long numero)
//            throws ProdutoNaoEncontradoException;
//
    List<Apartamento> recuperaApts();
}