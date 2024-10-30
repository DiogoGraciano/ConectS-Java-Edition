/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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

/**
 *
 * @author diogo
 */
@Entity
@Table(name = "tb_conexao")
public class Conexao implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "nome",length = 100,nullable = false)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_terminal",nullable = false,referencedColumnName = "id")
    private Terminal terminal;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_sistemas_operacinais",nullable = false,referencedColumnName = "id")
    private SistemaOperacional sistemaOperacional;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_programa",nullable = false,referencedColumnName = "id")
    private Programa programa;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_empresa",nullable = false,referencedColumnName = "id")
    private Empresa empresa;
    @Column(name = "conexao",length = 300, nullable = false)
    private String conexao;
    @Column(name = "usuario",length = 200, nullable = false)
    private String usuario;
    @Column(name = "senha",length = 200, nullable = false)
    private String senha;
    @Column(name = "obs",length = 1000, nullable = false)
    private String obs;
    
    public Conexao() {
        this.setId(0);
        this.setNome("");
        this.setConexao("");
        this.setEmpresa(new Empresa());
        this.setPrograma(new Programa());
        this.setTerminal(new Terminal());
        this.setSistemaOperacional(new SistemaOperacional());
        this.setUsuario("");
        this.setSenha("");
        this.setObs("");
    }
    
    public Conexao(int id, String nome, String conexao,Empresa empresa, Programa programa, Terminal terminal, SistemaOperacional sistemaOperacional, String usuario, String senha, String obs) {
        this.setId(id);
        this.setNome(nome);
        this.setConexao("");
        this.setEmpresa(empresa);
        this.setPrograma(programa);
        this.setTerminal(terminal);
        this.setSistemaOperacional(sistemaOperacional);
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setObs(obs);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getObs() {
        return obs;
    }

    public String getSenha() {
        return senha;
    }

    public String getConexao() {
        return conexao;
    }

    public Programa getPrograma() {
        return programa;
    }

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"NOME CLIENTE":nome.toUpperCase();
    }

    public void setConexao(String conexao) {
        this.conexao = nome.trim().isEmpty()?"SEM CONEXAO":conexao;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setObs(String obs) {
        this.obs = obs.trim().isEmpty()?"SEM OBSERVACAO":obs.toUpperCase();
    }

    public void setSenha(String senha) {
        this.senha = senha.trim().isEmpty()?"SEM SENHA":senha.trim();
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario.trim().isEmpty()?"SEM USUARIO":obs.toUpperCase();
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 8;
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
        final Conexao other = (Conexao) obj;
        return this.id == other.id;
    } 
    
}
