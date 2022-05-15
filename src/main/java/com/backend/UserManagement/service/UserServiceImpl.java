package com.backend.UserManagement.service;

import com.backend.Thesis.repository.ThesisRepository;
import com.backend.UserManagement.Exception.ResourceNotFoundException;
import com.backend.UserManagement.entity.Roles;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.repository.RolesRepository;
import com.backend.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> getAllAdmin() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Admin"));
    }

    @Override
    public List<User> getAllCompany() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Company"));
    }

    @Override
    public List<User> getAllStudent() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Student"));
    }

    @Override
    public List<User> getAllProfessor() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Professor"));
    }

    @Override
    public String saveUser(User user, String roleName) {
        if (getUserByMail(user.getMail()) != null) {
            return "mailExists";
        }
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        User newUser = new User(user);
        Roles role = roleService.findByName(roleName);
        newUser.setRole(role);
        userRepository.save(newUser);
        return "Success";
    }

    @Override
    public User getUserById(long id) {
        User user = new User(userRepository.findById(id).get());
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).get();

        if (Objects.nonNull(user.getCompanyName()) && !"".equalsIgnoreCase(user.getCompanyName())) {
            existingUser.setCompanyName(user.getCompanyName());
        }

        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
            existingUser.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
            existingUser.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getMail()) && !"".equalsIgnoreCase(user.getMail())) {
            existingUser.setMail(user.getMail());
        }

        if (Objects.nonNull(user.getTel()) && !"".equalsIgnoreCase(user.getTel())) {
            existingUser.setTel(user.getTel());
        }

        if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
            existingUser.setAddress(user.getAddress());
        }

        if (Objects.nonNull(user.getFieldOfStudy()) && !"".equalsIgnoreCase(user.getFieldOfStudy())) {
            existingUser.setFieldOfStudy(user.getFieldOfStudy());
        }

        if (Objects.nonNull(user.getCampus()) && !"".equalsIgnoreCase(user.getCampus())) {
            existingUser.setCampus(user.getCampus());
        }

        if (Objects.nonNull(user.getCoordinator()) && !"".equals(user.getCoordinator())) {
            existingUser.setCoordinator(user.getCoordinator());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).get();
        user.setRole(null);
        userRepository.save(user);
        userRepository.deleteById(id);
    }

    @Override
    public void toggleBookmark(long thesisId, long userId) {
        List<User> bookmarksThesis = userRepository.findAllByBookmarksId(thesisId);
        for (int i = 0; i < bookmarksThesis.size(); i++) {
            if (bookmarksThesis.get(i).getId() == userId) {
                bookmarksThesis.get(i).removeBookmark(thesisId);
                userRepository.save(bookmarksThesis.get(i));
                return;
            }
        }
        User user = userRepository.findById(userId).get();
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }
        user.addBookmark(thesisRepository.findById(thesisId).get());
        userRepository.save(user);
        return;
    }

    @Override
    public Boolean isCoordinator(long userId){
        User user = userRepository.findById(userId).get();
        return user.getCoordinator();
    }

}
