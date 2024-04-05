package in.co.movie.ticket.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.movie.ticket.entity.InvoiceEntity;


public interface InvoiceDAOInt {

	public long add(InvoiceEntity bean);

	public void update(InvoiceEntity bean);

	public void delete(InvoiceEntity bean);

	public InvoiceEntity findByName(String name);

	public InvoiceEntity findByPk(long id);

	public List<InvoiceEntity> search(InvoiceEntity bean, long pageNo, int pageSize);

	public List<InvoiceEntity> search(InvoiceEntity bean);


}
