package com.boot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/demo")
public class demoRestController implements ServletContextAware {
    //du lieu la text
    private ServletContext servletContext;

    @GetMapping(value = "/text", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> text() {
        try {
            return new ResponseEntity<String>("Helloword", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/html", produces = MimeTypeUtils.TEXT_HTML_VALUE)
    public ResponseEntity<String> html() {
        try {
            return new ResponseEntity<String>("<b><i>hello hello</i><b>", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    //UPLOAD
    @PostMapping("upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {

        try {
            System.out.println("filetype : " + file.getContentType());
            System.out.println("file size: " + file.getSize());
            System.out.println("file name: " + file.getOriginalFilename());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("uploadr")
    private String processupload(MultipartFile file) {
        try {
            String name = UUID.randomUUID().toString().replace("-", "");
            int lastPindex = file.getOriginalFilename().lastIndexOf(".");
            String filename = name + file.getOriginalFilename().substring(lastPindex);
            //lay duoi fild + voi name ra dc ten file moi
            byte[] bytes = file.getBytes();

            //cai nay la da toi web app con muon vao trong nua thi them vao
//            servletContext.getRealPath("/")
            Path path = Paths.get(servletContext.getRealPath("/upload/" + filename));
            Files.write(path, bytes);
            return filename;

        } catch (Exception ex) {
            return null;

        }

    }

    //UPLOAD
    @PostMapping("uploads")
    public ResponseEntity<Void> uploads(@RequestParam("files") MultipartFile[] files) {

        try {
            for (MultipartFile file : files) {
                System.out.println("filetype : " + file.getContentType());
                System.out.println("file size: " + file.getSize());
                System.out.println("file name: " + file.getOriginalFilename());
                System.out.println("________________________");
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("uploadrs")
    private List<String> processuploads(MultipartFile[] files) {
        try {
            List<String> filenamelist = new ArrayList<>();
            for (MultipartFile file : files) {
                String name = UUID.randomUUID().toString().replace("-", "");
                int lastPindex = file.getOriginalFilename().lastIndexOf(".");
                String filename = name + file.getOriginalFilename().substring(lastPindex);
                //lay duoi fild + voi name ra dc ten file moi
                byte[] bytes = file.getBytes();

                //cai nay la da toi web app con muon vao trong nua thi them vao
//            servletContext.getRealPath("/")
                Path path = Paths.get(servletContext.getRealPath("/upload/" + filename));
                Files.write(path, bytes);
                filenamelist.add(filename);
            }
            return filenamelist;

        } catch (Exception ex) {
            return null;

        }

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
