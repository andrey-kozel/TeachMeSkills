package com.exmaple.hibernate;

import java.util.List;

import com.exmaple.hibernate.model.Employee;
import com.exmaple.hibernate.model.Organization;
import com.exmaple.hibernate.model.WorkingPlace;
import com.exmaple.hibernate.repository.OrganizationRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

  public static void main(final String[] args) {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
    final OrganizationRepository repository = new OrganizationRepository(entityManagerFactory);
    System.out.println(repository.get(1L));
    System.out.println(repository.getAll());
    System.out.println(repository.getEmployees(2L));
    System.out.println(repository.getEmployeesByLastName());
    System.out.println(repository.getWorkingPlaces("Andrey1"));
    System.out.println(repository.getWorkingPlaces(null));

    final Organization organization = new Organization();
    organization.setName("Name9");
    repository.save(organization);
    System.out.println(organization);

    final Organization organization2 = new Organization();
    organization2.setName("Name10");
    Employee employee = new Employee();
    employee.setName("Name");
    employee.setLastName("LastName");
    employee.setOrganization(organization2);
    organization2.setEmployees(List.of(employee));
    repository.save(organization2);
    System.out.println(organization2);
  }

}
