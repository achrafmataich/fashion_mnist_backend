/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.achrafmataich.fashion_mnist_backend.dtos.PredictionResultDTO;
import com.github.achrafmataich.fashion_mnist_backend.services.ImagePredictionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/prediction")
@RequiredArgsConstructor
@Slf4j
public class ImagePredictionController {
    
    private final ImagePredictionService imagePredictionService;

    @GetMapping({"/", ""})
    public String predictionPage() {
        return "prediction-page";
    }

    @PostMapping("/predict")
    public String predictImage(@RequestParam("imageFile") MultipartFile imageFile, 
                              Model model,
                              RedirectAttributes redirectAttributes) {
        try {
            PredictionResultDTO result = imagePredictionService.processImagePrediction(imageFile);
            
            model.addAttribute("prediction", result.getPrediction());
            model.addAttribute("uploadedImage", result.getBase64Image());
            model.addAttribute("fileName", result.getFileName());
            
            return "prediction-page";
            
        } catch (IllegalArgumentException e) {
            log.warn("Validation error: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/prediction";
        } catch (Exception e) {
            log.error("Error during prediction", e);
            redirectAttributes.addFlashAttribute("error", "Error occurred during prediction. Please try again.");
            return "redirect:/prediction";
        }
    }
}
