package com.test.demo_ibatis.Plugins;

import com.test.demo_ibatis.Enum.MethodEnum;
import com.test.demo_ibatis.service.Impl.AddStrategyMethodImpl;
import com.test.demo_ibatis.service.Impl.SubStrategyMethodImpl;
import com.test.demo_ibatis.service.StrategyMethod;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MethodPool implements InitializingBean {

    private HashMap<MethodEnum, StrategyMethod> methodMap;


    @Override
    public void afterPropertiesSet() throws Exception {
        HashMap<MethodEnum, StrategyMethod>  hashMap = new HashMap<>();
        hashMap.put(MethodEnum.ADD,new AddStrategyMethodImpl() );
        hashMap.put(MethodEnum.SUB,new SubStrategyMethodImpl() );
        System.out.println("方法池初始化完成");
        this.methodMap = hashMap;
    }

    public StrategyMethod getStrategyMethod(MethodEnum methodEnum){
        return methodMap.get(methodEnum);
    }
}
