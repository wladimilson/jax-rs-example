package br.com.treinaweb.model;

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String senha;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}