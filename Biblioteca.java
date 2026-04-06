import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    List<Livro> livros = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();
        biblio.inicializarDados();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Biblioteca ---");
            System.out.print("Deseja ver os livros disponíveis? (SIM/NAO): ");
            String resposta = sc.nextLine().toUpperCase();

            if (resposta.equals("SIM")) {
                biblio.listarLivrosDisponiveis();
                
                System.out.print("\nDigite o ID do livro para emprestar (ou 0 para cancelar): ");
                int idEscolhido = Integer.parseInt(sc.nextLine());

                if (idEscolhido > 0) {
                    System.out.print("Informe seu nome: ");
                    String nomeCliente = sc.nextLine();
                    biblio.realizarEmprestimo(idEscolhido, nomeCliente);
                    
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    break; 
                }
            } else {
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            }
        }
        sc.close();
    }

    void listarLivrosDisponiveis() {
        System.out.println("\nLivros Disponíveis:");
        boolean encontrou = false;
        for (Livro l : livros) {
            if (l.disponivel) {
                System.out.println("[" + l.id + "] " + l.titulo + " - Autor: " + l.autor.nome);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum livro disponível no momento.");
    }

    void realizarEmprestimo(int idLivro, String nomeCliente) {
        for (Livro l : livros) {
            if (l.id == idLivro && l.disponivel) {
                l.disponivel = false;
                l.dataAtualizacao = java.time.LocalDate.now();
                
                Emprestimo novoEmprestimo = new Emprestimo(emprestimos.size() + 1, l, nomeCliente);
                emprestimos.add(novoEmprestimo);
                
                System.out.println("\n>>> Sucesso: Empréstimo de '" + l.titulo + "' registrado para " + nomeCliente + "!");
                return;
            }
        }
        System.out.println("\n>>> Erro: Livro não encontrado ou já emprestado.");
    }

    void inicializarDados() {
        Autor a1 = new Autor(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Autor a2 = new Autor(2, "J.R.R. Tolkien", LocalDate.of(1892, 1, 3));
        
        livros.add(new Livro(1, "Harry Potter e a Pedra Filosofal", a1));
        livros.add(new Livro(2, "O Senhor dos Anéis", a2));
        livros.add(new Livro(3, "O Hobbit", a2));
    }
}