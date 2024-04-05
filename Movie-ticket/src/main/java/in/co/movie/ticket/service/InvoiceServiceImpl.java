package in.co.movie.ticket.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.movie.ticket.dao.InvoiceDAOInt;
import in.co.movie.ticket.entity.InvoiceEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;


@Service
public class InvoiceServiceImpl implements InvoiceServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private InvoiceDAOInt dao;
	
	@Override
	@Transactional
	public long add(InvoiceEntity bean) throws DuplicateRecordException {
		log.info("InvoiceServiceImpl  add method start");
		long pk = dao.add(bean);
		log.info("InvoiceServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(InvoiceEntity bean) throws DuplicateRecordException {
		log.info("InvoiceServiceImpl  update method start");
		InvoiceEntity existEntity = dao.findByName(bean.getName());
		
		dao.update(bean);
		log.info("InvoiceServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(InvoiceEntity bean) {
		log.info("InvoiceServiceImpl  delete method start");
		dao.delete(bean);
		log.info("InvoiceServiceImpl delete method end");
	}

	@Override
	@Transactional
	public InvoiceEntity findByName(String name) {
		log.info("InvoiceServiceImpl  findByLogin method start");
		InvoiceEntity bean = dao.findByName(name);
		log.info("InvoiceServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public InvoiceEntity findByPk(long id) {
		log.info("InvoiceServiceImpl  findByPk method start");
		InvoiceEntity bean = dao.findByPk(id);
		log.info("InvoiceServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<InvoiceEntity> search(InvoiceEntity bean, long pageNo, int pageSize) {
		log.info("InvoiceServiceImpl  search method start");
		List<InvoiceEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("InvoiceServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceEntity> search(InvoiceEntity bean) {
		log.info("InvoiceServiceImpl  search method start");
		List<InvoiceEntity> list = dao.search(bean);
		log.info("InvoiceServiceImpl search method end");
		return list;
	}

	

	

}
