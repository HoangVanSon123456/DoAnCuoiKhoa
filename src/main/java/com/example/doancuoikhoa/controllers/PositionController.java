package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.PositionDTO;
import com.example.doancuoikhoa.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class PositionController {

    @Autowired
    private PositionService positionService;
    @GetMapping("/admin/position")
    private List<PositionDTO> getAll() {
        return positionService.getAll();
    }

    @GetMapping("/admin/position/{id}")
    private PositionDTO getPositionById(@PathVariable(name = "id") Integer id) {
        return positionService.getPositionById(id);
    }
    @DeleteMapping(value = "/admin/position/delete/{id}")
    private void deletePosition(@PathVariable(name = "id") Integer id) throws Exception {
        positionService.deletePosition(id);
    }

    @PostMapping(value = "/admin/position/add")
    private PositionDTO addPosition(@RequestBody PositionDTO PositionDTO) {
        positionService.addPosition(PositionDTO);
        return PositionDTO;
    }

    @PutMapping(value = "/admin/position/update/{id}")
    public void updatePosition(@PathVariable(name = "id") Long id,@RequestBody PositionDTO PositionDTO) throws Exception {
        positionService.updatePosition(PositionDTO);
    }
}
