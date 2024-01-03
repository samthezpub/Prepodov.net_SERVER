package com.example.prepodov_net.Controller;


// TODO: придумать нормальное название для класса

import com.example.prepodov_net.Entity.AuthorType;
import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Entity.PostEntity;
import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.Implementation.GroupServiceImplementation;
import com.example.prepodov_net.Services.Implementation.PostServiceImplementation;
import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PagesController {

    private UserServiceImplementation userService;
    private PostServiceImplementation postService;
    private GroupServiceImplementation groupService;
    private PasswordEncoder passwordEncoder;



    /*

        Операции над пользователями

     */

    @GetMapping("/getuser/{id}")
    public ResponseEntity<UserEntity> getUserInfo(@PathVariable Long id) throws Exception {
        UserEntity user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/newuser")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity<>("Неправильное имя или пароль!", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        return new ResponseEntity<>("Пользователь " + user.getUsername() + " успешно добавлен с ID " + user.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            UserEntity user = userService.getUser(id);
            userService.deleteUser(user);

            return new ResponseEntity<>("Пользователь " + user.getUsername() + " успешно удалён!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить пользователя " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/user/{id}/friends")
    public ResponseEntity<List<UserEntity>> getUserFriends(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.getUser(id).getFriends(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        }
    }



    /*

        Операции с постами

     */

    @GetMapping("/post/{post_id}")
    public PostEntity getPostById(@PathVariable Long post_id) throws Exception {
        return postService.getPostById(post_id);
    }

    @PostMapping("/post/create")
    public ResponseEntity<?> createPost(@RequestBody PostEntity post) {
        if (post.getContent() == null) {
            return new ResponseEntity<>("Невозможно создать пустой пост", HttpStatus.BAD_REQUEST);
        }

        postService.savePost(post);
        return new ResponseEntity<>("Пост успешно сохранён", HttpStatus.CREATED);
    }

    @PostMapping("/post/delete/{post_id}")
    public ResponseEntity<?> deletePost(@PathVariable Long post_id) throws Exception {
        try {
            PostEntity post = postService.getPostById(post_id);
            postService.deletePost(post);

            return new ResponseEntity<>("Пост " + post_id + " удалён", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить пост " + post_id, HttpStatus.NOT_FOUND);
        }
    }



    /*

        Операции над группами

     */

    @GetMapping("/groups/{group_id}")
    public GroupEntity getGroupById(@PathVariable Long group_id) throws Exception {
        return groupService.getGroupById(group_id);
    }

    @PostMapping("/groups/create")
    public ResponseEntity<?> createGroup(@RequestBody GroupEntity group) {
//        if (group.getName() == null){
//            return new ResponseEntity<>("Нельзя создать группу без названия!", HttpStatus.BAD_REQUEST);
//        }

        groupService.saveGroup(group);

        return new ResponseEntity<>("Группа \"" + group.getName() + "\" успешно создана!", HttpStatus.CREATED);
    }

    @PostMapping("/groups/delete/{group_id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long group_id) {
        try {
            GroupEntity group = groupService.getGroupById(group_id);
            groupService.deleteGroup(group);

            return new ResponseEntity<>("Группа " + group.getName() + " успешно удалена!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить группу " + group_id, HttpStatus.NOT_FOUND);
        }
    }
}
