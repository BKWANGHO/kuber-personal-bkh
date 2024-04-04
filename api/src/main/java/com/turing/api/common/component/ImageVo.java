package com.turing.api.common.component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageVo {
    private long imageId;
    String name;
    Long lastModified;
    Long lastModifideDate;
    String type;
    String webkitRelativePath;
    Long size;

}
