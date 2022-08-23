package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread.executor;

import java.util.concurrent.Callable;

public class Task implements Callable {
    private String message;

    public Task(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        return "Hello " + message + "!";
    }
}
