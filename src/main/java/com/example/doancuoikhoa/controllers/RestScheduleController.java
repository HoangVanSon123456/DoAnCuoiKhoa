package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.RestScheduleDTO;
import com.example.doancuoikhoa.model.TuitionDTO;
import com.example.doancuoikhoa.services.RestScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class RestScheduleController {

    @Autowired
    private RestScheduleService restScheduleService;

    @GetMapping("/admin/restSchedule")
    private List<RestScheduleDTO> getAll() {
        return restScheduleService.getAll();
    }

    @PostMapping(value = "/admin/restSchedule/add")
    private RestScheduleDTO addrestSchedule(@RequestBody RestScheduleDTO restScheduleDTO) {
        restScheduleService.addRestSchedule(restScheduleDTO);
        return restScheduleDTO;
    }
    @GetMapping("/admin/restSchedule/{id}")
    private RestScheduleDTO getrestScheduleById(@PathVariable(name = "id") Integer id) {
        return restScheduleService.getRestScheduleById(id);
    }
    @DeleteMapping(value = "/admin/restSchedule/delete/{id}")
    private void deleterestSchedule(@PathVariable(name = "id") Integer id) throws Exception {
        restScheduleService.deleteRestSchedule(id);
    }

    @PutMapping(value = "/admin/restSchedule/update/{id}")
    public void updaterestSchedule(@PathVariable(name = "id") Integer id,@RequestBody RestScheduleDTO restScheduleDTO) throws Exception {
        restScheduleService.updateRestSchedule(restScheduleDTO);
    }

    @GetMapping("/admin/user_restSchedule/{userId}")
    private List<RestScheduleDTO> getAllByUserId(@PathVariable(name = "userId") Integer userId) {
        return restScheduleService.getUserRestSchedule(userId);
    }

    @GetMapping(value = "/admin/restSchedule/search/{keyword}")
    public  List<RestScheduleDTO> search(@PathVariable(name = "keyword") String keyword) {
        return restScheduleService.search(keyword);
    }
}
