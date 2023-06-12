package com.service.core.mbti.application;

import com.service.core.mbti.domain.converter.MbtiResultConverter;
import com.service.core.mbti.dto.request.CreateMyMbtiRequest;
import com.service.core.mbti.dto.request.CreateQuizRequest;
import com.service.core.mbti.dto.request.CreateQuizRoundRequest;
import com.service.core.mbti.dto.request.CreateMbtiQuizRoundAnswerRequest;
import com.service.core.mbti.dto.response.ReadMbtiQuizRoundResponse;
import com.service.core.mbti.dto.response.ReadMbtiQuizzesResponse;
import com.service.core.mbti.infrastructure.MbtiMetadataRepository;
import com.service.core.mbti.infrastructure.MbtiQuizHistoryRepository;
import com.service.core.mbti.infrastructure.MbtiQuizRepository;
import com.service.core.mbti.infrastructure.MbtiQuizRoundRepository;
import com.service.core.mbti.infrastructure.MemberMbtiRepository;
import com.service.core.member.domain.vo.RoleType;
import com.service.core.member.dto.response.UserInfo;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MbtiService {
    private final MemberMbtiRepository memberMbtiRepository;
    private final MbtiMetadataRepository mbtiMetadataRepository;
    private final MbtiQuizRoundRepository mbtiQuizRoundRepository;
    private final MbtiQuizHistoryRepository mbtiQuizHistoryRepository;
    private final MbtiQuizRepository mbtiQuizRepository;
    private final MbtiResultConverter converter;

    @Transactional
    public String mbtiQuizResultSave(UserInfo user, CreateMyMbtiRequest request) {
            String mbtiName = converter.convertToMbtiQuizResult(request.getMbtiRequest());
            memberMbtiRepository
                .save(
                    converter.convertToMemberMbti(
                        user.getId(),
                        mbtiMetadataRepository.findByType(mbtiName).get()
                    ));
            return mbtiName;
    }

    @Transactional
    public void createQuiz(UserInfo user, List<CreateQuizRequest> request){
        if(user.getRoleType().equals(RoleType.ADMIN)){
           mbtiQuizRepository.saveAll(converter.convertToMbtiQuizzes(request));
        }else{
            System.out.println("권한이 알맞지 않습니다.");
        }
    }

    //질문 round 생성
    @Transactional
    public void createQuizRound(UserInfo user, CreateQuizRoundRequest request){
        if(user.getRoleType().equals(RoleType.ADMIN)){
            mbtiQuizRoundRepository.save(converter.convertToMbtiQuizRoundEntity(request));
        }else{
            System.out.println("권한이 알맞지 않습니다.");
        }
    }

    // 유저 답변 저장
    @Transactional
    public void quizRoundAnswer(List<CreateMbtiQuizRoundAnswerRequest> answer, UserInfo user){
        mbtiQuizHistoryRepository.saveAll(converter.convertToMbtiQuizHistory(answer, user.getId()));
    }

    //해당 문제 리스트 별로 출력
    @Transactional
    public List<ReadMbtiQuizzesResponse> getFindQuizzes(Long roundId){
       return converter.convertToReadMbtiQuizzesResponse(mbtiQuizRepository.findByRoundId(roundId));
    }

    //라운드 종류 전체 조회
    @Transactional
    public List<ReadMbtiQuizRoundResponse> getQuizRound(){
        return converter.convertToMbtiQuizRound(mbtiQuizRoundRepository.findAll());
    }
}