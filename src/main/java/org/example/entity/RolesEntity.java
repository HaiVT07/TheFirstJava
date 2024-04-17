package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.enumdata.ActiveStatus;

@Entity
@Table(name = "Roles")
@Getter
@Setter
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "active")
    @Enumerated(value = EnumType.ORDINAL)
    private ActiveStatus active;
}
