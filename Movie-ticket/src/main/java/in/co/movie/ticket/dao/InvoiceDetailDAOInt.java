package in.co.movie.ticket.dao;

import java.util.List;


import in.co.movie.ticket.entity.InvoiceDetailEntity;


public interface InvoiceDetailDAOInt {

	public long add(InvoiceDetailEntity bean);

	public void update(InvoiceDetailEntity bean);

	public void delete(InvoiceDetailEntity bean);

	public InvoiceDetailEntity findByName(String name);

	public InvoiceDetailEntity findByPk(long id);

	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean, long pageNo, int pageSize);

	public List<InvoiceDetailEntity> search(InvoiceDetailEntity bean);
	


}
