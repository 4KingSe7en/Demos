package com.demo.news.service.impl;

import com.demo.news.entity.NNews;
import com.demo.news.mapper.NNewsMapper;
import com.demo.news.service.INNewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@Service
public class NNewsServiceImpl extends ServiceImpl<NNewsMapper, NNews> implements INNewsService {

}
