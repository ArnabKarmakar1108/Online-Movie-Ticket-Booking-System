package in.co.movie.ticket.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.movie.ticket.dao.MovieDAOInt;
import in.co.movie.ticket.entity.MovieEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;

@Service
public class MovieServiceImpl implements MovieServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private MovieDAOInt dao;
	
	@Override
	@Transactional
	public long add(MovieEntity bean) throws DuplicateRecordException {
		log.info("MovieServiceImpl  add method start");
		MovieEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null) {
			throw new DuplicateRecordException("Movie is already Exist");
		}
		long pk = dao.add(bean);
		log.info("MovieServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(MovieEntity bean) throws DuplicateRecordException {
		log.info("MovieServiceImpl  update method start");
		MovieEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null && existEntity.getId() != bean.getId()) {
			throw new DuplicateRecordException("Movie is already Exist");
		}
		dao.update(bean);
		log.info("MovieServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(MovieEntity bean) {
		log.info("MovieServiceImpl  delete method start");
		dao.delete(bean);
		log.info("MovieServiceImpl delete method end");
	}

	@Override
	@Transactional
	public MovieEntity findByName(String name) {
		log.info("MovieServiceImpl  findByLogin method start");
		MovieEntity bean = dao.findByName(name);
		log.info("MovieServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public MovieEntity findByPk(long id) {
		log.info("MovieServiceImpl  findByPk method start");
		MovieEntity bean = dao.findByPk(id);
		log.info("MovieServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<MovieEntity> search(MovieEntity bean, long pageNo, int pageSize) {
		log.info("MovieServiceImpl  search method start");
		List<MovieEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("MovieServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<MovieEntity> search(MovieEntity bean) {
		log.info("MovieServiceImpl  search method start");
		List<MovieEntity> list = dao.search(bean);
		log.info("MovieServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("MovieServiceImpl  getImageById method start");
		log.info("MovieServiceImpl  getImageById method end");
		return dao.getImageById(id);
	}

	
}
