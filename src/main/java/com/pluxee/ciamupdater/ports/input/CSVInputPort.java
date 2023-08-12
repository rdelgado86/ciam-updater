package com.pluxee.ciamupdater.ports.input;

import org.springframework.web.multipart.MultipartFile;

public interface CSVInputPort {
    void process(MultipartFile file);
}
