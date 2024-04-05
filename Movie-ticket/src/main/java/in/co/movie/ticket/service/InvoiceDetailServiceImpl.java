package in.co.movie.ticket.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.movie.ticket.dao.InvoiceDetailDAOInt;
import in.co.movie.ticket.entity.InvoiceDetailEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;


@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private InvoiceDetailDAOInt dao;
	
	@Override
	@Transactional
	public long add(InvoiceDetailEntity bean) throws DuplicateRecordException {
		log.info("InvoiceDetailServiceImpl  add method start");
		long pk = dao.add(bean);
		log.info("InvoiceDetailServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(InvoiceDetailEntity bean) throws DuplicateRecordException {
		log.info("InvoiceDetailServiceImpl  update method start");
		dao.update(bean);
		log.info("InvoiceDetailServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailServiceImpl  delete method start");
		dao.delete(bean);
		log.info("InvoiceDetailServiceImpl delete method end");
	}

	@Override
	@Transactional
	public InvoiceDetailEntity findByName(String name) {
		log.info("InvoiceDetailServiceImpl  findByLogin method start");
		InvoiceDetailEntity bean = dao.findByName(name);
		log.info("InvoiceDetailServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public InvoiceDetailEntity findByPk(long id) {
		log.info("InvoiceDetailServiceImpl  findByPk method start");
		InvoiceDetailEntity bean = dao.findByPk(id);
		log.info("InvoiceDetailServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean, long pageNo, int pageSize) {
		log.info("InvoiceDetailServiceImpl  search method start");
		List<InvoiceDetailEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("InvoiceDetailServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean) {
		log.info("InvoiceDetailServiceImpl  search method start");
		List<InvoiceDetailEntity> list = dao.search(bean);
		log.info("InvoiceDetailServiceImpl search method end");
		return list;
	}

	

	

}
