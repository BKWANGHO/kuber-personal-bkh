package com.turing.api.common.component;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessengerVo {
    private String message;
    private int status;
    private String code;


}