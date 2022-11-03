package dao;

import bean.Student;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentDaoImplementation implements StudentDao {

    public void addRecord(Student student) {
        EntityManager entityManager= JPAUtil.getFactory().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void updateCityRecord(int id, String newCity) {
        EntityManager entityManager= JPAUtil.getFactory().createEntityManager();

        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class,id);
        student.setCity(newCity);
        entityManager.getTransaction().commit();

    }

    public void updateNameRecord(int id, String newName) {
        EntityManager entityManager= JPAUtil.getFactory().createEntityManager();

        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class,id);
        student.setStudentName(newName);
        entityManager.getTransaction().commit();

    }



    public void deleteRecord(int id) {
        EntityManager entityManager= JPAUtil.getFactory().createEntityManager();

        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public void findByID(int id) {
        EntityManager entityManager= JPAUtil.getFactory().createEntityManager();

        Student student = entityManager.find(Student.class,id);
        System.out.println(student);
    }

    public List<Student> fetch() {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        Query query = em.createQuery(
                " FROM Student ");
        List<Student> studentList = query.getResultList();
        em.close();
        return studentList;
    }
}
