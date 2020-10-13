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
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar um Apartamento");
            System.out.println("2. Alterar um Apartamento");
            System.out.println("3. Remover um Apartamento");
            System.out.println("4. Listar todos os Apartamento");
            System.out.println("5. Sair");

            int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");

            switch (opcao) {
                case 1: {
                    numero = Console.readLine('\n' + "Numero Apt: ");
                    bloco = Console.readLine("Bloco Apt: ");
                    andar = Console.readLine("Andar Apt: ");

                    umApartamento = new Apartamento(numero, bloco, andar);

                    long id = apartamentoDAO.inclui(umApartamento);

                    System.out.println('\n' + "Produto número " + id + " incluído com sucesso!");

                    break;
                }

                case 2: {
                    int resposta = Console.readInt('\n' + "Digite o ID do apartamento que você deseja alterar: ");

                    try {
                        umApartamento = apartamentoDAO.recuperaUmApartamento(resposta);
                    } catch (AptNaoEncontradoException e) {
                        System.out.println('\n' + e.getMessage());
                        break;
                    }

                    System.out.println('\n' +
                            "Id = " + umApartamento.getId() +
                            "  Numero = " + umApartamento.getNumero() +
                            "  Andar = " + umApartamento.getAndar() +
                            "  Bloco = " + umApartamento.getBloco());

                    System.out.println('\n' + "O que você deseja alterar?");
                    System.out.println("1. Numero");
                    System.out.println("2. Andar");
                    System.out.println("3. Bloco");

                    int opcaoAlteracao = Console.readInt('\n' + "Digite um número de 1 a 3:");

                    switch (opcaoAlteracao) {
                        case 1:
                            String newNumero = Console.readLine("Digite o novo numero: ");

                            umApartamento.setNumero(newNumero);

                            try {
                                apartamentoDAO.altera(umApartamento);

                                System.out.println('\n' + "Alteração de nome efetuada com sucesso!");
                            } catch (AptNaoEncontradoException e) {
                                System.out.println('\n' + e.getMessage());
                            } catch (EstadoDeObjetoObsoletoException e) {
                                System.out.println('\n' + "A operação não foi " +
                                        "efetuada: os dados que você " +
                                        "tentou salvar foram modificados " +
                                        "por outro usuário.");
                            }

                            break;

//                        case 2:
//                            double novoLanceMinimo = Console.
//                                    readDouble("Digite o novo lance mínimo: ");
//
//                            umProduto.setLanceMinimo(novoLanceMinimo);
//
//                            try {
//                                produtoDAO.altera(umProduto);
//
//                                System.out.println('\n' +
//                                        "Alteração de lance mínimo efetuada " +
//                                        "com sucesso!");
//                            } catch (ProdutoNaoEncontradoException e) {
//                                System.out.println('\n' + e.getMessage());
//                            }
//
//                            catch (EstadoDeObjetoObsoletoException e) {
//                                System.out.println('\n' + "A operação não foi " +
//                                        "efetuada: os dados que você " +
//                                        "tentou salvar foram modificados " +
//                                        "por outro usuário.");
//                            }
//
//                            break;

                        default:
                            System.out.println('\n' + "Opção inválida!");
                    }

                    break;
                }
//
                case 3: {
                    int resposta = Console.readInt('\n' + "Digite o ID do apartamento que você deseja remover: ");
                    try {
                        umApartamento = apartamentoDAO.recuperaUmApartamento(resposta);
                    } catch (AptNaoEncontradoException e) {
                        System.out.println('\n' + e.getMessage());
                        break;
                    }

                    System.out.println('\n' +
                            "Id = " + umApartamento.getId() +
                            "  Numero = " + umApartamento.getNumero() +
                            "  Andar = " + umApartamento.getAndar() +
                            "  Bloco = " + umApartamento.getBloco() +
                            "  Versão = " + umApartamento.getVersao());

                    String resp = Console.readLine('\n' + "Confirma a remoção do apartamento?");

                    if (resp.equals("s") || resp.equals("sim") || resp.equals("S") || resp.equals("Sim")) {
                        try {
                            apartamentoDAO.exclui(umApartamento.getId());
                            System.out.println('\n' + "Apartamento removido com sucesso!");
                        } catch (AptNaoEncontradoException e) {
                            System.out.println('\n' + e.getMessage());
                        }
                    } else {
                        System.out.println('\n' + "Apartamento não removido.");
                    }

                    break;
                }

                case 4: {
                    List<Apartamento> apartamentos = apartamentoDAO.recuperaApts();

                    for (Apartamento apartamento : apartamentos) {
                        System.out.println('\n' +
                                "Id = " + apartamento.getId() +
                                "  Numero = " + apartamento.getNumero() +
                                "  Andar = " + apartamento.getAndar() +
                                "  Bloco = " + apartamento.getBloco() +
                                "  Versão = " + apartamento.getVersao());
                    }

                    break;
                }

                case 5: {
                    continua = false;
                    break;
                }

                default:
                    System.out.println('\n' + "Opção inválida!");
            }
        }
    }
}
