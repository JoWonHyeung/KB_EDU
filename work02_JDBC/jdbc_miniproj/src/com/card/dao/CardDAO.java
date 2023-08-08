package com.card.dao;

import java.sql.SQLException;

import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;

public interface CardDAO {
	void register(Card card)throws SQLException, DuplicateSSNException;
	void delete(String cardId)throws SQLException, RecordNotFoundException;
}
