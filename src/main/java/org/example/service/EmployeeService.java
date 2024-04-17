package org.example.service;

import org.example.entity.EmployeeEntity;

public interface EmployeeService {
    EmployeeEntity getUserByEmail(String email);
}
