package com.example.yugioh.duel;

public class Activation {
    private String activation;
    private String condition;

    public Activation(String activation, String condition)
    {
        this.activation = activation;
        this.condition = condition;
    }

    public String getActivation() {
        return activation;
    }

    public String getCondition() {
        return condition;
    }
}
