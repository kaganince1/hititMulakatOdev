package com.example.hitit.service;

import com.example.hitit.dto.TreeDto;

import java.util.List;

public interface ITreeService {
    List<TreeDto> getTrees();
    TreeDto getTreeById(Integer id);
    void addTree(TreeDto treeDto);
    void deleteTree(Integer id);
}
