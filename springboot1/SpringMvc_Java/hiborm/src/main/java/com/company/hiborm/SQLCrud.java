package com.company.hiborm;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.hiborm.model.Employee;
import com.company.hiborm.util.HibernateUtil;

public class SQLCrud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        System.out.println("\n===== SQL Employee Operations =====");
        System.out.println("1. View All Employees");
        System.out.println("2. Insert Employee");
        System.out.println("3. Update Employee Email");
        System.out.println("4. Delete Employee");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        tx = session.beginTransaction();

        switch (choice) {
            case 1: // View all employees
                List<Employee> empList = session.createNativeQuery("SELECT * FROM employee", Employee.class)
                        .getResultList();
                System.out.println("\n===== Employee List (SQL) =====");
                for (Employee e : empList) {
                    System.out.println(e);
                }
                break;

            case 2: // Insert
                System.out.print("Enter employee name: ");
                String name = sc.nextLine();
                System.out.print("Enter employee email: ");
                String email = sc.nextLine();

                Employee emp = new Employee();
                emp.setName(name);
                emp.setEmail(email);
                session.persist(emp);

                System.out.println("Employee inserted (SQL) successfully!");
                break;

            case 3: // Update
                System.out.print("Enter employee ID to update: ");
                int updateId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = sc.nextLine();

                session.createNativeQuery("UPDATE employee SET email = :email WHERE id = :id")
                        .setParameter("email", newEmail)
                        .setParameter("id", updateId)
                        .executeUpdate();

                System.out.println("Employee updated (SQL) successfully!");
                break;

            case 4: // Delete
                System.out.print("Enter employee ID to delete: ");
                int deleteId = sc.nextInt();

                session.createNativeQuery("DELETE FROM employee WHERE id = :id")
                        .setParameter("id", deleteId)
                        .executeUpdate();

                System.out.println("Employee deleted (SQL) successfully!");
                break;

            default:
                System.out.println("Invalid choice.");
        }

        tx.commit();
        session.close();
        sc.close();
    }
}