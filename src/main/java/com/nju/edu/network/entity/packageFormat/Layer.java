package com.nju.edu.network.entity.packageFormat;

public enum Layer {
    NetworkInterface(1,"networkInterface"),
    Network(2,"network"),
    Transport(3,"transport"),
    Application(4,"application");

    final int code;
    final String description;

    Layer(int code, String description){
        this.code = code;
        this.description = description;
    }
}
