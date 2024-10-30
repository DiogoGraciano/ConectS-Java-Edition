
package controller;

import Banco.Dados;
import Banco.Dao;
import java.util.List;
import javax.persistence.Query;
import model.Cidade;
import model.Empresa;

public class DaoEmpresa extends Dao<Empresa>{
    public List<Empresa> read(){
        String JPQL="select c from Empresa c order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Empresa> read(String filtro){
        String JPQL="select c from Empresa c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
    
    //filtro por cidade
    public List<Empresa> read(Cidade cidade){
        String JPQL="select c from Empresa c where c.cidade = ?1 "
                + "order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, cidade);
        return query.getResultList();
    }
    
    public Empresa readByCnpj(String filtro){
        String JPQL="select c from Empresa c where c.cnpj = ?1";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, filtro);
        return (Empresa)query.getSingleResult();
    }
    
}
