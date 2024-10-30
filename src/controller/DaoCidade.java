
package controller;

import Banco.Dados;
import Banco.Dao;
import enums.Estados;
import java.util.List;
import javax.persistence.Query;
import model.Cidade;

public class DaoCidade extends Dao<Cidade>{
    public List<Cidade> read(){
        String JPQL="select c from Cidade c order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    public List<Cidade> read(String filtro){
        String JPQL="select c from Cidade c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
    public List<Cidade> read(Estados filtro){
        String JPQL="select c from Cidade c where c.sigla=?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1,filtro);
        return query.getResultList();
    }
}
