package com.techbook.service;

import java.util.List;

// we make service to write a core business logic 
import com.techbook.domain.User;

public interface UserService {
	int saveUserInfo(User user); // Dao ko jastai name rakda ne hunxa athava diff rakhda ne hunxa

	int updateUserInfo(User user);

	int deleteUserInfo(int id);

	List<User> getAllUserInfo();
}
