package net.javaguides.ems.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Department Id does not exists!")
        );
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long Id, DepartmentDto UpdatedDepartment) {
        Department department = departmentRepository.findById(Id).orElseThrow(()->
            new ResourceNotFoundException("Department doesn't exists with the given Id")
        );

        department.setDepartmentName(UpdatedDepartment.getDepartmentName());
        department.setDepartmentDescription(UpdatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return departmentDto;
    }

    @Override
    public void deleteDepartment(Long Id) {
        departmentRepository.deleteById(Id);
    }
}
