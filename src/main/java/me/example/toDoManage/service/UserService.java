package me.example.toDoManage.service;

import me.example.toDoManage.config.TodoAppProperties;
import me.example.toDoManage.model.entity.ToDo;
import me.example.toDoManage.model.payload.ObjectRes;
import me.example.toDoManage.model.payload.StatusRes;
import me.example.toDoManage.model.payload.TodoRes;
import me.example.toDoManage.model.payload.UserRes;
import me.example.toDoManage.security.CustomUserDetails;
import me.example.toDoManage.model.entity.User;
import me.example.toDoManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Lấy người dùng qua username
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    /**
     * lấy người dùng qua id
     * @param id
     * @return
     */
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new UsernameNotFoundException(id.toString());
        }
        return new CustomUserDetails(user);
    }

    /**
     * Thêm người dùng
     * @param user
     * @return
     */
    public ObjectRes addUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            // Người dùng đã tồn tại
            return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.validateRegisterUserId), null);
        } else {
            if(checkUserName(user.getUsername())) {
                return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.validateRegisterUserName), null);
            } else {
                userRepository.save(user);
                UserRes userRes = new UserRes(user.getId(), user.getUsername());
                return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successAddUser), userRes);
            }
        }

    }

    /**
     * Trả về danh sách tất cả người dùng
     * @param
     * @return
     */
    public ObjectRes getAllUser() {
        List<UserRes> userResList = new ArrayList<>();
        if (userRepository.findAll() == null) {
            return new ObjectRes(new StatusRes(StatusRes.STATUS_404, TodoAppProperties.successGetAllUser), null);
        }
        for (User user : userRepository.findAll()) {
            UserRes userRes = new UserRes(user.getId(), user.getUsername());
            userResList.add(userRes);
        }
        return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successGetAllUser), userResList);
    }

    /**
     * Đăng nhập
     * @param user
     * @return
     */
    public ObjectRes login(User user) {
        if (!checkUserName(user.getUsername())) {
            return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.failLogin), null);
        } else {
            User userCheck = userRepository.findByUsername(user.getUsername());
            if (userCheck.getPassword() == (user.getPassword())) {
                return new ObjectRes(new StatusRes(StatusRes.STATUS_400, TodoAppProperties.failPass), null);
            } else {
                UserRes userRes = new UserRes(userCheck.getId(), userCheck.getUsername());
                return new ObjectRes(new StatusRes(StatusRes.STATUS_200, TodoAppProperties.successLogin), userRes);
            }
        }
    }

    public boolean checkUserName(String userName) {
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
