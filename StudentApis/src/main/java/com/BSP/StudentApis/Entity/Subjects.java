package com.BSP.StudentApis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subid;
    private String subjectname;
    private String subjectcode;

    @OneToOne(cascade = CascadeType.ALL)
    private Subjectmaterial subjectmaterial;

}
