import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vetor vetor = new Vetor(100);
        boolean dadosCarregados = false;

        int opcao;
        do {
            System.out.println("\n=== MENU NETFLIX ===");
            System.out.println("1. Carregar dados do arquivo");
            System.out.println("2. Exibir todos os registros em ordem alfabética de país");
            System.out.println("3. Exibir todos os registros em ordem decrescente de qtde. títulos");
            System.out.println("4. Consultar país por sigla");
            System.out.println("5. Estatísticas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    if (!dadosCarregados) {
                        System.out.print("Digite o caminho do arquivo Netflix.txt: ");
                        String caminho = scanner.nextLine();
                        carregarDados(caminho, vetor);
                        dadosCarregados = true;
                    } else {
                        System.out.println("Os dados já foram carregados!");
                    }
                    break;
                case 2:
                    if (dadosCarregados) {
                        vetor.ordenarPorNome();
                        vetor.exibirTodos();
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1)");
                    }
                    break;
                case 3:
                    if (dadosCarregados) {
                        vetor.ordenarPorQtdeTitulos();
                        vetor.exibirTodos();
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1)");
                    }
                    break;
                case 4:
                    if (dadosCarregados) {
                        System.out.print("Digite a sigla do país: ");
                        String sigla = scanner.nextLine();
                        Pais pais = vetor.buscarPorSigla(sigla);
                        if (pais != null) {
                            System.out.println(pais);
                        } else {
                            System.out.println("País não encontrado!");
                        }
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1)");
                    }
                    break;
                case 5:
                    if (dadosCarregados) {
                        vetor.gerarEstatisticas();
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1)");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    System.out.println("Integrantes do grupo: [Nomes dos integrantes]");
                    System.out.println("Link do vídeo: [URL do vídeo]");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 6);

        scanner.close();
    }

    private static void carregarDados(String caminhoArquivo, Vetor vetor) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                Pais pais = new Pais(
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2]),
                        Integer.parseInt(dados[3]),
                        Integer.parseInt(dados[4]),
                        Double.parseDouble(dados[5]),
                        Double.parseDouble(dados[6]),
                        Double.parseDouble(dados[7])
                );

                vetor.adicionar(pais);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Formato do arquivo inválido: " + e.getMessage());
        }
    }
}