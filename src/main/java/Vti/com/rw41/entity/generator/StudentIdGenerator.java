package Vti.com.rw41.entity.generator;

import Vti.com.rw41.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.Year;

public class StudentIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery("update studentseq set next_val = next_val + 1").executeUpdate();
        Number nextVal = (Number) session.createNativeQuery("select next_val from studentseq").getSingleResult();
        session.getTransaction().commit();
        String stt = String.format("%05d", nextVal.intValue());
        return "SV" + Year.now() + stt;
    }
}
