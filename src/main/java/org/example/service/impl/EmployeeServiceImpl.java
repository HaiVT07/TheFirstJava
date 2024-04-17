package org.example.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.entity.EmployeeEntity;
import org.example.repository.EmployeeDAO;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public EmployeeEntity getUserByEmail(String email) {
        EmployeeEntity employeeEntity = employeeDAO.findByEmail(email);

        if (employeeEntity == null) {
            return null;
        }

        return employeeEntity;
    }
}
