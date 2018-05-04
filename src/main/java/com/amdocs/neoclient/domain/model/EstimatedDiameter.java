//: com.amdocs.neoclient.domain.model.EstimatedDiameter.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class EstimatedDiameter {

    private Kilometers kilometers;

    public Kilometers getKilometers() {
        return this.kilometers;
    }

    public void setKilometers(Kilometers kilometers) {
        this.kilometers = kilometers;
    }

}///:~