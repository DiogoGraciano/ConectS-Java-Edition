
package model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "nome",length = 100,nullable = false)
    private String nome;
    @Column(name = "endereco",length = 100, nullable = false)
    private String endereco;
    @Column(name = "cnpj",length = 18, nullable = false)
    private String cnpj;
    @Column(name = "email",length = 100, nullable = false)
    private String email;
    @Column(name = "fundacao",nullable = false)
    private LocalDate fundacao;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_cidade",nullable = false,referencedColumnName = "id")
    private Cidade cidade;
//
    public Empresa() {
        this.setId(0);
        this.setNome("nome cliente");
        this.setEndereco("sem endereco");
        this.setCnpj("00.000.000/000-00");
        this.setEmail("email");
        this.setFundacao(LocalDate.now());
        this.setCidade(null);
    }
    public Empresa(int id, String nome, String endereco, String cnpj, String email, LocalDate fundacao, Cidade cidade) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setCnpj(cnpj);
        this.setEmail(email);
        this.setFundacao(fundacao);
        this.setCidade(cidade);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"NOME CLIENTE":nome.toUpperCase();
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"SEM ENDERECO":endereco.toUpperCase();
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj.trim().isEmpty()?"000.000.000-00":cnpj;
    }
    public void setEmail(String email) {
        this.email = email.trim().isEmpty()?"email":email.toLowerCase();
    }
    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao==null?LocalDate.now():fundacao;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public String getCnpj() {
        return this.cnpj;
    }
    public String getEmail() {
        return this.email;
    }
    public LocalDate getFundacao() {
        return this.fundacao;
    }
    public Cidade getCidade() {
        return this.cidade;
    }
    //

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + '}';
    }
    //

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Empresa other = (Empresa) obj;
        return this.id == other.id;
    }
    
}
