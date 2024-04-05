package in.co.movie.ticket.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.movie.ticket.entity.MovieEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;

public interface MovieServiceInt {

public long add(MovieEntity bean) throws DuplicateRecordException;
	
	public void update(MovieEntity bean) throws DuplicateRecordException;
	
	public void delete(MovieEntity bean);
	
	public MovieEntity findByName(String name);
	
	public MovieEntity findByPk(long id);
	
	public List<MovieEntity> search(MovieEntity bean, long pageNo, int pageSize);
	
	public List<MovieEntity> search(MovieEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
