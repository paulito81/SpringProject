package phasfjo.mysql;

/**
 * Created by paulito on 09.06.2017.
 */
public interface SQLQuery {

    void createANewTable ();
    Student selectTable ();
    boolean deleteTable ();
    boolean updateTable ();
}
