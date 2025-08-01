/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.achrafmataich.fashion_mnist_backend.dtos.PredictionResultDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImagePredictionService {
    
    private final AIService aiService;
    
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final String[] ALLOWED_CONTENT_TYPES = {"image/jpeg", "image/jpg", "image/png"};
    
    public PredictionResultDTO processImagePrediction(MultipartFile imageFile) throws IOException {
        log.info("Starting image prediction for file: {}", imageFile.getOriginalFilename());
        
        validateImageFile(imageFile);
        
        String base64Image = convertToBase64(imageFile);
        
        String prediction = aiService.predictImage(base64Image);
        
        log.info("Prediction completed: {} for file: {}", prediction, imageFile.getOriginalFilename());
        
        return PredictionResultDTO.builder()
                .prediction(prediction)
                .base64Image(base64Image)
                .fileName(imageFile.getOriginalFilename())
                .build();
    }
    
    private void validateImageFile(MultipartFile imageFile) {
        if (imageFile.isEmpty()) {
            throw new IllegalArgumentException("Please select an image file");
        }
        
        validateFileType(imageFile);
        validateFileSize(imageFile);
    }
    
    private void validateFileType(MultipartFile imageFile) {
        String contentType = imageFile.getContentType();
        if (contentType == null) {
            throw new IllegalArgumentException("Invalid file type");
        }
        
        boolean isValidType = false;
        for (String allowedType : ALLOWED_CONTENT_TYPES) {
            if (contentType.equals(allowedType)) {
                isValidType = true;
                break;
            }
        }
        
        if (!isValidType) {
            throw new IllegalArgumentException("Only JPG and PNG files are allowed");
        }
    }
    
    private void validateFileSize(MultipartFile imageFile) {
        if (imageFile.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size must be less than 5MB");
        }
    }
    
    private String convertToBase64(MultipartFile imageFile) throws IOException {
        byte[] imageBytes = imageFile.getBytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
} 