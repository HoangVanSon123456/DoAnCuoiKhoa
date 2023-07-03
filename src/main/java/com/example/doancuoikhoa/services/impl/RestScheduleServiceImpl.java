package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.entities.RestSchedule;
import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.model.RestScheduleDTO;
import com.example.doancuoikhoa.repositories.RestScheduleRepository;
import com.example.doancuoikhoa.services.RestScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RestScheduleServiceImpl implements RestScheduleService {

    @Autowired
    private RestScheduleRepository restScheduleRepository;
    @Override
    public void addRestSchedule(RestScheduleDTO restScheduleDTO) {
        RestSchedule restSchedule = new RestSchedule();
        restSchedule.setName(restScheduleDTO.getName());
        restSchedule.setPoetry(restScheduleDTO.getPoetry());
        restSchedule.setExamTime(restScheduleDTO.getExamTime());
        restSchedule.setTestDay(restScheduleDTO.getTestDay());
        restSchedule.setIdentificatioNumber(restScheduleDTO.getIdentificatioNumber());
        restSchedule.setExaminationRoom(restScheduleDTO.getExaminationRoom());
        User user = new User();
        user.setId(restScheduleDTO.getUserId());
//        user.setName(restScheduleDTO.getUserName());
//        user.setCode(restScheduleDTO.getUserCode());
        restSchedule.setUser(user);
        Course course = new Course();
        course.setId(restScheduleDTO.getCourseId());
//        course.setName(restScheduleDTO.getCourseName());
//        course.setCreditName(restScheduleDTO.getCreditName());
        restSchedule.setCourse(course);

        restScheduleRepository.save(restSchedule);

    }

    @Override
    public void updateRestSchedule(RestScheduleDTO restScheduleDTO) throws Exception {
        RestSchedule restSchedule = restScheduleRepository.findRestScheduleById(restScheduleDTO.getId());
        if (restSchedule != null) {
            restSchedule.setName(restScheduleDTO.getName());
            restSchedule.setPoetry(restScheduleDTO.getPoetry());
            restSchedule.setExamTime(restScheduleDTO.getExamTime());
            restSchedule.setTestDay(restScheduleDTO.getTestDay());
            restSchedule.setIdentificatioNumber(restScheduleDTO.getIdentificatioNumber());
            restSchedule.setExaminationRoom(restScheduleDTO.getExaminationRoom());
//            User user = new User();
//            user.setId(restScheduleDTO.getUserId());
//            user.setName(restScheduleDTO.getUserName());
//            user.setCode(restScheduleDTO.getUserCode());
//            restSchedule.setUser(user);
//            Course course = new Course();
//            course.setId(restScheduleDTO.getCourseId());
//            course.setName(restScheduleDTO.getCourseName());
//            course.setCreditName(restScheduleDTO.getCreditName());
//            restSchedule.setCourse(course);

            restScheduleRepository.save(restSchedule);
        }
    }

    @Override
    public void deleteRestSchedule(Integer id) throws Exception {
        RestSchedule restSchedule = restScheduleRepository.findRestScheduleById(id);
        if (restSchedule != null) {
            restScheduleRepository.delete(restSchedule);
        }

    }

    @Override
    public RestScheduleDTO getRestScheduleById(Integer id) {
        RestSchedule restSchedule = restScheduleRepository.findRestScheduleById(id);
        if (restSchedule != null) {
            return  convertToDTO(restSchedule);
        }
        return null;
    }

    private RestScheduleDTO convertToDTO(RestSchedule restSchedule) {
        RestScheduleDTO restScheduleDTO = new RestScheduleDTO();
        restScheduleDTO.setId(restSchedule.getId());
        restScheduleDTO.setName(restSchedule.getName());
        restScheduleDTO.setPoetry(restSchedule.getPoetry());
        restScheduleDTO.setExamTime(restSchedule.getExamTime());
        restScheduleDTO.setTestDay(restSchedule.getTestDay());
        restScheduleDTO.setIdentificatioNumber(restSchedule.getIdentificatioNumber());
        restScheduleDTO.setExaminationRoom(restSchedule.getExaminationRoom());
        restScheduleDTO.setCourseId(restSchedule.getCourse().getId());
        restScheduleDTO.setCourseName(restSchedule.getCourse().getName());
        restScheduleDTO.setCreditName(restSchedule.getCourse().getCreditName());
        restScheduleDTO.setUserId(restSchedule.getUser().getId());
        restScheduleDTO.setUserName(restSchedule.getUser().getName());
        restScheduleDTO.setUserCode(restSchedule.getUser().getCode());
        return  restScheduleDTO;
    }

    @Override
    public List<RestScheduleDTO> getAll() {
        List<RestSchedule> restSchedules = restScheduleRepository.findAllBy();
        List<RestScheduleDTO> restScheduleDTOS = new ArrayList<>();
        restSchedules.forEach(restSchedule -> {
            restScheduleDTOS.add(convertToDTO(restSchedule));
        });
        return restScheduleDTOS;
    }
}
