//: com.amdocs.neoclient.domain.model.EstimatedDiameter.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class EstimatedDiameter {

    private Kilometers kilometers;

    public Double getEstimatedDiameterMaxKilo() {
        return Optional.ofNullable(this.kilometers)
                .map(Kilometers::getEstimatedDiameterMax)
                .orElseGet(() -> new Double(0));
    }

}///:~