package com.seger.website;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Experience {
    private final long id;
    private final String company;
    private final String title;
    private final String years;
    private final String location;
    private final String description;
}
