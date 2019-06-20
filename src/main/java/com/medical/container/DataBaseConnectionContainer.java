package com.medical.container;

public interface DataBaseConnectionContainer {
    String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/medicine_v2?serverTimezone=UTC";
    String USERNAME = "root";
    String PASSWORD = "root";

    int MAX_OPEN_PREPARED_STATEMENTS = 100;
}
