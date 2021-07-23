package com.akaulage.userservice.service;

import com.akaulage.userservice.CommonDTO.Department;
import com.akaulage.userservice.CommonDTO.ResponseTemplate;
import com.akaulage.userservice.entity.User;
import com.akaulage.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplate template=new ResponseTemplate();
        User user=userRepository.findById(userId).get();

        //Restemplate call for getting object from Deparment Service

        Department department=restTemplate.getForObject("http://localhost:8090/departments/"+user.getDepartmentId(),Department.class);
        template.setUser(user);
        template.setDepartment(department);
        return template;
    }
}
