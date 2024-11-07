package com.ntt.elearning.service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public Map upload(MultipartFile file) {
        try {
            Map data = this.cloudinary
                    .uploader()
                    .upload(
                            file.getBytes(),
                            Map.of("public_id", UUID.randomUUID().toString()));
            return data;
        } catch (IOException io) {
            throw new RuntimeException("Image upload fail");
        }
    }
}