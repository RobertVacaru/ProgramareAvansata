package DAO;

import java.sql.SQLException;

public interface Dao<T>{

    public Object get(int id) throws SQLException;

    public void add(T t)throws  SQLException;

}