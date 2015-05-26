package jp.co.seattleconsulting.service;

import javax.annotation.Resource;

import jp.co.seattleconsulting.dto.LoginDto;
import jp.co.seattleconsulting.entity.Login;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.framework.beans.util.Beans;

/**
 * @author user
 *
 */
public class LoginService extends S2AbstractService<Login>{

    @Resource
    protected LoginDto loginDto;

    public boolean login(String userName, String password) {
        Login login = findByNameAndPassword(userName, password);
        if(login == null){
        	return false;
        }else{
        	Beans.copy(login, loginDto).execute();
        	return true;
        }
    }

    public boolean isLoginOK(){
        return loginDto.userName == null ? false : true;
    }

    public Login findByNameAndPassword(String userName, String password) {
        return jdbcManager.from(Login.class). where(new SimpleWhere().eq("userName", userName).in("password", password)).getSingleResult();
    }
}
