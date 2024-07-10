package com.yigbu.reactive_netflux.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    private String id;

    @NonNull
    private String title;

}
