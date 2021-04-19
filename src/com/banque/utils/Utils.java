package com.banque.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class Utils {
	//extarcte les données + dynamise les getter/setter
    public Object extracted(Object o, ResultSet result) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();

        //boucle qui envoie les data BDD + nbr de colonne ds table BDD + boucle dessus
        for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
        	//récup le nom colonne
            String name = result.getMetaData().getColumnName(i);
            //récup les setter + met 1 lettre en maj
            String s1 = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            //récup méthode = null
            Method method = null;
            //récup les diff types des champs 
            String type = result.getMetaData().getColumnTypeName(i);
            if(type == "INT"){
                method = c.getDeclaredMethod(s1, Integer.class);
                     method.invoke(o, result.getObject(i));
            }else if(type == "VARCHAR" || type == "CHAR"){
                method = c.getDeclaredMethod(s1, String.class);
                     method.invoke(o, result.getObject(i));
            }else if(type == "FLOAT"){
                method = c.getDeclaredMethod(s1, float.class);
                     method.invoke(o, result.getObject(i));
            }else if(type == "DATE"){
                method = c.getDeclaredMethod(s1, Date.class);
                method.invoke(o, result.getObject(i));
            }

        }
        return o;
    }
}

