package org.soin.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 邮件发送方式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEmailTo {
    private String content;
    private List<String> emails;
}
