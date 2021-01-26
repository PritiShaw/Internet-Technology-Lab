package com.assgn5;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String storeName;    
    private String openTime;    
    private String closeTime;    
    private String latitude;    
    private String longitude;    
}
