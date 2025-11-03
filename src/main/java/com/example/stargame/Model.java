package com.example.stargame;

public class Model {

    public static int NUMBER_OF_LIGHTS = 12;
    private boolean[] lights;

    public Model() {
        lights = new boolean[NUMBER_OF_LIGHTS];
    }

    public void randomiseLights(){
        for(int i = 0; i < NUMBER_OF_LIGHTS; i++){
            if(Math.random() < 0.5){
                lights[i] = false;
            } else {
                lights[i] = true;
            }
        }
    }

    public boolean getLight(int i){
        return lights[i];
    }

    public void toggle(int i) {

        boolean leftNeighbor = true;
        boolean rightNeighbor = true;

        if (i == 0){ leftNeighbor = false; }
        if  (i == 11){ rightNeighbor = false; }

        if (leftNeighbor) {
            if (lights[i-1]){
                lights[i-1] = false;
            } else {
                lights[i-1] = true;
            }
        }

        if (rightNeighbor) {
            if (lights[i+1]){
                lights[i+1] = false;
            } else {
                lights[i+1] = true;
            }
        }

        if (lights[i]){
            lights[i] = false;
        } else {
            lights[i] = true;
        }
    }

    public boolean allLightsAreOff() {
        for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
            if (lights[i]) {
                return false;
            }
        }
        return true;
    }
}
