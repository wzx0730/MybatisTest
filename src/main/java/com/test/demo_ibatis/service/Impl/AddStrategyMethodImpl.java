package com.test.demo_ibatis.service.Impl;

import com.test.demo_ibatis.service.StrategyMethod;

public class AddStrategyMethodImpl implements StrategyMethod {
    @Override
    public Integer Calculate(int i, int j) {
        System.out.println("运用了加法策略");
        return i+j;
    }


}
