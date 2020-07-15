package org.spring.springboot.service;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;

import java.util.List;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    List<User> findById(long userName);
    List<User> findByName(String userName);
    void setCity(List<User> list);
    Long saveUser(User user);
    Long deleteUser(Long id);

}
