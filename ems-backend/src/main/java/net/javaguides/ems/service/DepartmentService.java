package net.javaguides.ems.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long DepartmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long Id, DepartmentDto Updateddepartment);

    void deleteDepartment(Long Id);

}
