//package org.example.service;
//
//
//
//import org.example.entity.Users;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//    private List<Users> store= new ArrayList<>();
//    public UserService(){
//        store.add(new Users(UUID.randomUUID().toString(),"Arunain","arunain@gmail.com"));
//        store.add(new Users(UUID.randomUUID().toString(),"Aakash","aakash@gmail.com"));
//
//    }
//
////    public Users getUserByName(String userName) {
////        return store.stream()
////                .filter(user -> user.getName().equals(userName))
////                .findFirst()
////                .orElse(null);
////    }
//
//    public Users updateUser(Users user){
//        store.forEach(
//                e->{
//                    if(e.getUserId().equals(user.getUserId())){
//                        e.setName(user.getName());
//                        e.setEmail(user.getEmail());
//                    }
//                }
//        );
//        return user;
//    }
//
//    public void deleteUser(String id){
//        store = this.store.stream().filter(e -> !e.getUserId().equals(id)).collect(Collectors.toList());
//    }
//
//
//    public List<Users> getUsers(){
//        return this.store;
//    }
//
//    public void addUser(Users user) {
//        store.add(user);
//    }
//
//
//    public Users getUserById(String userId) {
//        Optional<Users> userOptional = store.stream()
//                .filter(user -> user.getUserId().equals(userId))
//                .findFirst();
//
//        return userOptional.orElse(null);
//    }
//}



package org.example.service;



import org.apache.catalina.User;
import org.example.dao.UsersDao;
import org.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
//    private List<Users> store= new ArrayList<>();

    @Autowired
    private UsersDao usersDao;

    public UserService(){
//        store.add(new Users(UUID.randomUUID().toString(),"Arunain","arunain@gmail.com"));
//        store.add(new Users(UUID.randomUUID().toString(),"Aakash","aakash@gmail.com"));

    }

//    public Users getUserByName(String userName) {
//        return store.stream()
//                .filter(user -> user.getName().equals(userName))
//                .findFirst()
//                .orElse(null);
//    }

    public List<Users> getUsers(){
//        return this.store;
        return usersDao.findAll();
    }

    public Users getUserById(String userId) {
//        Optional<Users> userOptional = store.stream()
//                .filter(user -> user.getUserId().equals(userId))
//                .findFirst();

//        return userOptional.orElse(null);


       return  usersDao.findById(userId).orElse(null);
    }


    public Users updateUser(Users user){
//        store.forEach(
//                e->{
//                    if(e.getUserId().equals(user.getUserId())){
//                        e.setName(user.getName());
//                        e.setEmail(user.getEmail());
//                    }
//                }
//        );
//        return user;
        usersDao.save(user);
        return user;
    }

    public void deleteUser(String id){
//        store = this.store.stream().filter(e -> !e.getUserId().equals(id)).collect(Collectors.toList());
        usersDao.findById(id).ifPresent(users -> usersDao.delete(users));


    }




    public void addUser(Users user) {
//        store.add(user);
        usersDao.save(user);

//        addToConfig(user.getUserId());
    }

//    public Users getPersonUsername(String name){
//        for(Users p : usersDao.findAll()){
//            String username
//            if(p.get.equals(name)){
//                return p;
//            }
//        }
//        return null;
//    }





}
