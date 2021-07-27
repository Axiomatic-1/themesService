package com.microsevriceslesson.plateService.VO;

import com.microsevriceslesson.plateService.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private PlateVO plate;
}
