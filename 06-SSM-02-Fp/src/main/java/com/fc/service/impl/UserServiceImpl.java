package com.fc.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//接口的实现类

@Service
public class UserServiceImpl implements UserService {//实现 UserService接口
    @Autowired
    private UserMapper userMapper;//通过usermapper连接数据库

    //用户数据获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        //返回给前端的结果
        ResultVO resultVO;

        //分页相关的参数
        DataVO<User> userDataVO;

        //结果中data对应的用户数组
        List<User> users;

        //说明传递了id，那就是findById
        if (id != null) {
            users = new ArrayList<>();

            //查询
            User user = userMapper.selectByPrimaryKey(id);

            //没有查到用户的情况
            if (user == null) {
//                userDataVO.setTotal(0L);
//                userDataVO.setList(users);
//                userDataVO.setPageNum(pageNum);
//                userDataVO.setPageSize(pageSize);
                userDataVO = new DataVO<>(0L, users, pageNum, pageSize);

//                resultVO.setDate(userDataVO);
//                resultVO.setSuccess(false);
//                resultVO.setCode(404);
//                resultVO.setMessage("查无此人！！！");
                resultVO = new ResultVO(4000, "查无此人！！", false, userDataVO);
            } else {
                //查到了用户扔到集合中
                users.add(user);

//                userDataVO.setTotal(1L);
//                userDataVO.setList(users);
//                userDataVO.setPageNum(pageNum);
//                userDataVO.setPageSize(pageSize);
                userDataVO = new DataVO<>(1L, users, pageNum, pageSize);

//                resultVO.setDate(userDataVO);
//                resultVO.setSuccess(true);
//                resultVO.setCode(200);
//                resultVO.setMessage("查询用户信息成功！！！");
                resultVO = new ResultVO(1000, "查到了该用户！！！", true, userDataVO);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            users = userMapper.selectByExample(null);

            //如果数据库是空的，一个人都没查到
            if (users.size() == 0) {
                userDataVO = new DataVO<>(0L, users, pageNum, pageSize);

                resultVO = new ResultVO(4100, "没有用户！！！", false, userDataVO);
                //查到了
            } else {
                //封装pageInfo，为了获取总数据量
                PageInfo<User> pageInfo = new PageInfo<>(users);

//            userDataVO.setTotal(pageInfo.getTotal());
//            userDataVO.setList(users);
//            userDataVO.setPageNum(pageNum);
//            userDataVO.setPageSize(pageSize);
                userDataVO = new DataVO<>(pageInfo.getTotal(), users, pageNum, pageSize);

//            resultVO = new ResultVO();
//            resultVO.setMessage("用户查询成功");
//            resultVO.setSuccess(true);
//            resultVO.setCode(200);
//            resultVO.setDate(userDataVO);
                resultVO = new ResultVO(1100, "用户查询成功！！！", true, userDataVO);

            }
        }
        return resultVO;
    }

    //用户数据添加
    @Override
    public ResultVO add(User user) {
        ResultVO vo;

        //判断是否存在创建时间，如果创建时间为空
        if (user.getCreateTime() == null) {
            //就创建一个时间戳---Calendar.getInstance(Locale.CHINA).getTime()按中国时区创建
            user.setCreateTime(new Date());
        }

        //insertSelective给啥插啥   insert全都传，没有null
        int affectedRows = userMapper.insertSelective(user);

        if (affectedRows > 0) {
            vo = new ResultVO(1000, "添加用户成功！！！", true, user);
        } else {
            vo = new ResultVO(5000, "添加用户失败！！！", false, null);
        }
        return vo;
    }

    @Override
    public ResultVO update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        ResultVO vo;

        if (affectedRows > 0) {
            //修改完成之后，再重新查询一次，保证返回给前端的是最新最全的数据
            user = userMapper.selectByPrimaryKey(user.getId());

            vo = new ResultVO(1000, "修改用户成功！！！", true, user);
        } else {
            vo = new ResultVO(5000, "修改用户失败！！！", false, null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);

        ResultVO vo;

        if (affectedRows > 0) {

            vo = new ResultVO(1000, "删除用户成功！！！", true, null);
        } else {
            vo = new ResultVO(5000, "删除用户失败！！！", false, null);
        }
        return vo;
    }

    @Override
    public ResultVO login(String username, String password) {
        ResultVO vo = new ResultVO();

        //默认失败
        vo.setCode(-1);
        vo.setMessage("登录失败，当前用户名不存在");
        vo.setSuccess(false);
        vo.setData(null);

        //new一个示例
        UserExample example = new UserExample();

        //创建一个标准
        UserExample.Criteria criteria = example.createCriteria();

        //标准里面username相同
        criteria.andUsernameEqualTo(username);

        //示例条件
        List<User> users = userMapper.selectByExample(example);

        //能查出来说明用户名是存在的
        if (users.size() > 0) {
            //拿到查询后的第一个user
            User user = users.get(0);

            // 判断密码是否相同 如果密码相同
            if (user.getPassword().equals(password)) {
                vo.setCode(200);
                vo.setMessage("登录成功！！！");
                vo.setSuccess(true);

                // 密码不要传给前端
                user.setPassword(null);

                // token - json web token

                // 盐值的存储应该存到缓存服务器中-Redis
                // 可以把盐值作为载荷直接发送给前端，每次我们获取到token后对其进行解析
                // 其实这是很不安全的，但是没办法，暂时这样用
                // 盐值
                String salt = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));

                //头部
                Map<String, Object> header = new HashMap<>();

                //算法
                header.put("alg", "HA256");
                //类型
                header.put("typ", "JWT");

                //获取token
                String token = JWT.create()
                        .withHeader(header)
                        // 主题
                        .withSubject("登录权限验证")
                        // 签发人
                        .withIssuer("admin")
                        // 签发日期
                        .withIssuedAt(new Date())
                        // 过期时间
                        // 设置稍微长一点，后面有机会讲token续签的时候再改
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                        .withClaim("id", user.getId())
                        .withClaim("username", username)
                        .withClaim("role", user.getRole())
                        .withClaim("salt", salt)
                        // 使用盐值进行签发生成jwt
                        .sign(Algorithm.HMAC256(salt));

                Map<String, Object> result = new HashMap<>();

                result.put("user", user);
                result.put("token", token);


                vo.setData(result);


            } else {
                vo.setCode(-2);
                vo.setMessage("登录失败，请输入正确的密码");
            }

        }

        return vo;
    }
}
