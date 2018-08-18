package com.project.proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DownloadController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public StreamingResponseBody getSteamingFile(HttpServletResponse response) throws IOException, URISyntaxException {

        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"2.mpg\"");
        InputStream inputStream = new FileInputStream(getClass().getResource("/videos/2.mpg").toURI().getPath());

        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
            inputStream.close();
        };
        //Save the uploaded file to this folder

    }
}

