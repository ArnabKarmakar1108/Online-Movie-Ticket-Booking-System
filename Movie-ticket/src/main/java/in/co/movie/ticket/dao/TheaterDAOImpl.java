package in.co.movie.ticket.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.movie.ticket.entity.TheaterEntity;


@Repository
public class TheaterDAOImpl implements TheaterDAOInt {

	@Autowired
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(TheaterEntity bean) {
		log.info("TheatreDAOImpl  add method start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(bean);
		log.info("TheatreDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(TheaterEntity bean) {
		log.info("TheatreDAOImpl  update method start");
		entityManager.unwrap(Session.class).merge(bean);
		log.info("TheatreDAOImpl  update method end");
	}

	@Override
	public void delete(TheaterEntity bean) {
		log.info("TheatreDAOImpl  delete method start");
		entityManager.remove(entityManager.contains(bean)?bean:entityManager.merge(bean));
		log.info("TheatreDAOImpl  delete method end");
	}

	@Override
	public TheaterEntity findByName(String name) {
		log.info("TheatreDAOImpl  login method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TheaterEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("TheatreDAOImpl  login method end");
		return (TheaterEntity) criteria.uniqueResult();
	}

	@Override
	public TheaterEntity findByPk(long id) {
		log.info("TheatreDAOImpl  findPk method start");
		Session session = entityManager.unwrap(Session.class);
		log.info("TheatreDAOImpl  findPK method end");
		return session.get(TheaterEntity.class, id);
	}

	@Override
	public List<TheaterEntity> search(TheaterEntity bean, long pageNo, int pageSize) {
		log.info("TheatreDAOImpl  search method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TheaterEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("name", bean.getName() + "%"));
			}
			if (bean.getCity() != null && bean.getCity() .length() > 0) {
				criteria.add(Restrictions.like("city", bean.getCity() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("TheatreDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<TheaterEntity> search(TheaterEntity bean) {
		log.info("TheatreDAOImpl  search method start");

		log.info("TheatreDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("TheatreDAOImpl getImageById  method start");
		Session session=entityManager.unwrap(Session.class);
		TheaterEntity person = (TheaterEntity) session.get(TheaterEntity.class, id);
        byte[] blob = person.getImage();
        Blob bBlob= new SerialBlob(blob);
		log.info("TheatreDAOImpl getImageById method end");
		return bBlob;
	}

}
