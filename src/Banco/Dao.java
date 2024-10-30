package Banco;

abstract public class Dao<T> {
     public void create(T objeto){
        Dados.getManager().getTransaction().begin();
        Dados.getManager().persist(objeto);
        Dados.getManager().getTransaction().commit();
    }   
     public void update(T objeto){
        Dados.getManager().getTransaction().begin();
        Dados.getManager().merge(objeto);
        Dados.getManager().getTransaction().commit();
    }   
     public void delete(T objeto){
        Dados.getManager().getTransaction().begin();
        if (!Dados.getManager().contains(objeto)) {
            objeto = Dados.getManager().merge(objeto);
        }
        Dados.getManager().remove(objeto);
        Dados.getManager().getTransaction().commit();
    }   
    public T read(Class<T> tipo, int id){
        return Dados.getManager().find(tipo,id);
    }    
}
