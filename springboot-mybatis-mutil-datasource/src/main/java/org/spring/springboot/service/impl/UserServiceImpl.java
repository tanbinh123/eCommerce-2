package org.spring.springboot.service.impl;

import org.spring.springboot.dao.cluster.CityDao;
import org.spring.springboot.dao.master.UserDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源


    @Override
    public List<User> findById(long id) {
        List<User> list = userDao.findById(id);
        setCity(list);
//        User user = userDao.findByName(userName);
//        City city = cityDao.findById(user.getId());
//        user.setCity(city);
        return list;
    }

    @Override
    public List<User> findByName(String userName) {
        List<User> list = userDao.findByName(userName);
        setCity(list);
//        User user = userDao.findByName(userName);
//        City city = cityDao.findById(user.getId());
//        user.setCity(city);
        return list;
    }

    @Override
    public void setCity(List<User> list) {
        for(User myUser : list){
            myUser.setCity(cityDao.findById(myUser.getId()));
        }
    }

}
