package com.goat.dao;




import com.goat.model.Emp;

import java.util.Map;

/**
 * Created by 64274 on 2018/8/21.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:51
 */
public interface BaseDao {

    Map findMapById(Integer id);
    Emp findObjectById(Integer id);


    Integer saveMap(Map map);
    Integer saveObject(Emp emp);


    Integer deleteById(Integer id);

    Integer updateMapById(Map emp);
    Integer updateObjectById(Emp emp);
}
