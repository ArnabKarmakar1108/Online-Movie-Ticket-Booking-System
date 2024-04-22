package in.co.movie.ticket.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.movie.ticket.entity.UserEntity;



@Repository
public class UserDAOimpl implements UserDAOInt {

	@Autowired
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(getClass().getName());

	@Override
	@Transactional
	public long add(UserEntity bean) {
		log.info("UserDAOImpl  add method start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(bean);
		log.info("UserDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(UserEntity bean) {
		log.info("UserDAOImpl  update method start");
		entityManager.unwrap(Session.class).merge(bean);
		log.info("UserDAOImpl  update method end");
	}

	@Override
	public void delete(UserEntity bean) {
		log.info("UserDAOImpl  delete method start");
		entityManager.remove(entityManager.contains(bean)?bean:entityManager.merge(bean));
		log.info("UserDAOImpl  delete method end");
	}

	@Override
	public UserEntity findByLogin(String login) {
		log.info("UserDAOImpl  login method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("login", login));
		log.info("UserDAOImpl  login method end");
		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	public UserEntity findByPk(long id) {
		log.info("UserDAOImpl  findPk method start");
		Session session = entityManager.unwrap(Session.class);
		log.info("UserDAOImpl  findPK method end");
		return session.get(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize) {
		log.info("UserDAOImpl  search method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", bean.getFirstName() + "%"));
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", bean.getLastName() + "%"));
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", bean.getLogin() + "%"));
			}
			
			if (bean.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", bean.getRoleId()));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("UserDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<UserEntity> search(UserEntity bean) {
		log.info("UserDAOImpl  search method start");

		log.info("UserDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public UserEntity authenticate(UserEntity bean) {
		log.info("UserDAOImpl  Authenticate method start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserEntity.class);
		//We use the CriteriaBuilder to create a criteria query (CriteriaQuery<UserEntity>).
		criteria.add(Restrictions.like("login", bean.getLogin()));
		criteria.add(Restrictions.like("password", bean.getPassword()));
		log.info("UserDAOImpl  Authenticate method end");
		return (UserEntity)criteria.uniqueResult();
	}

}
