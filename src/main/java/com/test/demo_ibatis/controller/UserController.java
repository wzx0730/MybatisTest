package com.test.demo_ibatis.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.test.demo_ibatis.domain.*;
import com.test.demo_ibatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModuleConfig moduleConfig;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel insertUser(@RequestBody User user){
        try {
            userService.insertUser(user);
            return new ResultModel("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultModel("操作失败");
    }

    @RequestMapping(value = "/selectByPassWordAndRealName",method = RequestMethod.POST)
    @ResponseBody
    public List<User>  selectByUserName(@RequestBody HashMap<String,String> map){

           List<User> list =userService.selectByPassWordAndRealName(map.get("realName"),map.get("passWord"));
           return list;

    }

    @RequestMapping(value = "/insertBatch",method = RequestMethod.POST)
    @ResponseBody
    public  ResultModel insertBatch(@RequestBody List<User> list){

        try {
            userService.insertBatch(list);
            return new ResultModel("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel("操作失败",e.getMessage());
        }

    }


    @RequestMapping(value = "/testVO",method = RequestMethod.POST)
    @ResponseBody
    public  void insertBatch(@RequestBody JSONObject jsonObject) {
        Object userList = jsonObject.get("userList");
        List<User> userList1 = (List<User>) userList;
        System.out.println(userList1);
        for (User user : userList1) {
            System.out.println(user);
        }


    }


    @RequestMapping("/test1")
    public String test1(@RequestParam String id){
        System.out.println(id);
        System.out.println(moduleConfig.getPath());
        return id;
    }


    @RequestMapping("/saveFile")
    @ResponseBody
    public ResultModel saveFile(MultipartFile multipartFile,ServletRequest servletRequest){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        String path = servletRequest.getServletContext().getContextPath()+multipartFile.getOriginalFilename();
        logger.info("文件名为" +
                multipartFile.getOriginalFilename() +
                "文件大小为" + multipartFile.getSize() +
                "保存位置为" + path);
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
             bis = new BufferedInputStream(multipartFile.getInputStream());
             bos = new BufferedOutputStream(new FileOutputStream(new File(path)));

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0 , len);
            }
            logger.info("文件保存完毕");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bis!=null){
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    assert bos != null;
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        }
        return new ResultModel("成功");
    }
}
