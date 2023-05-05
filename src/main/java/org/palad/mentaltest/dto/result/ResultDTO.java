package org.palad.mentaltest.dto.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ResultDTO {

    private String result;
    private String description;
    private List<String> recommend;

}
