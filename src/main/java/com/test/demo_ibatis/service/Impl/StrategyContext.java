package com.test.demo_ibatis.service.Impl;

import com.test.demo_ibatis.service.StrategyMethod;

public class StrategyContext {
    private StrategyMethod strategyMethod;

    public StrategyContext(StrategyMethod strategyMethod) {
        this.strategyMethod = strategyMethod;
    }

    public Integer excute(int i,int j){
        return strategyMethod.Calculate(i, j);
    }
}
