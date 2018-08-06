package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        userRepository.save(entity);

    }
    public List<User> fetchUsers(){
        List<UserEntity> usersEntity = (List<UserEntity>) userRepository.findAll();
        List<User> users = new ArrayList<>();

        for(UserEntity user : usersEntity){
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            users.add(newUser);
        }

        return usersEntity.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }
}
