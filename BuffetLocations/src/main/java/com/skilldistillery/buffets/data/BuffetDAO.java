package com.skilldistillery.buffets.data;

import java.util.List;

import com.skilldistillery.buffets.entities.Buffets;

public interface BuffetDAO {
	public Buffets findById(int id);
	public List<Buffets> findAll();
	
	public boolean createBuffet(Buffets buffet);		//C
	public Buffets getBuffet(int id);					//R
	
	public int bulkUpdate(String oldFn, String newFn);	//U
	public boolean deleteBuffet(int id);				//D
	
}
