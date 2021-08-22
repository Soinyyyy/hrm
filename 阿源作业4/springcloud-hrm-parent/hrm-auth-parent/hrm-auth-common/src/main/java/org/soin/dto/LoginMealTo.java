package org.soin.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoginMealTo {
   private Long mealId;
   private Long loginId;
   //有效期
   private Date expireDate;
   private Integer state;

}
