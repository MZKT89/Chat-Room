# CSC1004_java
For ChatRoom Project


1.The SQL for create database and its table:
CREATE DATABASE IF NOT EXISTS study;
DROP TABLE IF EXISTS user_test;
CREATE TABLE user_test
        (
            username varchar(255) not null,
            address varchar(255),
            age int,
            password varchar(255) not null,
            gender varchar(6)
            PRIMARY KEY (username)
        );


2. To run this project:
   ·Go to the src/main/java/com/mzhu/StartEnd
   
   ·Do some configurations in "ClientEnd Edit Configurations -> Modify options -> Allow multiple instances" so that you can run ClientEnd multiple times to realize different clients to log in.
   
   ·Run ServerEnd first, and then run ClientEnd

   ·Something need to be mentioned
   --when you finish registeration or changing password, you'd better rerun the project including the ServerEnd to make sure the database updated.
   --All socket codes are in the package src/main/java/com/mzhu/UIAndBackEnd/BackEnd
   --All UI codes are in the package src/main/java/com/mzhu/UIAndBackEnd/UI
        
