package com.chen.service.impl;

import com.chen.dao.UserRepository;
import com.chen.entity.User;
import com.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void addOne(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
