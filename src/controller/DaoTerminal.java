
package controller;

import Banco.Dados;
import Banco.Dao;
import java.util.List;
import javax.persistence.Query;
import model.Terminal;

public class DaoTerminal extends Dao<Terminal>{
    public List<Terminal> read(){
        String JPQL="select c from Terminal c order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    public List<Terminal> read(String filtro){
        String JPQL="select c from Terminal c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
}
