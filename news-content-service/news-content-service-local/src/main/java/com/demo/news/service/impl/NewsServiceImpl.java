package com.demo.news.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.news.entity.News;
import com.demo.news.mapper.NewsMapper;
import com.demo.news.service.INewsService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
