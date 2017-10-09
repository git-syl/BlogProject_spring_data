package cn.syl.service.impl;

import cn.syl.mapper.TestMapper;
import cn.syl.pojo.Test;
import cn.syl.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TestMapper testMapper;
     @Transactional
    public List<Test> testService(){
       return testMapper.findAll();
    }
}
