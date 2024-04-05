package in.co.movie.ticket.service;

import java.util.List;


import in.co.movie.ticket.entity.InvoiceDetailEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;


public interface InvoiceDetailServiceInt {

	public long add(InvoiceDetailEntity bean) throws DuplicateRecordException;
	
	public void update(InvoiceDetailEntity bean) throws DuplicateRecordException;
	
	public void delete(InvoiceDetailEntity bean);
	
	public InvoiceDetailEntity findByName(String name);
	
	public InvoiceDetailEntity findByPk(long id);
	
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean, long pageNo, int pageSize);
	
	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean);
	
	
}
