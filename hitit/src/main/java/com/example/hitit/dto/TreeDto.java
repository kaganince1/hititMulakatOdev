package com.example.hitit.dto;

import com.example.hitit.model.Tree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDto {
    private Integer id;
    private String barcodeNo;
    private Integer height;
    private String treeSpecie;

    public static List<TreeDto> TreeToTreeDto(List<Tree> treeList){
        List<TreeDto> treeDtoList = new ArrayList<>();
        for (Tree tree : treeList){
            TreeDto treeDto = new TreeDto();
            treeDto.setId(tree.getId());
            treeDto.setBarcodeNo(tree.getBarcodeNo());
            treeDto.setHeight(tree.getHeight());
            treeDto.setTreeSpecie(tree.getTreeSpecie().getName());
            treeDtoList.add(treeDto);
        }
        return treeDtoList;
    }
    public static TreeDto TreeToTreeDtoByID(Tree tree){
        TreeDto treeDto = new TreeDto();
        treeDto.setId(tree.getId());
        treeDto.setBarcodeNo(tree.getBarcodeNo());
        treeDto.setHeight(tree.getHeight());
        treeDto.setTreeSpecie(tree.getTreeSpecie().getName());
        return treeDto;
    }
}
