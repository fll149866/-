package com.nysb.demo01.controller;

import cn.hutool.core.util.StrUtil;
import com.nysb.demo01.entity.Img;
import com.nysb.demo01.entity.ImgResult;
import com.nysb.demo01.entity.Plant;
import com.nysb.demo01.service.ImgUploadService;
import com.nysb.demo01.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("api/v1")
public class ImgUploadController {

    @Autowired
    private ImgUploadService imgUploadService;


    /**
     * 图片上传，获得识别结果编号
     * @param file
     * @return
     */
    @RequestMapping("pri/img_upload")
    public JsonData imgUpload(@RequestParam("file") MultipartFile file){

        Img img = new Img();
        if(file.isEmpty()){
            return JsonData.buildError("请上传文件！");
        }
        try{
            InputStream is = file.getInputStream();
            byte[] imgType = new byte[(int)file.getSize()];
            is.read(imgType);
            img.setImg(imgType);
//            imgUploadService.save(img);
//            识别
            Img img1 = imgUploadService.recognition(img);
            System.out.println(img1);
            return JsonData.buildSuccess(img1);
        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonData.buildSuccess();
    }


    /**
     * 根据识别编号，返回相应结果
     */
    @RequestMapping("/pri/content_result")
    public JsonData returnResult(@RequestParam("type_id") int typeId,@RequestParam("sta_id") int statusId){
        if (typeId == 0 || statusId == 0){
            return JsonData.buildError("暂未收录");
        }

        Plant plant = imgUploadService.selectById(typeId,statusId);
        if (plant == null){
            throw new RuntimeException("对象为空");
        }
        return JsonData.buildSuccess(plant);
    }
}
