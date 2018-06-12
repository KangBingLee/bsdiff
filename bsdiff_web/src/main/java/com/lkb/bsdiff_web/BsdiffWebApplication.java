package com.lkb.bsdiff_web;

import com.lkb.bsdiff.BsDiffUtil;
import com.lkb.bspatch.BsPatchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;


@SpringBootApplication
@RestController
public class BsdiffWebApplication {


    Logger logger = LoggerFactory.getLogger(BsdiffWebApplication.class);

    public static void main(String[] args) {

        short s1 = 1;
        s1+=1;

        String s = ",,,a,b,c,e,f,g,,,";

        System.out.println(s.split(",",-1).length);
        System.out.println(s.split(",").length);

        //SpringApplication.run(BsdiffWebApplication.class, args);
    }


    @RequestMapping("d")
    public void d(HttpServletResponse res){
        String fileName = "merge.apk";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            FileInputStream in = new FileInputStream(new File("/usr/lee/merge.apk"));
            FileCopyUtils.copy(in,res.getOutputStream());
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("split")
    public void insplitdex(){
        System.out.println(System.getProperty("java.library.path"));
        logger.info("split:::::::::::::::::::start");
        //BsDiffUtil.getInstance().bsDiffFile("/usr/lee/mimikkoui2_app-beta.apk","/usr/lee/mimikkoui2_app-1.9.3-4230-anzhuo-release.apk","/usr/lee/patch.apk");
        BsDiffUtil.getInstance().bsDiffFile("/home/ubu/jvm/mimikkoui2_app-beta.apk","/home/ubu/jvm/mimikkoui2_app-1.9.3-4230-anzhuo-release.apk","/home/ubu/jvm/patch.apk");
        logger.info("split:::::::::::::::::::end");
    }

    @RequestMapping("merge")
    public void meger(){

        try{
            logger.info("merge:::::::::::::::::::start");
            BsPatchUtil.getInstance().bsPatchFile("/home/ubu/jvm/mimikkoui2_app-beta.apk","/home/ubu/jvm/merge.apk","/home/ubu/jvm/patch.apk");
            logger.info("merge:::::::::::::::::::end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("merge1")
    public void meger1(){
        try{
            logger.info("merge1:::::::::::::::::::start");
            BsPatchUtil.getInstance().bsPatchFile("old.zip","merge.zip","patch.zip");
            logger.info("merge1:::::::::::::::::::end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("merge2")
    public void meger2(){
        try{
            logger.info("merge2:::::::::::::::::::start");
            BsPatchUtil.getInstance().bsPatchFile("/usr/lee/old.zip","/usr/lee/patch.zip", "/usr/lee/merge.zip");
            logger.info("merge2:::::::::::::::::::end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
