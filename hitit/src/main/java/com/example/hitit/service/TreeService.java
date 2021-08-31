package com.example.hitit.service;

import com.example.hitit.dto.TreeDto;
import com.example.hitit.dto.TreeSpecieDto;
import com.example.hitit.model.TreeSpecie;
import com.example.hitit.repository.TreeSpecieJpaRepository;
import lombok.RequiredArgsConstructor;
import com.example.hitit.model.Tree;
import org.springframework.stereotype.Service;
import com.example.hitit.repository.TreeJpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreeService implements ITreeService {

    private final TreeJpaRepository treeJpaRepository;
    private final TreeSpecieJpaRepository treeSpecieJpaRepository;

    @Override
    public List<TreeDto> getTrees() {
        Iterable<Tree> iter = treeJpaRepository.findAll();
        List<Tree> treeList = new ArrayList<>();
        iter.forEach(treeList::add);
        List<TreeDto> treeDtoList = TreeDto.TreeToTreeDto(treeList);
        return treeDtoList;
    }

    @Override
    public TreeDto getTreeById(Integer id) {
        Optional<Tree> optionalTree = treeJpaRepository.findById(id);
        TreeDto treeDto = new TreeDto();
        if(optionalTree.isPresent()){
            treeDto = TreeDto.TreeToTreeDtoByID(optionalTree.get());
            return treeDto;
        }
        else{
            throw new RuntimeException("Tree not found");
        }
    }

    @Override
    public void addTree(TreeDto treeDto) {
        Iterable<TreeSpecie> iter = treeSpecieJpaRepository.findAll();
        List<TreeSpecie> treeSpecies = new ArrayList<>();
        iter.forEach(treeSpecies::add);
        List<TreeSpecieDto> treeSpecieDtos = TreeSpecieDto.TreeToTreeDto(treeSpecies);
        Integer tempId = null;
        for (int i = 0; i < treeSpecieDtos.size(); i++){
            if(treeSpecieDtos.get(i).getName().equals(treeDto.getTreeSpecie())){
                tempId = treeSpecieDtos.get(i).getId();
            }
        }
        Tree tree = new Tree();
        if (tempId == null) {
            tree = Tree.treeDtoToTree(treeDto);
            TreeSpecie treeSpecie = new TreeSpecie();
            treeSpecie.setId(treeSpecieDtos.size() + 1);
            treeSpecie.setName(treeDto.getTreeSpecie());
            tree.setTreeSpecie(treeSpecie);
            treeSpecieJpaRepository.save(treeSpecie);
        }
        else {
            tree = Tree.treeDtoToTree(treeDto);
            TreeSpecie treeSpecie = new TreeSpecie();
            treeSpecie.setId(tempId);
            treeSpecie.setName(treeDto.getTreeSpecie());
            tree.setTreeSpecie(treeSpecie);
        }
        treeJpaRepository.save(tree);
    }

    @Override
    @Transactional
    public void deleteTree(Integer id) {
        treeJpaRepository.deleteTree(id);
    }
}
