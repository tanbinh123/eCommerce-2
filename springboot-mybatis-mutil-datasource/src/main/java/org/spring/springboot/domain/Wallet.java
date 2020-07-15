package org.spring.springboot.domain;

/**
 * 钱包实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class Wallet {


    private long id;

    private long money;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
