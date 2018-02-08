package org.waldo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author waldo.wy 2017/8/29
 */
@Controller
public class FileUploadController {

    @GetMapping("/file_upload")
    public String upload() {
        return "fileUpload";
    }

    @PostMapping("/file_upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            model.addAttribute("result", "upload [" + file.getOriginalFilename() + "], size[" + file.getSize() + "] done!");
        } else {
            model.addAttribute("result", "could not be uploaded.");
        }

        return "fileUploadDone";
    }

}
