package com.lostsheep.technology.learning.socket.jsp.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lostsheep.technology.learning.socket.jsp.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;

/**
 * <b><code>CrudController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/19 15:27.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/app")
public class CrudController {

    private final Executor executor;
    private static List<UserVO> userVOList;

    public CrudController(@Qualifier("taskExecutor") Executor executor) {
        this.executor = executor;
    }

    static {
        UserVO userVO1 = UserVO.builder().id(1L).userName("first").phone("110").email("110@110.com").address("北京").build();
        UserVO userVO2 = UserVO.builder().id(2L).userName("second").phone("120").email("120@120.com").address("上海").build();
        UserVO userVO3 = UserVO.builder().id(3L).userName("third").phone("119").email("119@119.com").address("广州").build();

        userVOList = Lists.newArrayList(userVO1, userVO2, userVO3);
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");

        Map<String, Object> map = Maps.newHashMap();
        map.put("data", userVOList);
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView inquireSomeone(@PathVariable Long id) {
        Assert.isTrue(Objects.nonNull(id), "ID 不能为空!");
        log.info("id:{}", id);

        UserVO targetUser = userVOList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .get();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/modify");

        Map<String, Object> map = Maps.newHashMap();
        map.put("user", targetUser);
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @PostMapping({"", "/"})
    public String modify(UserVO userVO) {
        log.info("request body:{}", JSON.toJSON(userVO));

        userVOList.forEach(user -> Optional.ofNullable(user)
                .filter(u -> u.getId().equals(userVO.getId()))
                .ifPresent(u -> BeanUtils.copyProperties(userVO, u)));

        return "redirect:/app/index";
    }

    @PostMapping("/one")
    public boolean modifySomeone(@RequestBody UserVO userVO) {
        log.info("request body:{}", JSON.toJSON(userVO));

        userVOList.forEach(user -> Optional.ofNullable(user)
                .filter(u -> u.getId().equals(userVO.getId()))
                .ifPresent(u -> BeanUtils.copyProperties(userVO, u)));

        return true;
    }
}
