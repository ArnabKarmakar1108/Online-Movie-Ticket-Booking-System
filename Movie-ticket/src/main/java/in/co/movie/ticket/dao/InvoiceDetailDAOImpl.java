package in.co.movie.ticket.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.movie.ticket.entity.InvoiceDetailEntity;


@Repository
public class InvoiceDetailDAOImpl implements InvoiceDetailDAOInt {

	@Autowired
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailDAOImpl  add method start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(bean);
		log.info("InvoiceDetailDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailDAOImpl  update method start");
		entityManager.unwrap(Session.class).merge(bean);
		log.info("InvoiceDetailDAOImpl  update method end");
	}

	@Override
	public void delete(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailDAOImpl  delete method start");
		entityManager.remove(entityManager.contains(bean)?bean:entityManager.merge(bean));
		log.info("InvoiceDetailDAOImpl  delete method end");
	}

	@Override
	public InvoiceDetailEntity findByName(String name) {
		log.info("InvoiceDetailDAOImpl  login method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(InvoiceDetailEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("InvoiceDetailDAOImpl  login method end");
		return (InvoiceDetailEntity) criteria.uniqueResult();
	}

	@Override
	public InvoiceDetailEntity findByPk(long id) {
		log.info("InvoiceDetailDAOImpl  findPk method start");
		Session session = entityManager.unwrap(Session.class);
		log.info("InvoiceDetailDAOImpl  findPK method end");
		return session.get(InvoiceDetailEntity.class, id);
	}

	@Override
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean, long pageNo, int pageSize) {
		log.info("InvoiceDetailDAOImpl  search method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(InvoiceDetailEntity.class);
		if (bean != null) {
			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getUserId() > 0) {
				criteria.add(Restrictions.eq("userId", bean.getUserId()));
			}
			if (bean.getInvoiceNumber() != null && bean.getInvoiceNumber().length() > 0) {
				criteria.add(Restrictions.like("invoiceNumber", bean.getInvoiceNumber() + "%"));
			}
			if (bean.getShow_time() != null && bean.getShow_time().length() > 0) {
				criteria.add(Restrictions.like("show_time", bean.getShow_time() + "%"));
			}
			if (bean.getMovieName() != null && bean.getMovieName().length() > 0) {
				criteria.add(Restrictions.like("movieName", bean.getMovieName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("InvoiceDetailDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailDAOImpl  search method start");
		log.info("InvoiceDetailDAOImpl search method end");
		return search(bean, 0, 0);
	}

	

}
