package com.assgn5;

import javax.persistence.Column;

import javax.persistence.*;

@Entity
public class Category {
    
    @Id
    private int cid;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long storeId;

    @Column(length=50, nullable=false, unique=false)
    private String StoreName;
    
    @Column(length=50, nullable=false, unique=false)
    private String openTime;
    
    @Column(length=50, nullable=false, unique=false)
    private String closeTime;
    
    @Column(length=50, nullable=false, unique=false)
    private Long latitude;
    
    @Column(length=50, nullable=false, unique=false)
    private Long longitude;

    public int getCID(){
        return cid;
    }

    public Long getStoreId(){
        return storeId;
    }

    public String getStoreName(){
        return StoreName;
    }

    public String getOpenTime(){
        return openTime;
    }
    public String getCloseTime(){
        return closeTime;
    }
    public Long getLatitude(){
        return latitude;
    }
    public Long getLongitude(){
        return longitude;
    }

	public static Object builder() {
		return null;
	}
}

