package com.code.spotify.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.spotify.entity.Songs;

@Repository
public class SongsDAOImpl implements SongsDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Songs songs) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(songs);
		//close the session
		//session.close();
			return  songs.getSongid();

	}

	@Override
	public int update(Songs songs) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.saveOrUpdate(songs);
		//close the session
		//session.close();
			return  songs.getSongid();
	}

	@Override
	public int delete(Songs songs) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Songs song=	session.get(Songs.class, songs.getSongname());
	//check the std is null or null if null means no record
	if(song==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(song);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the song eixts the id exists or not
		Songs song=	session.get(Songs.class, id);
	//check the std is null or null if null means no record
	if(song==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(song);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

	@Override
	public List<Songs> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
			//we pass the class and we get the list of the object
			//select * from student
	List<Songs> songs=currentSession.createCriteria(Songs.class).list();
	return songs;
	}

	@Override
	public Songs getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search  eixts the id exists or not
		Songs songs=session.get(Songs.class, id);
		return songs;
	}

	

	

}
