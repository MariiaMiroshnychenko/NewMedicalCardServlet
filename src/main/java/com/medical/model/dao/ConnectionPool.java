package com.medical.model.dao;

import com.medical.container.DataBaseConnectionContainer;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPool {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName(DataBaseConnectionContainer.DRIVER_NAME);
                    ds.setUrl(DataBaseConnectionContainer.URL);
                    ds.setUsername(DataBaseConnectionContainer.USERNAME);
                    ds.setPassword(DataBaseConnectionContainer.PASSWORD);
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}
