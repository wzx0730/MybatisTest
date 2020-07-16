package com.test.demo_ibatis.service.Impl;

import com.test.demo_ibatis.Enum.MethodEnum;
import com.test.demo_ibatis.Plugins.MethodPool;
import com.test.demo_ibatis.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Autowired
    private MethodPool methodPool;

    @Override
    public Integer getResult(String str, int i, int j) {
        MethodEnum methodEnum = MethodEnum.getEnumByString(str);
        Integer result = methodPool.getStrategyMethod(methodEnum).Calculate(i, j);
        return result;
    }

}
