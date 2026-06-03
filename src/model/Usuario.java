package model;

public abstract class Usuario {

    protected long idUsuario;
    protected String nome;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String cpf;
    protected String status;
    protected Oficina oficina;


    public Usuario() {

    }

    public Usuario(long idUsuario, String nome, String email, String senha,
                   String telefone, String cpf, String status, Oficina oficina) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
        this.status = status;
        this.oficina = oficina;
    }

    protected boolean verificarEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public void login(String email, String senha) {
        // lógica de autenticação delegada ao controller
    }

    public void logout(String email, String senha) {
        // lógica de encerramento de sessão delegada ao controller
    }

    // Getters e Setters
    public long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Oficina getOficina() { return oficina; }
    public void setOficina(Oficina oficina) { this.oficina = oficina; }
}
