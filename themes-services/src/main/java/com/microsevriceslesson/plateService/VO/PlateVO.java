package com.microsevriceslesson.plateService.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlateVO {
    private Long plateId;
    private String plateName;
    private String adress;
    private String departmentCode;

}