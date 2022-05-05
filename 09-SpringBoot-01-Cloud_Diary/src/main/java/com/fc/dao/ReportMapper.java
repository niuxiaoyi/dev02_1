package com.fc.dao;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {
    List<NoteVO> getNoteCountByMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
