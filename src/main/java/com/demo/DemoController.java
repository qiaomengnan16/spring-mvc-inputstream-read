package com.demo;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String req(HttpServletRequest request) throws Exception {
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator iterator = upload.getItemIterator(request);
        while (iterator.hasNext()) {
            FileItemStream item = iterator.next();
            if (item.isFormField()) {
                // 普通的表单字段
                System.out.println(item.getFieldName());
                // 流
                System.out.println(item.openStream());
            } else {
                // 文件
                System.out.println(item.getFieldName());
                // 文件流
                System.out.println(item.openStream());
            }
        }
        return "OK";
    }

}
