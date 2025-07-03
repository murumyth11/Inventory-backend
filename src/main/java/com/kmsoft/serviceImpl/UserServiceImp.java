package com.kmsoft.serviceImpl;

import com.kmsoft.model.User;
import com.kmsoft.repository.UserRepository;
import com.kmsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService {

	
	@Autowired
	UserRepository registrationRepo;
	
	@Override
	public User fetchByemail(String email) {
		// TODO Auto-generated method stub
		return  registrationRepo.findByUserEmail(email);
	}

	@Override
	public User findByUserNameAndPassword(String tempemail, String temppassword) {
		// TODO Auto-generated method stub
		return registrationRepo.findByUserNameAndPassword(tempemail, temppassword);
	}

	@Override
	public User fetchByusername(String userName) {
		// TODO Auto-generated method stub
		return registrationRepo.findByUserName(userName);
	}

}
