package org.spring.springboot.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Transaction;
import org.spring.springboot.domain.Wallet;

import java.util.List;

/**
 * DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface TransactionDao {


    /**
     * 根据 ID，获取信息
     *
     * @param id
     * @return
     */
    List<Transaction> findByTransactionId(@Param("id") long id);

    List<Transaction> findAll();

    long saveTransaction(Transaction transaction);

    long updateTransaction(Transaction transaction);

    long deleteTransaction(long id);
}
