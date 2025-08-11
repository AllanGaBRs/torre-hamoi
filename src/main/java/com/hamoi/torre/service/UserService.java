package com.hamoi.torre.service;

import com.hamoi.torre.dto.UserInsertDto;
import com.hamoi.torre.dto.UserMinDto;
import com.hamoi.torre.entity.Role;
import com.hamoi.torre.entity.Score;
import com.hamoi.torre.entity.User;
import com.hamoi.torre.repository.RoleRepository;
import com.hamoi.torre.repository.ScoreRepository;
import com.hamoi.torre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public UserMinDto insert(UserInsertDto userDTO){
        User user = new User();
        copyInsertDtoToEntity(user, userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role roleUser = roleRepository.findByAuthority("ROLE_OPERATOR");
        user.addRole(roleUser);
        user = userRepository.save(user);
        return new UserMinDto(user);
    }


    private void copyInsertDtoToEntity(User entity, UserInsertDto dto){
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
    }


}