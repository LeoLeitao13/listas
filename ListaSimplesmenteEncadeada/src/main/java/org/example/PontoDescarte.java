package org.example;
import java.util.Objects;

public class PontoDescarte {
    private String local;
    private String tipoMaterial;

    public PontoDescarte(String local, String tipoMaterial) {
        this.local = local;
        this.tipoMaterial = tipoMaterial;
    }

    public String getLocal() {
        return local;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    @Override
    public String toString() {
        return "Local: " + local + " | Material: " + tipoMaterial;
    }
}
