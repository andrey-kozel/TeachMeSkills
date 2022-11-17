package com.exmaple.hibernate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.exmaple.hibernate.dto.EmployeeCount;
import com.exmaple.hibernate.model.Employee;
import com.exmaple.hibernate.model.Organization;
import com.exmaple.hibernate.model.WorkingPlace;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

public class OrganizationRepository {

  private final Session session;

  public OrganizationRepository(final SessionFactory sessionFactory) {
    session = sessionFactory.openSession();
  }

  public Organization get(Long id) {
    return session.find(Organization.class, id);
  }

  public List<Organization> getAll() {
    final Query<Organization> query = session.createQuery(
      "FROM Organization", Organization.class);
    return query.getResultList();
  }

  public List<Employee> getEmployees(long organizationId) {
    final Query<Employee> query = session.createQuery(
      "SELECT employees FROM Organization WHERE id = :id ", Employee.class);
    query.setParameter("id", organizationId);
    return query.getResultList();
  }

  public List<EmployeeCount> getEmployeesByLastName() {
    final Query<EmployeeCount> query = session.createQuery(
      "SELECT new com.exmaple.hibernate.dto.EmployeeCount(lastName, count(*)) FROM Employee GROUP BY lastName",
      EmployeeCount.class);
    return query.getResultList();
  }

  public List<WorkingPlace> getWorkingPlaces(final String employeeName) {
    final HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
    final CriteriaQuery<WorkingPlace> cr = cb.createQuery(WorkingPlace.class);

    Root<WorkingPlace> root = cr.from(WorkingPlace.class);
    Root<Employee> rootEmployee = cr.from(Employee.class);

    List<Predicate> predicates = new ArrayList<>();
    predicates.add(cb.equal(root.get("employee"), rootEmployee.get("id")));

    Optional.ofNullable(employeeName)
      .ifPresent(name -> predicates.add(cb.equal(rootEmployee.get("name"), name)));

    cr.where(predicates.toArray(new Predicate[]{}));
    cr.select(root);
    Query<WorkingPlace> query = session.createQuery(cr);

    return query.getResultList();
  }

  public void save(Organization organization) {
    session.getTransaction().begin();
    session.persist(organization);
    session.getTransaction().commit();
  }

}
