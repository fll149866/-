package com.nysb.demo01.service;

import com.nysb.demo01.entity.Img;
import com.nysb.demo01.entity.ImgResult;
import com.nysb.demo01.entity.Plant;

public interface ImgUploadService {

    /**
     * 测试部分 插入图片类型用于测试
     * @param img
     * @return
     */
    int save(Img img);

    /**
     * 返回识别结果
     * @param img
     * @return
     */
    Img recognition(Img img);

    Plant selectById(int typeId, int statusId);
}
