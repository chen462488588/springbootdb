package com.chen.service;

import com.chen.entity.User;

import java.util.List;

public interface ISendMailService {
    boolean sendMail(List<User> users);
}
