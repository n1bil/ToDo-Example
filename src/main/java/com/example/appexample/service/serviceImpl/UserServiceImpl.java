package com.example.appexample.service.serviceImpl;

import com.example.appexample.entity.User;
import com.example.appexample.exception.IsAlreadyExistException;
import com.example.appexample.exception.NotFoundException;
import com.example.appexample.payload.UserDtoRequest;
import com.example.appexample.payload.UserDtoResponse;
import com.example.appexample.repository.UserRepository;
import com.example.appexample.utils.UserConverters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final UserConverters converters;


    // Получить список всех пользователей

    public List<UserDtoResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(converters::converterFromUserToResponse)
                .toList();
    }

    //Найти пользователя по email

    public UserDtoResponse findUserByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            return converters.converterFromUserToResponse(userOptional.get());
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }

    // Создать нового пользователя

    public UserDtoResponse createUser(UserDtoRequest request){
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            User newUser = converters.converterFromRequestToUser(request);

            User savedUser = userRepository.save(newUser);
            return converters.converterFromUserToResponse(savedUser);
        } else {
            throw new IsAlreadyExistException("Manager with email: " + request.getEmail() + " is already exist!");
        }
    }

    public UserDtoResponse findUserById(Integer id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));

        return converters.converterFromUserToResponse(foundUser);
    }

}
