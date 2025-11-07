package com.example.stargame;

public class Model {

    public static final int NUMBER_OF_LIGHTS = 12;
    private final boolean[] lights = new boolean[NUMBER_OF_LIGHTS];

    public Model() {
        randomiseLights();
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

        if (i == 0) leftNeighbor = false;
        if  (i == NUMBER_OF_LIGHTS-1) rightNeighbor = false;

        if (leftNeighbor) lights[i-1] = !lights[i - 1];

        if (rightNeighbor) lights[i+1] = !lights[i + 1];

        lights[i] = !lights[i];
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
