package com.ibmap.dental.domaine.entities;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Insurance extends  CommonFees {


    public  Insurance update(Insurance entity){
        super.update(entity);

        return  this;
    }

}
