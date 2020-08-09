package com.lostsheep.technology.learning.async.upload.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b><code>FileInfo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:27.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfo {
    
    private String serialNumber;
    
    private String uuid;
    
    private String originalName;
    
    private String randomName;
    
    private String storeName;
    
    private Integer successOrNot;
    
    private String result;
    
}
