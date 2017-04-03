package com.leycarno.javacourse.java_08_awt.controllers;

import com.leycarno.javacourse.java_08_awt.services.RepositoryService;

public class RepositoryController {

    private static final String FILE_NAME = "repository.json";

    private RepositoryService service = new RepositoryService();

    // load data out of data
    public void loadData() {
        service.load(FILE_NAME);
    }

    // load data out of data
    public void storeData() {
        service.store(FILE_NAME);
    }
}
