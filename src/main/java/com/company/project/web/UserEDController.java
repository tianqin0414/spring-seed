package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/10/08.
 */
@RestController
@RequestMapping("/userED")
public class UserEDController {
    @Resource
    private UserService userService;
    @GetMapping("/{test}")
    public Result detail(@PathVariable Integer test) {
//        User user = userService.findById(test);
//        User user = userService.findBy("id",test);
        Condition condition = new Condition(User.class);
        Criteria criteria = condition.createCriteria();
        criteria.orEqualTo("id", test);
//        criteria.orEqualTo("name", "jack");
        List<User> userList = userService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(userList);
    }

}
