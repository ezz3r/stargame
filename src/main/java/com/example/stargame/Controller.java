package com.example.stargame;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        for (int i = 0; i < Model.NUMBER_OF_LIGHTS; i++) {
            final int j = i;
            view.getLightButton(i).setOnAction(event -> {model.toggle(j); update();});
        }
        view.getRestartButton().setOnAction(event -> restart());

        view.getMessageLabel().setText("Willkommen! Entferne die gefüllten Sterne!");
        view.getStage().show();
    }

    /**
     * Neustart des Spiels.
     */
    void restart() {
        model.randomiseLights();
        update();
    }

    /**
     * Wird bei jeder Aenderung am Modell aufgerufen.
     */
    public void update() {
        if (model.allLightsAreOff()) {
            view.getMessageLabel().setText("Gut gemacht!");
        } else {
            view.getMessageLabel().setText("Entferne die gefüllten Sterne!");
        }
        view.update();
    }
}
