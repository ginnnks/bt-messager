package lt.bt.messager.messanger.dto;

import lt.bt.messager.messanger.entity.UserEntity;

public class User {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void User(UserEntity entity){
        setUsername(entity.getUsername());
    }

    public User(){}

    public User(UserEntity usr){setUsername(
            usr.getUsername());
    }
}
