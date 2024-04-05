package in.co.movie.ticket.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.movie.ticket.dao.TheaterDAOInt;
import in.co.movie.ticket.entity.TheaterEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;


@Service
public class TheaterServiceImpl implements TheaterServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private TheaterDAOInt dao;
	
	@Override
	@Transactional
	public long add(TheaterEntity bean) throws DuplicateRecordException {
		log.info("TheatreServiceImpl  add method start");
		TheaterEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null) {
			throw new DuplicateRecordException("Theatre is already Exist");
		}
		long pk = dao.add(bean);
		log.info("TheatreServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(TheaterEntity bean) throws DuplicateRecordException {
		log.info("TheatreServiceImpl  update method start");
		TheaterEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null && existEntity.getId() != bean.getId()) {
			throw new DuplicateRecordException("Theatre is already Exist");
		}
		dao.update(bean);
		log.info("TheatreServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(TheaterEntity bean) {
		log.info("TheatreServiceImpl  delete method start");
		dao.delete(bean);
		log.info("TheatreServiceImpl delete method end");
	}

	@Override
	@Transactional
	public TheaterEntity findByName(String name) {
		log.info("TheatreServiceImpl  findByLogin method start");
		TheaterEntity bean = dao.findByName(name);
		log.info("TheatreServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public TheaterEntity findByPk(long id) {
		log.info("TheatreServiceImpl  findByPk method start");
		TheaterEntity bean = dao.findByPk(id);
		log.info("TheatreServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<TheaterEntity> search(TheaterEntity bean, long pageNo, int pageSize) {
		log.info("TheatreServiceImpl  search method start");
		List<TheaterEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("TheatreServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TheaterEntity> search(TheaterEntity bean) {
		log.info("TheatreServiceImpl  search method start");
		List<TheaterEntity> list = dao.search(bean);
		log.info("TheatreServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("TheatreServiceImpl  getImageById method start");
		log.info("TheatreServiceImpl  getImageById method end");
		return dao.getImageById(id);
	}

	

}
