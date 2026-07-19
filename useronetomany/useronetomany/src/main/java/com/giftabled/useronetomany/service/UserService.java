package com.giftabled.useronetomany.service;

import com.giftabled.useronetomany.model.User;

public interface UserService {

    User saveUser(User user);
    User getUser(int userId);
}
