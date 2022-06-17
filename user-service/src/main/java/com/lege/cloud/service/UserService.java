package com.lege.cloud.service;

import com.lege.cloud.domain.User;

import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-06-17 15:25
 */
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
