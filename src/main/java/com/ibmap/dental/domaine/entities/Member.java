package com.ibmap.dental.domaine.entities;

import com.ibmap.dental.application.typology.CivilStatus;
import com.ibmap.dental.application.typology.Gender;
import com.ibmap.dental.application.typology.MemberStatus;
import com.ibmap.dental.domaine.BasicEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@ToString(callSuper = true)
public class Member extends BasicEntity {

 @Column(name = "member_id", nullable = false,unique = true)
 private String memberId;
 @Column(name = "last_name", nullable = false)
 private String lastName;
 @Column(name = "first_name", nullable = false)
 private String firstName;
 @Column(name = "civil_status", nullable = false)
 @Enumerated(EnumType.STRING)
 private CivilStatus civilStatus;
 @Column(name = "address", nullable = false)
 private String address;
 @Column(name = "phone_number", nullable = false)
 private String phoneNumber;
 @Column(name = "email", unique = true)
 private String email;
 @Column(name = "gender", nullable = false)
 @Enumerated(EnumType.STRING)
 private Gender gender;
 @Column(name = "district_origin", nullable = false)
 private String districtOrigin;
 @Column(name = "date_of_birth", nullable = false)
 private LocalDate dateOfBirth;
 @Column(name = "status", nullable = false)
 @Enumerated(EnumType.STRING)
 private MemberStatus status;
 @Column(name = "registration_date", nullable = false)
 private LocalDate registrationDate;
 @Column(name =  "pictureURL", nullable = true)
 private String pictureURL;

 @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
 private List<Insurance> insurance = new ArrayList<>();

 @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
 private List<Contribution> contribution = new ArrayList<>();

 @OneToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "head_person_id")
 private Family family;

}
