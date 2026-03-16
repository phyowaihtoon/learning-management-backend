package com.creatip.lms.controller;

import com.creatip.lms.controller.errors.BadRequestAlertException;
import com.creatip.lms.controller.errors.EmailAlreadyUsedException;
import com.creatip.lms.controller.errors.LoginAlreadyUsedException;
import com.creatip.lms.controller.util.HeaderUtil;
import com.creatip.lms.controller.util.PaginationUtil;
import com.creatip.lms.domain.base.User;
import com.creatip.lms.repository.UserRepository;
import com.creatip.lms.service.UserService;
import com.creatip.lms.service.dto.AdminUserDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private String applicationName = "Learning Management System";

    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody AdminUserDTO userDTO) throws URISyntaxException {
        
        if (userDTO.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else if (userRepository.findOneByUsername(userDTO.getUsername().toLowerCase()).isPresent()) {
            throw new LoginAlreadyUsedException();
        } else if (userDTO.getEmail() != null && userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        } else {
            
            User newUser = userService.createUser(userDTO);
            //mailService.sendCreationEmail(newUser);
            
            return ResponseEntity
                    .created(new URI("/api/admin/users/" + newUser.getUsername()))
                    .headers(HeaderUtil.createAlert(applicationName, "userManagement.created", newUser.getUsername()))
                    .body(newUser);

        }
    }

    @RequestMapping("/users")
    public ResponseEntity<List<AdminUserDTO>> getAllUsers(Pageable pageable) {

        final Page<AdminUserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);

    }
}
