package br.com.sitedoph.model;

/**
 * Created by ph on 4/18/16.
 */
public class Linha {
    private final String id_i;
    private final String nome;
    private final String id_ii;
    private final String digito;
    private final String motivo;

    public Linha(String id_i, String nome, String id_ii, String digito, String motivo) {
        this.id_i = id_i;
        this.nome = nome;
        this.id_ii = id_ii;
        this.digito = digito;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Linha{" +
                "id_i='" + id_i + '\'' +
                ", nome='" + nome + '\'' +
                ", id_ii='" + id_ii + '\'' +
                ", digito='" + digito + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }

    public String getId_i() {
        return id_i;
    }

    public String getNome() {
        return nome;
    }

    public String getId_ii() {
        return id_ii;
    }

    public String getDigito() {
        return digito;
    }

    public String getMotivo() {
        return motivo;
    }
}
