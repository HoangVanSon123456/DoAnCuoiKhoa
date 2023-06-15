package com.example.doancuoikhoa.controllers;


import com.example.doancuoikhoa.model.StudyScoreDTO;
import com.example.doancuoikhoa.model.TuitionDTO;
import com.example.doancuoikhoa.services.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class TuitionAPIController {

    @Autowired
    private TuitionService tuitionService;

    @GetMapping("/admin/tuition")
    private List<TuitionDTO> getAll() {
        return tuitionService.getListTuition();
    }

    @GetMapping("/admin/tuition/{id}")
    private TuitionDTO getNotifiationById(@PathVariable(name = "id") Integer id) {
        return tuitionService.getTuitionById(id);
    }
    @DeleteMapping(value = "/admin/tuition/delete/{id}")
    private void deleteTuition(@PathVariable(name = "id") Integer id) throws Exception {
        tuitionService.deleteTuition(id);
    }

    @PostMapping(value = "/admin/tuition/add")
    private TuitionDTO addTuition(@RequestBody TuitionDTO tuitionDTO) {
        tuitionService.addTuition(tuitionDTO);
        return tuitionDTO;
    }

    @PutMapping(value = "/admin/tuition/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody TuitionDTO tuitionDTO) throws Exception {
        tuitionService.updateTuition(tuitionDTO);
    }

    @GetMapping("/admin/user_tuition")
    private List<TuitionDTO> getAllByUserId(@RequestHeader(name = "userId") Integer userId) {
        return tuitionService.getUserTuition(userId);
    }
}
