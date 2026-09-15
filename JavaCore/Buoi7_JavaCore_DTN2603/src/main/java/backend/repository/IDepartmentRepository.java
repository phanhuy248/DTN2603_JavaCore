package backend.repository;

import entity.Department;
import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    boolean themDepartment(String departmentName);
    boolean xoaDepartmentTheoId(int id);
    boolean suaDepartmentNameTheoId(int id, String newName);
}