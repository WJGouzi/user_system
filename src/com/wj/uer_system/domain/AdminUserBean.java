package com.wj.uer_system.domain;

import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.domain
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:13
 * CREATE TABLE `t_admin` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(20) NOT NULL,
 *   `gender` varchar(5) DEFAULT NULL,
 *   `age` int(11) DEFAULT NULL,
 *   `address` varchar(255) DEFAULT NULL,
 *   `qq` varchar(20) DEFAULT NULL,
 *   `email` varchar(50) DEFAULT NULL,
 *   `user_id` varchar(20) NOT NULL,
 *   `password` varchar(16) DEFAULT NULL,
 *   `id_card` varchar(18) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 **/

public class AdminUserBean {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qq;
    private String email;
    private String userId;
    private String password;
    private String idCard;

    public AdminUserBean() {
    }

    public AdminUserBean(Integer id, String name, String gender, Integer age, String address, String qq, String email, String userId, String password, String idCard) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "AdminUserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
