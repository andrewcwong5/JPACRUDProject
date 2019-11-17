package com.skilldistillery.buffets.data;

import java.util.List;

import com.skilldistillery.buffets.entities.Buffets;

public interface BuffetDAO {
	
	
	public Buffets createBuffet(Buffets buffet);		//C
	public Buffets findById(int id);					//R
	
	Buffets updateBuffet(int id, Buffets buffet);		//U
	public boolean deleteBuffet(Buffets buffet);				//D
	
	public List<Buffets> findAll();
}
