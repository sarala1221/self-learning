package com.bookmyshow.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
