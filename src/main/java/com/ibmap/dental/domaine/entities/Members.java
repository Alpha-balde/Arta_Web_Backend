package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
public class Members extends BasicEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member")
    private Members tutors;
    @OneToMany(mappedBy = "tutors", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Members> dependent = new ArrayList<>();
    private String lastName;
    private String firstName;

    public Members(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }


    public boolean isRoot() {
        return Objects.isNull(tutors);
    }

    public boolean isHouseholder() {
        return (!Objects.requireNonNull(dependent).isEmpty()) && isRoot();
    }

    public boolean isAlone() {
        return isRoot() && Objects.requireNonNull(dependent).isEmpty();
    }

    public boolean isDependent() {
        return !isRoot();
    }

    public void add(Members member) {
        member.setTutors(this);
        this.dependent.add(member);
    }

    public void add(List<Members> members) {
        members.forEach(this::add);
    }

    public void showChild() {
        this.dependent.forEach(child ->  System.out.println(child));
    }

    @Override
    public String toString() {
        return "Members{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +" PARENT -> "+tutors+
                '}';
    }

}
