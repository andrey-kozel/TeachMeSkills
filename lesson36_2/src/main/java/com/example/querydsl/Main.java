package com.example.querydsl;

import javax.persistence.EntityManager;

import com.example.querydsl.model.Organization;
import com.example.querydsl.model.QOrganization;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
    final EntityManager em = entityManagerFactory.createEntityManager();
    final JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    final Organization organization = queryFactory.selectFrom(QOrganization.organization)
      .where(QOrganization.organization.id.eq(1L))
      .fetchOne();

    System.out.println(organization);
  }

}
