package pendzu.sduteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pendzu.sduteam.models.User;
import pendzu.sduteam.services.impl.UserServiceImpl;

import java.util.List;

@RequestMapping("/api/sdu")
@RestController
@CrossOrigin(origins = "*")
public class UserRestAPIs {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> showListUser(){
        return ResponseEntity.ok((List<User>) userService.findAll());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/block/{id}")
    public ResponseEntity<Void> blockUser(@PathVariable Long id){
        userService.blockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}