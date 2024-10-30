
package controller;

import Banco.Dados;
import Banco.Dao;
import java.util.List;
import javax.persistence.Query;
import model.Conexao;
import model.Empresa;
import model.Programa;
import model.SistemaOperacional;
import model.Terminal;

public class DaoConexao extends Dao<Conexao>{
    
    public List<Conexao> read(){
        String JPQL="select c from Conexao c order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Conexao> read(String filtro){
        String JPQL="select c from Conexao c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }

    public List<Conexao> read(Terminal terminal){
        String JPQL="select c from Conexao c where c.terminal = ?1 "
                + "order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, terminal);
        return query.getResultList();
    }
    
    public List<Conexao> read(SistemaOperacional sistemaOperacional){
        String JPQL="select c from Conexao c where c.sistemaOperacional = ?1 "
                + "order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, sistemaOperacional);
        return query.getResultList();
    }
    
    public List<Conexao> read(Programa programa){
        String JPQL="select c from Conexao c where c.programa = ?1 "
                + "order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, programa);
        return query.getResultList();
    }
    
    public List<Conexao> read(Empresa empresa){
        String JPQL="select c from Conexao c where c.empresa = ?1 "
                + "order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, empresa);
        return query.getResultList();
    }
}
