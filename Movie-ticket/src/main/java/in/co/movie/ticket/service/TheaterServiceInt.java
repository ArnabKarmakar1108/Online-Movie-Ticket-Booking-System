package in.co.movie.ticket.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.movie.ticket.entity.TheaterEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;


public interface TheaterServiceInt {

	public long add(TheaterEntity bean) throws DuplicateRecordException;
	
	public void update(TheaterEntity bean) throws DuplicateRecordException;
	
	public void delete(TheaterEntity bean);
	
	public TheaterEntity findByName(String name);
	
	public TheaterEntity findByPk(long id);
	
	public List<TheaterEntity> search(TheaterEntity bean, long pageNo, int pageSize);
	
	public List<TheaterEntity> search(TheaterEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
