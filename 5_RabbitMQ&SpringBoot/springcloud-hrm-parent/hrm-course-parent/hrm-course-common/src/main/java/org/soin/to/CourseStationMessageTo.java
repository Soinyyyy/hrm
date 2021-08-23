package org.soin.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStationMessageTo {
    private String title;
    private String content;
    private String type;
    private Date time;
    private Integer state;
    //要推送的人
    private List<Long> userIds;
    //图片
    private String resources;
}
