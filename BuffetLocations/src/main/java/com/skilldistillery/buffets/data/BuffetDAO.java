package com.skilldistillery.buffets.data;

import java.util.List;

import com.skilldistillery.buffets.entities.Buffets;

public interface BuffetDAO {
	Buffets findById(int id);
	List<Buffets> findAll();
}
