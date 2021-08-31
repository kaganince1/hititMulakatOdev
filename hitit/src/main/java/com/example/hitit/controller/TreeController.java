package com.example.hitit.controller;

import com.example.hitit.dto.TreeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.hitit.service.ITreeService;


@Controller
@RequiredArgsConstructor
public class TreeController {

    private final ITreeService iTreeService;

    @GetMapping("/tree")
    public String getHomePage(Model model) {
        model.addAttribute("listTree", iTreeService.getTrees());
        return "index";
    }

    @GetMapping("/add-tree-form")
    public String addTreeForm(Model model) {
        TreeDto treeDto = new TreeDto();
        model.addAttribute("tree", treeDto);
        return"new_tree";
    }

    @GetMapping("/update-tree-from/{id}")
    public String updateTreeFrom(@PathVariable(value = "id") Integer id, Model model){
        TreeDto treeDto = iTreeService.getTreeById(id);
        model.addAttribute("tree", treeDto);
        return "update_tree";
    }

    @PostMapping("/add-tree")
    public String saveTree(@ModelAttribute("tree") TreeDto treeDto) {
        iTreeService.addTree(treeDto);
        return "redirect:/tree";
    }

    @GetMapping("/delete-tree/{id}")
    public void deleteTreeById(@PathVariable(value = "id") Integer id) {
        iTreeService.deleteTree(id);
    }
}
