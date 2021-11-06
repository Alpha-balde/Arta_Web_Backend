package com.ibmap.dental.domaine;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BasicEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long            id;

    @Column(name = "BUSINESSKEY", unique = true, nullable = false)
    protected String          businessKey;

    @Column(name = "CREATED_ON")
    protected Instant createdOn;

    @Column(name = "MODIFIED_ON")
    protected Instant   modifiedOn;


    @PrePersist
    @PreUpdate
    void onPrePersistOrUpdate() {
        modifiedOn = Instant.now();
        if (createdOn == null) {
            createdOn = modifiedOn;
        }
        if(Objects.isNull(businessKey)){
            businessKey = BusinessKeyGenerator.generateBusinessKey(this.getClass());
        }
    }
}
