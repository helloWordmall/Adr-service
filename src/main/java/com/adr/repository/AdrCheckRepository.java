package com.adr.repository;

import com.adr.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdrCheckRepository {
    List<Map<String,Object>> selectAdrRepeatData();
    List<Map<String,Object>> selectAdrAge();
    User selectPartAge(int id);

    List<Map<String,Object>> selectRepeatData();
    List<Map<String,Object>> selectRepeatAdjust();
    List<Map<String,Object>> selectRepeatOrigin();
    int selectHospId(int id);
}
