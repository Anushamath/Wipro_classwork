package com.company.hiborm;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.company.hiborm.model.Employee;
import com.company.hiborm.util.HibernateUtil;

public class HQLCrud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        System.out.println("\n===== HQL Employee Operations =====");
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
                Query<Employee> query1 = session.createQuery("FROM Employee", Employee.class);
                List<Employee> employees = query1.list();
                System.out.println("\n===== Employee List (HQL) =====");
                for (Employee e : employees) {
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
                session.save(emp);

                System.out.println("Employee inserted (HQL) successfully!");
                break;

            case 3: // Update
                System.out.print("Enter employee ID to update: ");
                int updateId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = sc.nextLine();

                String hqlUpdate = "UPDATE Employee SET email = :email WHERE id = :id";
                Query<?> query2 = session.createQuery(hqlUpdate);
                query2.setParameter("email", newEmail);
                query2.setParameter("id", updateId);
                int updatedRow = query2.executeUpdate();

                System.out.println("Employee updated (HQL), rows affected: " + updatedRow);
                break;

            case 4: // Delete
                System.out.print("Enter employee ID to delete: ");
                int deleteId = sc.nextInt();

                String hqlDelete = "DELETE FROM Employee WHERE id = :id";
                Query<?> query3 = session.createQuery(hqlDelete);
                query3.setParameter("id", deleteId);
                int deletedRow = query3.executeUpdate();

                System.out.println("Employee deleted (HQL), rows affected: " + deletedRow);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        tx.commit();
        session.close();
        sc.close();
    }
}