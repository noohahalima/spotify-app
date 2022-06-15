package com.code.spotify.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.spotify.entity.Artists;
import com.code.spotify.entity.Songs;
@Repository
public class ArtistsDAOImpl implements ArtistsDAO {



	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int add(Artists artists) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(artists);
		//close the session
		//session.close();
			return  artists.getArtistid();

	}

	@Override
	public int update(Artists artists) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session=sessionFactory.getCurrentSession();
				//save or update
				//if the primarykey id is null -- save as new new record
				//if the primarykey id is not null -- update the record
				session.saveOrUpdate(artists);
				//close the session
				//session.close();
					return  artists.getArtistid();
	}

	@Override
	public int delete(Artists artists) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the song eixts the id exists or not
		Artists artist=	session.get(Artists.class, artists.getArtistname());
	//check the std is null or null if null means no record
	if(artist==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(artist);
	//close the session
	//session.close();
		return 1;
	}

	@Override
	public int delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		//search the song eixts the id exists or not
		Artists artist=	session.get(Artists.class, id);
	//check the std is null or null if null means no record
	if(artist==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(artist);
	//close the session
	//session.close();
		return 1;///record is updated successfully
	}

	@Override
	public List<Artists> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
			//we pass the class and we get the list of the object
			
	List<Artists> artists=currentSession.createCriteria(Artists.class).list();
	return artists;
	}

	@Override
	public Artists getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search  eixts the id exists or not
		Artists artists=session.get(Artists.class, id);
		return artists;
	}
	
}
