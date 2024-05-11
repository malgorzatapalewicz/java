package org.example.dao;
import org.example.entity.EmployeeEntity;
import org.example.entity.GroupEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GroupDAO {
    private final SessionFactory sessionFactory;

    public GroupDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addGroup(GroupEntity group) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
        }
    }

    public GroupEntity getGroupById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(GroupEntity.class, id);
        }
    }

    public List<GroupEntity> getAllGroups() {
        try (Session session = sessionFactory.openSession()) {
            Query<GroupEntity> query = session.createQuery("from GroupEntity", GroupEntity.class);
            return query.list();
        }
    }

    public List<EmployeeEntity> getEmployeesByGroupId(int groupId) {
        try (Session session = sessionFactory.openSession()) {
            Query<EmployeeEntity> query = session.createQuery("select e from EmployeeEntity e where e.groupId = :groupId", EmployeeEntity.class);
            query.setParameter("groupId", groupId);
            return query.list();
        }
    }

}
