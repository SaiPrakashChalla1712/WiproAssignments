package com.javanetworkingandserializationassignment;

import java.io.Serializable;

class OperationData implements Serializable {
    int num1;
    int num2;
    String operator;

    public OperationData(int num1, int num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
}
