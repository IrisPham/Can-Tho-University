package com.example.visualstudio.canthouniversity.Model.Login;

/**
 * Created by Visual Studio on 9/30/2017.
 */

public class User {
    private String idAccount;
    private String accountName;
    private String birthday;
    private String address;
    private String sex;
    private String phone;
    private String email;
    private String password;
    private String Permission_position;

    public User(){

    }

    public User(String idAccount, String accountName, String birthday
            , String address, String sex, String phone, String email
            , String password, String permission_position) {
        this.idAccount = idAccount;
        this.accountName = accountName;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.Permission_position = permission_position;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission_position() {
        return Permission_position;
    }

    public void setPermission_position(String permission_position) {
        this.Permission_position = permission_position;
    }
}
