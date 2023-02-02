import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<PurchaseList> pur = session.createQuery("From PurchaseList").getResultList();
        List<Student> stu = session.createQuery("From " + Student.class.getSimpleName()).getResultList();
        List<Course> cou = session.createQuery("From " + Course.class.getSimpleName()).getResultList();

        for (PurchaseList p : pur){
            Student student = stu.stream().filter(s -> s.getName().equals(p.getStudentName())).findFirst().get();
            Course course = cou.stream().filter(c -> c.getName().equals(p.getCourseName())).findFirst().get();
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(student.getId(), course.getId());
            session.save(linkedPurchaseList);
        }

 /*       String hql = "CREATE TABLE my_base.LinkedPurchaseList ( UNIQUE KEY `unq` (`student_id`,`course_id`),\n" +
                "  KEY `course_idx` (`course_id`)) AS \n" +
                "SELECT my_base.students.id AS student_id, my_base.courses.id AS course_id\n" +
                "FROM my_base.courses\n" +
                "JOIN my_base.purchaselist\n" +
                "ON my_base.courses.name = my_base.purchaselist.course_name\n" +
                "JOIN my_base.students\n" +
                "ON my_base.purchaselist.student_name = my_base.students.name";
        Query query = session.createSQLQuery(hql);
        query.executeUpdate();*/


        transaction.commit();
        sessionFactory.close();
    }
}
