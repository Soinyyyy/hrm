package org.soin.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 手机发送方式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSmsTo {
    private String content;
    private List<String> phones;
}
