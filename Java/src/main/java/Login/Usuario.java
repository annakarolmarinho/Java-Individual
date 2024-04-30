package Login;

import BD.PegarDadosDaTabelas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String senha;
    private List<PegarDadosDaTabelas> pegarDadosDaTabelasList;

    public Usuario(){
        this.pegarDadosDaTabelasList = new ArrayList<>();
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.pegarDadosDaTabelasList = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
