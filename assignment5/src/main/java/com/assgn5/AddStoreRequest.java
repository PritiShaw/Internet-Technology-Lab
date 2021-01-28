package com.assgn5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddStoreRequest {
    // all these will come from React as JSON
    private String storeName;
    private Long cid;
    private String openTime;
    private String closeTime;
    private String longitude;
    private String latitude;
    private String pass;

    public Store addStore(){
        if(pass.equals("Password")){
            return Store.builder()
                    .storeName(storeName)
                    .openTime(openTime)
                    .closeTime(closeTime)
                    .longitude(longitude)
                    .latitude(latitude)
                    .build();
        }
        else{
            return null;
        }        
    }
}
