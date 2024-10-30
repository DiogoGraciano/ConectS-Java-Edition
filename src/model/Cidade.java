
package model;

import enums.Estados;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "nome",length = 100,nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "sigla",length = 2,nullable = false)
    private Estados sigla;
    //
    public Cidade() {
        this.setId(0);
        this.setNome("sem nome");
        this.setSigla(Estados.SC);
    }

    public Cidade(int id, String nome, Estados sigla) {
        this.setId(id);
        this.setNome(nome);
        this.setSigla(sigla);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM NOME":nome.toUpperCase();
    }

    public void setSigla(Estados sigla) {
        this.sigla = sigla;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Estados getSigla() {
        return this.sigla;
    }

    @Override
    public String toString() {
        return this.nome + " (" + sigla + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return this.id == other.id;
    }
    
}
