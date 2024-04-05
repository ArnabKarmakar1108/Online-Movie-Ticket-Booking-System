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

import in.co.movie.ticket.entity.MovieEntity;

@Repository
public class MovieDAOImpl implements MovieDAOInt {

	@Autowired
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(MovieEntity bean) {
		log.info("MovieDAOImpl  add method start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(bean);
		log.info("MovieDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(MovieEntity bean) {
		log.info("MovieDAOImpl  update method start");
		entityManager.unwrap(Session.class).merge(bean);
		log.info("MovieDAOImpl  update method end");
	}

	@Override
	public void delete(MovieEntity bean) {
		log.info("MovieDAOImpl  delete method start");
		entityManager.remove(entityManager.contains(bean)?bean:entityManager.merge(bean));
		log.info("MovieDAOImpl  delete method end");
	}

	@Override
	public MovieEntity findByName(String name) {
		log.info("MovieDAOImpl  login method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovieEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("MovieDAOImpl  login method end");
		return (MovieEntity) criteria.uniqueResult();
	}

	@Override
	public MovieEntity findByPk(long id) {
		log.info("MovieDAOImpl  findPk method start");
		Session session = entityManager.unwrap(Session.class);
		log.info("MovieDAOImpl  findPK method end");
		return session.get(MovieEntity.class, id);
	}

	@Override
	public List<MovieEntity> search(MovieEntity bean, long pageNo, int pageSize) {
		log.info("MovieDAOImpl  search method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovieEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getTheaterId() > 0) {
				criteria.add(Restrictions.eq("theaterId", bean.getTheaterId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("name", bean.getName() + "%"));
			}
			if (bean.getLanguage() != null && bean.getLanguage().length() > 0) {
				criteria.add(Restrictions.like("language", bean.getLanguage() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("MovieDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<MovieEntity> search(MovieEntity bean) {
		log.info("MovieDAOImpl  search method start");

		log.info("MovieDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("MovieDAOImpl getImageById  method start");
		Session session=entityManager.unwrap(Session.class);
		MovieEntity person = (MovieEntity) session.get(MovieEntity.class, id);
        byte[] blob = person.getImage();
        Blob bBlob= new SerialBlob(blob);
		log.info("MovieDAOImpl getImageById method end");
		return bBlob;
	}

}
