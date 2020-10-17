package com.cuccatti.example.exception.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"errorMessage", "isError"})
public class ErrorHandlerResponse {
  private String errorMessage;
  private boolean isError;
}
