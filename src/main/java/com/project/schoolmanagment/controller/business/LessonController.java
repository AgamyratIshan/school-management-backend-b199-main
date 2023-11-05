package com.project.schoolmanagment.controller.business;

import com.project.schoolmanagment.payload.request.business.LessonRequest;
import com.project.schoolmanagment.payload.response.abstracts.ResponseMessage;
import com.project.schoolmanagment.payload.response.business.LessonResponse;
import com.project.schoolmanagment.service.business.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

	private final LessonService lessonService;

	@PostMapping("/save")
	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	public ResponseMessage<LessonResponse>saveLesson(@Valid @RequestBody LessonRequest lessonRequest){
		return lessonService.saveLesson(lessonRequest);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
	public ResponseMessage deleteLesson (@PathVariable Long id){
		return lessonService.deleteLessonById(id);
	}



}