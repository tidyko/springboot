package com.goat.dp.service;

import com.goat.dp.strategy.IDiscountStrategy;
import com.goat.dp.strategy.VIP1StrategyImpl;
import com.goat.dp.strategy.VIP2StrategyImpl;
import com.goat.dp.strategy.VIPStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: 策略模式 实战  干掉if else
 * @ author  山羊来了
 * @ date 2019/3/28---18:28
 */
@Service
public class SaleService {

    @Autowired VIPStrategyImpl vipStrategy;
    @Autowired VIP1StrategyImpl vip1Strategy;
    @Autowired VIP2StrategyImpl vip2Strategy;


    // 这种方式也可以进行自动注意 但是key自动为 实现类的类名
    @Autowired
    Map<String, IDiscountStrategy> map = new ConcurrentHashMap<>();

    // 原始方式
    public void sale(String type,double price){
        if ("VIP".equals(type)){
            double discount = price * 0.65;
            System.out.println("VIP 打折后价格为："+ discount);
        }else if ("VIP1".equals(type)){
            double discount = price * 0.75;
            System.out.println("VIP 打折后价格为："+ discount);
        }else if ("VIP2".equals(type)){
            double discount = price * 0.85;
            System.out.println("VIP 打折后价格为："+ discount);
        }
    }

    // 升级方式   独立了不同的算法  有一定的解耦效果  但是 新增算法  还是新增 if else
    public void sale2(String type,double price){
        if ("VIP".equals(type)){
            System.out.println(vipStrategy.discount(price));
        }else if ("VIP1".equals(type)){
            System.out.println(vip1Strategy.discount(price));
        }else if ("VIP2".equals(type)){
            System.out.println(vip2Strategy.discount(price));
        }
    }


    // sos 通过构造方法 进行  Spring注入 所有该接口的实现类！
    public SaleService(List<IDiscountStrategy> list) {
        for (IDiscountStrategy temp:list){
            map.put(temp.type(),temp);// sos 这里有点难理解
        }
    }

    // 继续升级  通过 Spring注入和 Map 方式 干掉了  if else
    public void sale3(String type,double price){
        Double discount = map.get(type).discount(price);
        System.out.println("本次 打折后价格为："+ discount);
    }
}
