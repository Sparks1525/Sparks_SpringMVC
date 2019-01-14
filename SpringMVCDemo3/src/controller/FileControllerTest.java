package controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * Created by kerwin on 2017/9/12.
 */
@Controller
public class FileControllerTest {
    @RequestMapping("/upload")
    public ModelAndView upload(MultipartFile file){
        System.out.println(file.getContentType());//获取到文件类型
        //file.getInputStream();//获取到文件流
        System.out.println(file.getName());//上传过来的文件名
        System.out.println(file.getOriginalFilename());//文件原始名称
        System.out.println(file.getSize());//文件大小
        //需要获取到文件上传的那个文件
        FileOutputStream os = null;
        try{
            //需要将文件保存到服务器的某个目录下
            //名字需要通过UUID来重新命名
            String lastName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String startName  = UUID.randomUUID().toString();
            String fileName = startName+lastName;
            System.out.println(fileName);
            os = new FileOutputStream(new File("C:/Users/aa/Desktop/",fileName));
            InputStream is = file.getInputStream();
            IOUtils.copy(is, os);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ModelAndView mv = new ModelAndView("/upload.jsp");
        return mv;
    }

    @RequestMapping(value="/download")
    //如果你不想使用springmvc默认的ModelAndView的方式,使用@ResponseBody注解
    @ResponseBody//该方法响应内容全都有response控制,(springmvc不会做任务事情）
    public void download(HttpServletResponse response) throws Exception{
        response.setHeader("Content-Disposition", "attachment;filename=a.txt");
        OutputStream out = response.getOutputStream();
        FileInputStream in= new FileInputStream("C:/Users/aa/Desktop/test.txt");
        IOUtils.copy(in, out);
        in.close();
        out.close();
    }

}
