package com.example.yugioh.duel;

public class Effect {
    private String type;
    private String resolution;
    private Activation activation;
    private boolean isChainLink;
    public Effect(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return activation.getCondition();
    }

    public String getResolution() {
        return resolution;
    }

    public String getActivation() {
        return activation.getActivation();
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

    public boolean isChainLink() {
        return isChainLink;
    }

    public void setChainLink(boolean chainLink) {
        isChainLink = chainLink;
    }
}
