package com.BSP.StudentApis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;
    private String studentname;
    private String rollno;
    private String department;
    private String section;
    private String mobileno;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_std_id",referencedColumnName = "studentid")
    private List<Subjects> subjects;
}
