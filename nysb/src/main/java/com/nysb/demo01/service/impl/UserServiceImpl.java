package com.nysb.demo01.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.nysb.demo01.common.Constant;
import com.nysb.demo01.entity.User;
import com.nysb.demo01.mapper.UserMapper;
import com.nysb.demo01.service.UserService;
import com.nysb.demo01.utils.JWTUtils;
import com.nysb.demo01.utils.RandomNum;
import com.nysb.demo01.utils.SnowFlake;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RandomNum randomNum;

    private User parseToUser(Map<String,String> userInfo){
        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            System.out.println(userInfo.get("phone"));
            User user = new User();
            final SnowFlake snowFlake = new SnowFlake(2,3);
            user.setId(snowFlake.toString());
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            user.setIdentity(randomNum.getNum(2));
            //MD5加密
            user.setPwd(SecureUtil.md5(pwd));

            return user;
        }else {
            return null;
        }
    }

    @Resource
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);

        if (user != null){
            return userMapper.save(user);
        }else {
            throw new RuntimeException(Constant.Object_NULL);
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        final User user = userMapper.findByPhoneAndPwd(phone,SecureUtil.md5(pwd));
        if (user == null){
            return null;
        }else {
            final String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findByUserId(String id) {
        final User user = userMapper.findByUserId(id);
        return user;
    }

    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }

    /**
     * 放在CDN（内容分发网络）上的随机头像
     */
    private static final String [] headImg =  {
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3699354628,919100137&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1963442875,1146947704&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3551370719,1936559374&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1965651583,2507690782&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2062251595,314607531&fm=26&gp=0.jpg"
    };

}
