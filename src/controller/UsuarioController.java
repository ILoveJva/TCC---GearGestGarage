package controller;

import model.Usuario;

import java.util.ArrayList;

/**
 * Responsável pela autenticação e gestão de usuários.
 */
public class UsuarioController {

    private ArrayList<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Autentica um usuário pelo e-mail e senha.
     * @return Usuario autenticado ou null se credenciais inválidas.
     */
    public Usuario login(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                u.setStatus("ATIVO");
                return u;
            }
        }
        return null;
    }

    /**
     * Encerra a sessão do usuário.
     */
    public void logout(Usuario usuario) {
        if (usuario != null) {
            usuario.setStatus("INATIVO");
        }
    }

    /**
     * Busca um usuário pelo ID.
     */
    public Usuario buscarPorId(long idUsuario) {
        return usuarios.stream()
                .filter(u -> u.getIdUsuario() == idUsuario)
                .findFirst()
                .orElse(null);
    }

    /**
     * Valida se o e-mail possui formato correto.
     */
    public boolean verificarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    /**
     * Cadastra um novo usuário na lista.
     */
    public boolean cadastrar(Usuario usuario) {
        if (!verificarEmail(usuario.getEmail())) return false;
        boolean emailExistente = usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(usuario.getEmail()));
        if (emailExistente) return false;
        usuarios.add(usuario);
        return true;
    }

    /**
     * Atualiza os dados de um usuário existente.
     */
    public boolean atualizar(Usuario usuarioAtualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == usuarioAtualizado.getIdUsuario()) {
                usuarios.set(i, usuarioAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um usuário pelo ID.
     */
    public boolean remover(long idUsuario) {
        return usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);
    }

    public ArrayList<Usuario> listarTodos() {
        return usuarios;
    }
}
