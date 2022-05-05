package com.fc.vo;

import com.fc.entity.TbNote;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

//用于前端展示日期和类别分类的vo
@EqualsAndHashCode(callSuper = true)
@Data
public class NoteVO extends TbNote {
    private Integer typeId;
    private String groupName;
    private Integer noteCount;
}