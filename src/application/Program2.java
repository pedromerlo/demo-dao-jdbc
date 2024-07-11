package application;

import model.dao.DaoFactory;
import model.dao.DepartamentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        DepartamentDao departamentDao = DaoFactory.createDepartmentDao();
        Department department  = departamentDao.findById(2);
        System.out.println(department);

        
    }
}
