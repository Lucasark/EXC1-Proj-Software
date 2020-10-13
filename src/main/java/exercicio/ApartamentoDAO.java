package exercicio;

import java.util.List;


public interface ApartamentoDAO {
    long inclui(Apartamento umApartamento);

//    void altera(Produto umProduto)
//            throws ProdutoNaoEncontradoException;
//
    void exclui(long id)
            throws AptNaoEncontradoException;

    Apartamento recuperaUmApartamento(long numero)
            throws AptNaoEncontradoException;

    List<Apartamento> recuperaApts();
}