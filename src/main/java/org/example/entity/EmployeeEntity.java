package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.enumdata.ActiveStatus;

import java.sql.Timestamp;

@Entity
@Table(name = "Employee")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "role_id")
    private Long roleId;

    @Basic
    @Column(name = "employee_identity")
    private String employeeIdentity;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private ActiveStatus status;
}
