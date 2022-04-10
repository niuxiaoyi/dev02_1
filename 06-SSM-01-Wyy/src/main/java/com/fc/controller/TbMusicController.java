package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    @Autowired
    private TbMusicService tbMusicService;

    @RequestMapping("findAll")
    public List<TbMusic> findAll() {
        return tbMusicService.findAll();
    }

    @RequestMapping("findById")
    public TbMusic findById(Integer musicId) {
        return tbMusicService.findById(musicId);
    }

//    下一首
    @RequestMapping ("nextSong")
    public TbMusic nextSong(Integer musicId){
        return tbMusicService.nextSong(musicId);
    }

//    上一首
    @RequestMapping("prevSong")
    public TbMusic prevSong(Integer musicId){
        return tbMusicService.prevSong(musicId);
    }

//    模糊查询
    @RequestMapping("search")
    public List<TbMusic> search(String keyword){
        return tbMusicService.search(keyword);
    }
}