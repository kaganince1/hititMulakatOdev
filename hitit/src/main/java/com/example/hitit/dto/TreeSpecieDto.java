package com.example.hitit.dto;

import com.example.hitit.model.TreeSpecie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeSpecieDto {
    private Integer id;
    private String name;

    public static List<TreeSpecieDto> TreeToTreeDto(List<TreeSpecie> treeList){
        List<TreeSpecieDto> treeDtoList = new ArrayList<>();
        for (TreeSpecie tree : treeList){
            TreeSpecieDto treeDto = new TreeSpecieDto();
            treeDto.setId(tree.getId());
            treeDto.setName(tree.getName());
            treeDtoList.add(treeDto);
        }
        return treeDtoList;
    }
}
