package exercicio;

import java.util.List;


public interface ApartamentoDAO {
    long inclui(Apartamento umApartamento);

    void altera(Apartamento umApartamento)
            throws AptNaoEncontradoException;

    void exclui(long id)
            throws AptNaoEncontradoException;

    Apartamento recuperaUmApartamento(long numero)
            throws AptNaoEncontradoException;

    List<Apartamento> recuperaApts();
}