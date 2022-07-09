package com.techbook.dao;

import java.util.List;

import com.techbook.domain.User;

public interface UserDao {
 // void saveUserInfo(User user );
  int   saveUserInfo(User user );
  int updateUserInfo(User user);
  int deleteUserInfo(int id);
  List<User>getAllUserInfo();}
