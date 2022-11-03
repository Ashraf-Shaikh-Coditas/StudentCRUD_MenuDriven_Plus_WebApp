package dao;

import bean.Student;

public interface StudentDao {
    void addRecord(Student student);
    void updateCityRecord(int id, String newCity);
    void deleteRecord(int id);
    void findByID(int id);
}
