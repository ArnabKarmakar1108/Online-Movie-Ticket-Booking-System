package in.co.movie.ticket.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.movie.ticket.entity.TheaterEntity;

public interface TheaterDAOInt {

	public long add(TheaterEntity bean);
	
	public void update(TheaterEntity bean);
	
	public void delete(TheaterEntity bean);
	
	public TheaterEntity findByName(String name);
	
	public TheaterEntity findByPk(long id);
	
	public List<TheaterEntity> search(TheaterEntity bean, long pageNo, int pageSize);
	
	public List<TheaterEntity> search(TheaterEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
