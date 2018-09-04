package com.daily;

import com.daily.mybatis.dao.ItemHoldExitEntityMapper;
import com.daily.mybatis.entity.ItemHoldExitEntity;
import com.daily.mybatis.entity.ItemHoldExitEntityExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by json on 2018/8/28.
 * Describe:  动态sql
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneraSql {
    @Autowired
    private ItemHoldExitEntityMapper itemHoldExitEntityMapper;

    @Test
    public void genersql1(){
        ItemHoldExitEntityExample itemHoldExitEntityExample =new ItemHoldExitEntityExample();
        String fields="id,name";
        itemHoldExitEntityExample.setFields(fields);
        ItemHoldExitEntityExample.Criteria criteria = itemHoldExitEntityExample.createCriteria();
        List<ItemHoldExitEntity> itemHoldExitEntities = itemHoldExitEntityMapper.selectByExample(itemHoldExitEntityExample);
        System.out.println(itemHoldExitEntities);

    }


}
