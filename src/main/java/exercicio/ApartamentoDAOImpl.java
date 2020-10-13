package exercicio;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

public class ApartamentoDAOImpl implements ApartamentoDAO {
    public long inclui(Apartamento umApartamento) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {

            em = FabricaDeEntityManager.criarSessao();
            tx = em.getTransaction();
            tx.begin();
            System.out.print(umApartamento);
            em.persist(umApartamento);

            tx.commit();
            return umApartamento.getId();
        } catch (RuntimeException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (RuntimeException he) {
                }
            }
            throw e;
        } finally {
            em.close();
        }
    }

    //    public void altera(Produto umProduto) throws ProdutoNaoEncontradoException
//    {	EntityManager em = null;
//        EntityTransaction tx = null;
//        Produto produto = null;
//        try
//        {
//            em = FabricaDeEntityManager.criarSessao();
//            tx = em.getTransaction();
//            tx.begin();
//
//            produto = em.find(Produto.class, umProduto.getId(), LockModeType.PESSIMISTIC_WRITE);
//
//            if(produto == null)
//            {	tx.rollback();
//                throw new ProdutoNaoEncontradoException("Produto n?o encontrado");
//            }
//            em.merge(umProduto);
//            tx.commit();
//        }
//        catch(OptimisticLockException e)  // sub-classe de RuntimeException
//        {
//            if (tx != null)
//            {   tx.rollback();
//            }
//            throw new EstadoDeObjetoObsoletoException();
//        }
//        catch(RuntimeException e)
//        {
//            if (tx != null)
//            {   try
//            {   tx.rollback();
//            }
//            catch(RuntimeException he)
//            { }
//            }
//            throw e;
//        }
//        finally
//        {   em.close();
//        }
//    }
//
    public void exclui(long numero) throws AptNaoEncontradoException {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = FabricaDeEntityManager.criarSessao();
            tx = em.getTransaction();
            tx.begin();

            Apartamento produto = em.find(Apartamento.class, numero, LockModeType.PESSIMISTIC_WRITE);

            if (produto == null) {
                tx.rollback();
                throw new AptNaoEncontradoException("Produto não encontrado");
            }

            em.remove(produto);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (RuntimeException he) {
                }
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Apartamento recuperaUmApartamento(long numero) throws AptNaoEncontradoException {
        EntityManager em = null;

        try {
            em = FabricaDeEntityManager.criarSessao();

            Apartamento umApartamento = em.find(Apartamento.class, numero);

            if (umApartamento == null) {
                throw new AptNaoEncontradoException("Produto não encontrado");
            }
            return umApartamento;
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Apartamento> recuperaApts() {
        EntityManager em = null;

        try {
            em = FabricaDeEntityManager.criarSessao();

            List<Apartamento> apartamentos = em
                    .createQuery("select a from Apartamento a order by a.id")
                    .getResultList();

            return apartamentos;
        } finally {
            em.close();
        }
    }
}