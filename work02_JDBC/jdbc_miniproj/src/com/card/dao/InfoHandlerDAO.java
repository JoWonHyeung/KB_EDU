package com.card.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;

public interface InfoHandlerDAO {
    void register(Cust cust) throws SQLException, DuplicateSSNException;
    void register(Card card)throws SQLException, DuplicateSSNException;

    void delete(Cust cust)throws SQLException, RecordNotFoundException;
    void delete(Card card)throws SQLException, RecordNotFoundException;

    void updateAddress(Cust cust)throws SQLException, RecordNotFoundException;
    void updatePhonenumber(Cust cust)throws SQLException, RecordNotFoundException;
}

