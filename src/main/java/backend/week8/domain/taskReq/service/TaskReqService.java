package backend.week8.domain.taskReq.service;

import backend.week8.domain.member.entity.Member;
import backend.week8.domain.member.repository.MemberRepository;
import backend.week8.domain.taskReq.dto.CreateTaskReqRequestDto;
import backend.week8.domain.taskReq.entity.TaskReq;
import backend.week8.domain.taskReq.repository.TaskReqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TaskReqService {
	private static final String NOT_FOUND_MEMBER = "존재하지 않는 회원 아이디";
	private final TaskReqRepository taskReqRepository;
	private final MemberRepository memberRepository;
	@Value("${file.dir}")
	private String fileDir;

	/**
	 * 테스크 작업 요청
	 */
	public void createTaskReq(CreateTaskReqRequestDto createTaskReqRequestDto) {
		Member member = memberRepository.findById(createTaskReqRequestDto.getMemberId())
				.orElseThrow(() -> new NoSuchElementException(NOT_FOUND_MEMBER));
		TaskReq taskReq = new TaskReq(member, createTaskReqRequestDto.getJobName(), createTaskReqRequestDto.getTaskReqFile());
		taskReqRepository.save(taskReq);
	}

	/**
	 * 테스크 요청 파일 삭제
	 */
	public void deleteTaskReqFile(String taskReqFile) {
		File file = new File(fileDir + taskReqFile);
		file.delete();
	}

	/**
	 * 테스크 요청 파일 업로드
	 */
	public void uploadTaskReqFile(MultipartFile file) throws IOException {
		String fullPath = fileDir + file.getOriginalFilename();
		file.transferTo(new File(fullPath));
	}
}
