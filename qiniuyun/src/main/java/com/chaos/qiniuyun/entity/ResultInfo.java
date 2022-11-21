package com.chaos.qiniuyun.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.qiniuyun.entity
 * @className: ResultInfo
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/18 18:21
 * @version: 1.0
 */
@Data
@Setter
@Getter
public class ResultInfo {
    private String Msg;
    private int code;
    private String info;
}
