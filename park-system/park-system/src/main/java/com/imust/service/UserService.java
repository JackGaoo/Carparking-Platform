package com.imust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.entity.Users;
import com.imust.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public Users login(Users users) {
		List<Users> list = userMapper.findUserByNameAndPwd(users.getName(), users.getPassword());
		if(list.size()>0) {
			Users user = list.get(0);
			return user;
		}
		return null;
	}
	public boolean updatePoint(Users users) {
		try {
			userMapper.updateUserPoint(users);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//通过id修改状态
	public boolean updateStautsById(int id,int stauts) {
		try {
			userMapper.updateUserStauts(id, stauts);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean updateUserPwd(Users user) {
		try {
			userMapper.updateUserPwd(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean updateUser(Users user) {
		try {
			userMapper.updateUser(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
    public boolean updatePlatNum(Users user) {
        try {
            userMapper.updatePlatNum(user);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
	//名称模糊查询用户
	public List<Users> getByName(String tmpName) {
		String name = "%"+tmpName+"%";
		return userMapper.findByName(name);
	}
	
	public List<Users> getPointByName(String tmpName) {
		String name = "%"+tmpName+"%";
		return userMapper.findPointByName(name);
	}
	
	//获取全部用户
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}
	
	//获取全部用户
	public List<Users> getAllPoint() {
		// TODO Auto-generated method stub
		return userMapper.findAllPoint();
	}
	
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);

	}
	//根据用户名查找用户
	public List<Users> seletByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.seletByName(name);
	}

	//根据id查询车牌
	public Users getPlateNumById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getPlateNumById(id);
	}

	//添加用户
	public boolean addUser(Users users) {
		try {
			userMapper.insertUsers(users);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//插入新车牌
	public boolean insertPlate(Users users) {
		try {
			userMapper.insertPlate(users);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
