package fig;

import java.sql.Connection;

public abstract class DAO<T> {
  protected Connect connect = null;
   
  public DAO(Connect conn){
    this.connect = conn;
  }
   
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(String id);
}