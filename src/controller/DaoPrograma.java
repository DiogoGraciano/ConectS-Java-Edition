
package controller;

import Banco.Dados;
import Banco.Dao;
import java.util.List;
import javax.persistence.Query;
import model.Programa;

public class DaoPrograma extends Dao<Programa>{
    public List<Programa> read(){
        String JPQL="select c from Programa c order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    public List<Programa> read(String filtro){
        String JPQL="select c from Programa c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
}
