package com.kmsoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.UserRegistration;
import com.kmsoft.repository.RegistrationRepository;
import com.kmsoft.service.RegistrationService;
@Service
public class RegistrationSerImp implements RegistrationService {

	
	@Autowired
	RegistrationRepository registrationRepo;
	
	@Override
	public UserRegistration fetchByemail(String email) {
		// TODO Auto-generated method stub
		return  registrationRepo.findByUserEmail(email);
	}

	@Override
	public UserRegistration findByUserEmailAndPassword(String tempemail, String temppassword) {
		// TODO Auto-generated method stub
		return registrationRepo.findByUserEmailAndPassword(tempemail, temppassword);
	}

}
