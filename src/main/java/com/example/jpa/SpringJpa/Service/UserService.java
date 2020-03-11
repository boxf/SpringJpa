package com.example.jpa.SpringJpa.Service;

import com.example.jpa.SpringJpa.Exception.ConflictException;
import com.example.jpa.SpringJpa.bean.User;
import com.example.jpa.SpringJpa.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StorageService storageService;

    public User register(User user) {
        if (userRepository.getUserByEmail(user.getEmail()) == null) {
            userRepository.save(user);
            return user;
        } else {
            throw new ConflictException();

        }
    }
    public User register(User user, MultipartFile file) {
        if (userRepository.getUserByEmail(user.getEmail()) == null) {
            storageService.savePicture(file);
            user.setImageName(file.getOriginalFilename());
            userRepository.save(user);
            return user;
        } else {
            throw new ConflictException();

        }
    }
    public List<User> findAllUsers(){
        return (List) userRepository.findAll();
    }
    public User findUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

}
