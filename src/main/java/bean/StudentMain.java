package bean;

import dao.StudentDaoImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        new StudentDaoImplementation().fetch();

        while (flag) {
            System.out.println("1.Add Student" +
                    "\n2.Update Student" +
                    "\n3. Delete Student" +
                    "\n4 Find By Id " +
                    "\nEnter your choice :: ");

            int choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter id , name and city of Student");
                    Student student = new Student(Integer.parseInt(bufferedReader.readLine()), bufferedReader.readLine(), bufferedReader.readLine());
                    new StudentDaoImplementation().addRecord(student);
                    break;
                case 2 :
                    System.out.println("Enter id and new  city of Student to be updated :");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    String newCity = bufferedReader.readLine();
                    new StudentDaoImplementation().updateCityRecord(id,newCity);
                    break;
                case 3 :
                    System.out.println("Enter id to be deleted : ");
                    int id1 = Integer.parseInt(bufferedReader.readLine());
                    new StudentDaoImplementation().deleteRecord(id1);
                    break;
                case 4 :
                    System.out.println("Enter id to be fetched : ");
                    int id2 = Integer.parseInt(bufferedReader.readLine());
                    new StudentDaoImplementation().findByID(id2);
                    break;
                default:
                    flag=false;
                    break;

            }
        }



    }
}
