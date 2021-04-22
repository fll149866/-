package com.nysb.demo01.mapper;

import com.nysb.demo01.entity.Img;
import com.nysb.demo01.entity.Plant;

public interface ImgUploadMapper {
    /**
     * 保存图片，测试用
     */
    int save(Img img);

    Img recognition(Img img);

    Plant selectById(int typeId, int statusId);
}
