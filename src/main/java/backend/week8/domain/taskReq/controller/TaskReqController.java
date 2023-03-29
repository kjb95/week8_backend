package backend.week8.domain.taskReq.controller;

import backend.week8.domain.taskReq.dto.CreateTaskReqRequestDto;
import backend.week8.domain.taskReq.service.TaskReqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/taskReq")
public class TaskReqController {
	private final TaskReqService taskReqService;

	/**
	 * 테스크 요청 파일 업로드
	 */
	@PostMapping("/file")
	public ResponseEntity<Void> uploadTaskReqFile(@RequestParam MultipartFile file) throws IOException {
		taskReqService.uploadTaskReqFile(file);
		return ResponseEntity.ok()
				.build();
	}

	/**
	 * 테스크 작업 요청
	 */
	@PostMapping
	public ResponseEntity<Void> createTaskReq(@RequestBody CreateTaskReqRequestDto createTaskReqRequestDto) {
		taskReqService.createTaskReq(createTaskReqRequestDto);
		return ResponseEntity.ok()
				.build();
	}

	/**
	 * 테스크 요청 파일 삭제
	 */
	@DeleteMapping
	public ResponseEntity<Void> deleteTaskReqFile(@RequestParam String taskReqFile) {
		taskReqService.deleteTaskReqFile(taskReqFile);
		return ResponseEntity.ok()
				.build();
	}
}
