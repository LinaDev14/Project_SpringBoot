package com.co.pruebaimagine.backend_parte1.application.service.user;

import com.co.pruebaimagine.backend_parte1.application.mappers.UserMapper;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import com.co.pruebaimagine.backend_parte1.domain.repository.UserRepository;

import com.co.pruebaimagine.backend_parte1.domain.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInterface{

    // repository
    private final UserRepository userRepository;

    // mapper
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> fillData(List<UserDTO> userDTO) {
        return userRepository.saveAll(userDTO.stream()
                .map(userMapper.mapToCollectionUser())
                .collect(Collectors.toList()))
                .stream()
                .map(userMapper.mapToDTOUser())
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> listUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper.mapToDTOUser())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(String id) {
        return userRepository.findById(id)
                .map(userMapper.mapToDTOUser());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.mapToDTOUser()
                .apply(userRepository.save(userMapper.mapToCollectionUser()
                        .apply(userDTO)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        if(userRepository.findById(userDTO.getId()).isEmpty()){
            throw new IllegalArgumentException(MessageResponse.USER_NOT_FOUND);
        }
        return userMapper.mapToDTOUser().apply(userRepository.save(userMapper.mapToCollectionUser().apply(userDTO)));

    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public List<UserDTO> findByUserName(String userName) {
        return userRepository.findAllByUserNameContainingIgnoreCaseOrderByUserName(userName)
                .stream()
                .map(userMapper.mapToDTOUser())
                .collect(Collectors.toList());
    }
}
