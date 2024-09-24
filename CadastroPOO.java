package cadastropoo;

import model.*;
import java.io.IOException;
import java.util.Scanner;


public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        int opcao;
        
        
        try{
            
            System.out.println("===========================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Persistir dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===========================");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffe;
         
            switch (opcao) {
                case 1: // Incluir
                    System.out.println("Escolha o tipo:");
                    System.out.println("1 - Pessoa Física | 2 - Pessoa Jurídica");
                    int tipoInclusao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoInclusao == 1) {
                        System.out.println("Digite o id da pessoa:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Insira os dados...");
                        System.out.println("Nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o CPF:");
                        String cpf = scanner.nextLine();
                        System.out.println("Informe a idade:");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        pessoaFisicaRepo.inserir(pf);
                        System.out.println("Pessoa física inserida com sucesso!");

                    } else if (tipoInclusao == 2) {
                        System.out.println("Digite o id da pessoa:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Informe o nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o CNPJ:");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        pessoaJuridicaRepo.inserir(pj);
                        System.out.println("Pessoa jurídica inserida com sucesso!");
                    }
                    break;
                
                case 2: // Alterar
                    System.out.println("Escolha o tipo para alterar:");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    int tipoAlteracao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoAlteracao == 1) {
                        System.out.println("Informe o ID da pessoa física a ser alterada:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pfExistente = pessoaFisicaRepo.obter(id);
                        if (pfExistente != null) {
                            System.out.println("Dados atuais: " + pfExistente);
                            System.out.println("Informe o novo nome:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Informe o novo CPF:");
                            String novoCpf = scanner.nextLine();
                            System.out.println("Informe a nova idade:");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine();

                            pfExistente.setNome(novoNome);
                            pfExistente.setCpf(novoCpf);
                            pfExistente.setIdade(novaIdade);
                            pessoaFisicaRepo.alterar(pfExistente);
                            System.out.println("Pessoa física alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }

                    } else if (tipoAlteracao == 2) {
                        System.out.println("Informe o ID da pessoa jurídica a ser alterada:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pjExistente = pessoaJuridicaRepo.obter(id);
                        if (pjExistente != null) {
                            System.out.println("Dados atuais: " + pjExistente);
                            System.out.println("Informe o novo nome:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Informe o novo CNPJ:");
                            String novoCnpj = scanner.nextLine();

                            pjExistente.setNome(novoNome);
                            pjExistente.setCnpj(novoCnpj);
                            pessoaJuridicaRepo.alterar(pjExistente);
                            System.out.println("Pessoa jurídica alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa jurídica não encontrada.");
                        }
                    }
                    break;
                    
                
                case 3: // Excluir
                    System.out.println("Escolha o tipo para excluir:");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    int tipoExclusao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExclusao == 1) {
                        System.out.println("Informe o ID da pessoa física a ser excluída:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        pessoaFisicaRepo.excluir(id);
                        System.out.println("Pessoa física excluída com sucesso!");
                    } else if (tipoExclusao == 2) {
                        System.out.println("Informe o ID da pessoa jurídica a ser excluída:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        pessoaJuridicaRepo.excluir(id);
                        System.out.println("Pessoa jurídica excluída com sucesso!");
                    }
                    break;
                case 4: // Exibir por ID
                    System.out.println("Escolha o tipo para exibir por ID:");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    int tipoExibirId = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExibirId == 1) {
                        System.out.println("Informe o ID da pessoa física:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pfExibir = pessoaFisicaRepo.obter(id);
                        if (pfExibir != null) {
                            pfExibir.exibir();
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipoExibirId == 2) {
                        System.out.println("Informe o ID da pessoa jurídica:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pjExibir = pessoaJuridicaRepo.obter(id);
                        if (pjExibir != null) {
                            pjExibir.exibir();
                        } else {
                            System.out.println("Pessoa jurídica não encontrada.");
                        }
                    }
                    break;
                
                case 5: // Exibir todos
                    System.out.println("Escolha o tipo para exibir todos:");
                    System.out.println("1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    int tipoExibirTodos = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExibirTodos == 1) {
                        for (PessoaFisica pf : pessoaFisicaRepo.obterTodos()) {
                            pf.exibir();
                        }
                    } else if (tipoExibirTodos == 2) {
                        for (PessoaJuridica pj : pessoaJuridicaRepo.obterTodos()) {
                            pj.exibir();
                        }
                    }
                    break;    
                case 6: // Salvar dados
                    System.out.println("Informe o prefixo do arquivo para salvar:");
                    String prefixoSalvar = scanner.nextLine();

                    try {
                        pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                        pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;

                case 7: // Recuperar dados
                    System.out.println("Informe o prefixo do arquivo para recuperar:");
                    String prefixoRecuperar = scanner.nextLine();

                    try {
                        pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                        pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
           
        while (opcao != 0);
        }catch(Exception e){
        }
          
        scanner.close();
    }

    private static class pessoaFisicaRepo {

        private static PessoaFisica obter(int id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}        