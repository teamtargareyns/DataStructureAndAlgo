package com.test.aks.data_structure.practice;


/**
 * This is presentation of reflection preventive thread safe singleton
 */
public enum SerializedSingleton {

    INSTANCE;

    public SerializedSingleton getInstance(){
        return INSTANCE;
    }
}
