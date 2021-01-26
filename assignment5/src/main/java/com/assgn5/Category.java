package com.assgn5;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Category {    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;    
    private String name;
    
    @ElementCollection
    private List<Store> stores;
}

