import ir.codefather.entities.AccountEntity;
import ir.codefather.entities.EmployeeEntity;
import ir.codefather.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("paraaaasa@mail.com");
        emp.setFirstName("Parsa");
        emp.setLastName("mihandoost");

        AccountEntity account = new AccountEntity();
        account.setNumber("Dummy account");

        List<AccountEntity> accounts = new ArrayList<>();
        accounts.add(account);
        emp.setAccounts(accounts);

        session.save(emp);
        session.save(account);

        transaction.commit();

        session.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();

        session2.beginTransaction();


        HibernateUtil.shutdown();
    }
}
