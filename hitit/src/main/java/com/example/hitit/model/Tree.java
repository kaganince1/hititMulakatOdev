package com.example.hitit.model;

import com.example.hitit.dto.TreeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TREE")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String barcodeNo;
    private Integer height;
    @ManyToOne
    @JoinColumn(name = "tree_specie_id")
    TreeSpecie treeSpecie;

    public static Tree treeDtoToTree(TreeDto treeDto) {
        Tree tree = new Tree();
        tree.setId(treeDto.getId());
        tree.setBarcodeNo(treeDto.getBarcodeNo());
        tree.setHeight(treeDto.getHeight());
        TreeSpecie treeSpecie = new TreeSpecie();
        treeSpecie.setName(treeDto.getTreeSpecie());
        tree.setTreeSpecie(treeSpecie);
        return tree;
    }
}
