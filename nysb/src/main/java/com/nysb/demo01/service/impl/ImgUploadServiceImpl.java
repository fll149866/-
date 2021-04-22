package com.nysb.demo01.service.impl;

import com.nysb.demo01.config.CacheKeyManager;
import com.nysb.demo01.entity.Img;
import com.nysb.demo01.entity.Plant;
import com.nysb.demo01.mapper.ImgUploadMapper;
import com.nysb.demo01.service.ImgUploadService;
import com.nysb.demo01.utils.BaseCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ImgUploadServiceImpl implements ImgUploadService {

    @Resource
    private ImgUploadMapper imgUploadMapper;

    @Resource
    private BaseCache baseCache;

    /**
     * 进行图片识别，并返回识别结果编号
     * @param img
     * @return
     */
    @Override
    public Img recognition(Img img) {

        return imgUploadMapper.recognition(img);
    }


    /**
     * 根据识别结果编号，返回识别结果
     * @param
     * @return
     */
    @Override
    public Plant selectById(int typeId, int statusId) {
        try {
            Object cacheObj  = baseCache.getTenMinuteCache().get(CacheKeyManager.RESULT_CONTENT,()->{
                final Plant selectById = imgUploadMapper.selectById(typeId, statusId);
                System.out.println("从数据库中查找结果");
                return  selectById;
            });
            if (cacheObj instanceof Plant){
                final Plant selectById = imgUploadMapper.selectById(typeId, statusId);
                return selectById;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试
     * @param img
     * @return
     */
    @Override
    public int save(Img img) {
        /**
         * 上传图片
         */
        return imgUploadMapper.save(img);
    }

}
