package exercicio;


import java.util.List;

import corejava.Console;

public class Principal {
    public static void main(String[] args) {
        String numero;
        String bloco;
        String andar;
        Apartamento umApartamento;

        ApartamentoDAO apartamentoDAO = FabricaDeDAOs.getDAO(ApartamentoDAO.class);

        boolean continua = true;
        while (continua) {
            System.out.println('\n' + "O que voc� deseja fazer?");
            System.out.println('\n' + "1. Cadastrar um Apartamento");
            System.out.println("2. Alterar um Apartamento");
            System.out.println("3. Remover um Apartamento");
            System.out.println("4. Listar todos os Apartamento");
            System.out.println("5. Sair");

            int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 5:");

            switch (opcao) {
                case 1: {
                    numero = Console.readLine('\n' + "Numero Apt: ");
                    bloco = Console.readLine("Bloco Apt: ");
                    andar = Console.readLine("Andar Apt: ");

                    umApartamento = new Apartamento(numero, bloco, andar);

                    long id = apartamentoDAO.inclui(umApartamento);

                    System.out.println('\n' + "Produto n�mero " + id + " inclu�do com sucesso!");

                    break;
                }

//                case 2: {
//                    int resposta = Console.readInt('\n' +
//                            "Digite o n�mero do produto que voc� deseja alterar: ");
//
//                    try {
//                        umProduto = produtoDAO.recuperaUmProduto(resposta);
//                    } catch (ProdutoNaoEncontradoException e) {
//                        System.out.println('\n' + e.getMessage());
//                        break;
//                    }
//
//                    System.out.println('\n' +
//                            "N�mero = " + umProduto.getId() +
//                            "    Nome = " + umProduto.getNome() +
//                            "    Lance M�nimo = " + umProduto.getLanceMinimo() +
//                            "    Vers�o = " + umProduto.getVersao());
//
//                    System.out.println('\n' + "O que voc� deseja alterar?");
//                    System.out.println('\n' + "1. Nome");
//                    System.out.println("2. Lance M�nimo");
//
//                    int opcaoAlteracao = Console.readInt('\n' +
//                            "Digite um n�mero de 1 a 2:");
//
//                    switch (opcaoAlteracao) {
//                        case 1:
//                            String novoNome = Console.
//                                    readLine("Digite o novo nome: ");
//
//                            umProduto.setNome(novoNome);
//
//                            try {
//                                produtoDAO.altera(umProduto);
//
//                                System.out.println('\n' +
//                                        "Altera��o de nome efetuada com sucesso!");
//                            } catch (ProdutoNaoEncontradoException e) {
//                                System.out.println('\n' + e.getMessage());
//                            }
////==>
//                            catch (EstadoDeObjetoObsoletoException e) {
//                                System.out.println('\n' + "A opera��o n�o foi " +
//                                        "efetuada: os dados que voc� " +
//                                        "tentou salvar foram modificados " +
//                                        "por outro usu�rio.");
//                            }
//
//                            break;
//
//                        case 2:
//                            double novoLanceMinimo = Console.
//                                    readDouble("Digite o novo lance m�nimo: ");
//
//                            umProduto.setLanceMinimo(novoLanceMinimo);
//
//                            try {
//                                produtoDAO.altera(umProduto);
//
//                                System.out.println('\n' +
//                                        "Altera��o de lance m�nimo efetuada " +
//                                        "com sucesso!");
//                            } catch (ProdutoNaoEncontradoException e) {
//                                System.out.println('\n' + e.getMessage());
//                            }
////==>
//                            catch (EstadoDeObjetoObsoletoException e) {
//                                System.out.println('\n' + "A opera��o n�o foi " +
//                                        "efetuada: os dados que voc� " +
//                                        "tentou salvar foram modificados " +
//                                        "por outro usu�rio.");
//                            }
//
//                            break;
//
//                        default:
//                            System.out.println('\n' + "Op��o inv�lida!");
//                    }
//
//                    break;
//                }
//
//                case 3: {
//                    int resposta = Console.readInt('\n' +
//                            "Digite o n�mero do produto que voc� deseja remover: ");
//
//                    try {
//                        umProduto = produtoDAO.recuperaUmProduto(resposta);
//                    } catch (ProdutoNaoEncontradoException e) {
//                        System.out.println('\n' + e.getMessage());
//                        break;
//                    }
//
//                    System.out.println('\n' +
//                            "N�mero = " + umProduto.getId() +
//                            "    Nome = " + umProduto.getNome() +
//                            "    Vers�o = " + umProduto.getVersao());
//
//                    String resp = Console.readLine('\n' +
//                            "Confirma a remo��o do produto?");
//
//                    if (resp.equals("s")) {
//                        try {
//                            produtoDAO.exclui(umProduto.getId());
//                            System.out.println('\n' +
//                                    "Produto removido com sucesso!");
//                        } catch (ProdutoNaoEncontradoException e) {
//                            System.out.println('\n' + e.getMessage());
//                        }
//                    } else {
//                        System.out.println('\n' +
//                                "Produto n�o removido.");
//                    }
//
//                    break;
//                }
//
                case 4: {
                    List<Apartamento> apartamentos = apartamentoDAO.recuperaApts();

                    for (Apartamento apartamento : apartamentos) {
                        System.out.println('\n' +
                                "Id = " + apartamento.getId() +
                                "  Numero = " + apartamento.getNumero() +
                                "  Andar = " + apartamento.getAndar() +
                                "  Bloco = " + apartamento.getBloco() +
                                "  Vers�o = " + apartamento.getVersao());
                    }

                    break;
                }

                case 5: {
                    continua = false;
                    break;
                }

                default:
                    System.out.println('\n' + "Op��o inv�lida!");
            }
        }
    }
}
