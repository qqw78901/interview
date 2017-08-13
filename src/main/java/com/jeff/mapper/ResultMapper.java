package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.Result;
import com.jeff.vo.InterviewResultVo;
import com.jeff.vo.IntervieweeResultVo;
import com.jeff.vo.ResultVo;

@Repository
public interface ResultMapper extends BaseMapper<Result, String> {
	int addResult(Result result);
	List<ResultVo> showAllResultbyPage(ResultVo resultVo);
	int set(Result result);
	Result getInterview(Result result);
	int deleteAllNext(Result result);
	int check(Result result);
	List<IntervieweeResultVo> selectIntervieweeByPage(ResultVo resultVo);
	List<InterviewResultVo> getInterviewSummary(String interviewId);
	int remove(Result result);
}
