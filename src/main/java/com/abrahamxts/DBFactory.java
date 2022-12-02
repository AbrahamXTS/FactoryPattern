package com.abrahamxts;

import java.util.Properties;
import com.abrahamxts.util.*;
import com.abrahamxts.adapters.*;

public class DBFactory {

    private static final String DB_FACTORY_PROPERTY_URL = "META-INF/DBFactory.properties";

    public static IDBAdapter getDBadapter(DBType dbType) {
        switch (dbType) {
            case MySQL:
                return new MySQLDBAdapter();
            case Oracle:
                return new PostgreSQLDBAdapter();
            default:
                throw new IllegalArgumentException("Base de datos no soportada.");
        }
    }

    public static IDBAdapter getDefaultDBAdapter() {
        try {
            Properties properties = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);

            String defaultDBClass = properties.getProperty("DB_CLASS");

            System.out.println("Clase de datos por defecto ==> " + defaultDBClass);
			
            return (IDBAdapter) Class.forName(defaultDBClass).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}