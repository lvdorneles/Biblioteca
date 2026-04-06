import java.time.LocalDate;

class Autor {
    int id;
    String nome;
    LocalDate dataNascimento;

    public Autor(int id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}

class Livro {
    int id;
    String titulo;
    Autor autor;
    boolean disponivel;
    LocalDate dataCadastro;
    LocalDate dataAtualizacao;

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }
}

class Emprestimo {
    int id;
    Livro livro;
    String nomeCliente;
    LocalDate dataEmprestimo;

    public Emprestimo(int id, Livro livro, String nomeCliente) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = LocalDate.now();
    }
}