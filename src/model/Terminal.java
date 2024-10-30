
package model;

import enums.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_terminais")
public class Terminal {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "nome",length = 100,nullable = false)
    private String nome;
    
    public Terminal() {
        this.setId(0);
        this.setNome("");
    }

    public Terminal(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
    
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"NOME CLIENTE":nome.toUpperCase();;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    //

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 29 * hash + this.id;
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
        final Terminal other = (Terminal) obj;
        return this.id == other.id;
    }
}
