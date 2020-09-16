import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("paraaaasa@mail.com");
        emp.setFirstName("Parsa");
        emp.setLastName("mihand");

        session.save(emp);

        transaction.commit();

        HibernateUtil.shutdown();
    }
}
