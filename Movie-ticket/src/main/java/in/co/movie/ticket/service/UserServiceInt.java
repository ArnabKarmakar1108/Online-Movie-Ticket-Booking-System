package in.co.movie.ticket.service;

import java.util.List;

import in.co.movie.ticket.entity.UserEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;



public interface UserServiceInt {

	public long add(UserEntity bean) throws DuplicateRecordException;
	
	public void delete(UserEntity bean) ;
	
	public void update(UserEntity bean) throws DuplicateRecordException;
	
	public UserEntity findByPK(long pk) ;
	
	public UserEntity findByLogin(String login) ;
	
	public List<UserEntity> search(UserEntity bean);
	
	public List search(UserEntity bean, int pageNo, int pageSize) ;
	 
    
    
    public UserEntity authenticate(UserEntity bean);

    public long registerUser(UserEntity bean) throws DuplicateRecordException  ;
    
    public boolean forgetPassword(String login);
    
    public boolean changePassword(Long id, String oldPassword, String newPassword);
	
}
