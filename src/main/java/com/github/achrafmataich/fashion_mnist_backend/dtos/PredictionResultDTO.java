/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PredictionResultDTO {
    private String prediction;
    private String base64Image;
    private String fileName;
} 