import hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member m1 = new Member();
            m1.setUserName("A");

            Member m2 = new Member();
            m2.setUserName("B");

            Member m3 = new Member();
            m3.setUserName("C");

            System.out.println("m1 = " + m1.getId());
            System.out.println("m2 = " + m2.getId());
            System.out.println("m3 = " + m3.getId());
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}