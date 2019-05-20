package com.chen.service;

import com.chen.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    User findOne(Long id);

    void addOne(User user);

    List<User> findAll();

    Page<User> findByPage(Pageable pageable);
}

