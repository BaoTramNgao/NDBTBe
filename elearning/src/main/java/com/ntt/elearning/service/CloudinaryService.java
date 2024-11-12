package com.ntt.elearning.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public Map upload(MultipartFile file, String folder) {
        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of("folder", folder));
            return data;
        } catch (IOException io) {
            throw new RuntimeException("Image upload fail");
        }
    }
}
