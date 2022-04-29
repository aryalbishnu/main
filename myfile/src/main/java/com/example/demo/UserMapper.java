package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Transfer;

@Mapper

public interface UserMapper {
void doinsert(User user);

List<Transfer> getlist();

}
