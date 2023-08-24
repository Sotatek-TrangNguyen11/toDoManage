package me.example.toDoManage.service;

import me.example.toDoManage.model.payload.UserRes;
import me.example.toDoManage.security.CustomUserDetails;
import me.example.toDoManage.model.entity.User;
import me.example.toDoManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new UsernameNotFoundException(id.toString());
        }
        return new CustomUserDetails(user);
    }

    public String addUser(User user) {
        User userCheckId = userRepository.findById(user.getId()).get();
        User userCheckUsername = userRepository.findByUsername(user.getUsername());
        if (userCheckId != null) {
            return "Người dùng đã tồn tại";
        } else if (userCheckUsername != null) {
            return "Tên đăng nhập đã tồn tại";
        } else {
            userRepository.save(user);
            UserRes userRes = new UserRes(user.getId(), user.getUsername());
            return "Thêm người dùng thành công";
        }

    }
}
