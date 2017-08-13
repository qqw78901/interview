package com.jeff.service;

import com.jeff.mybatis.page.Page;
import com.jeff.po.Result;
import com.jeff.util.ExcelFile;
import com.jeff.vo.IntervieweeResultVo;
import com.jeff.vo.ResultVo;

public interface ResultService extends BaseService<Result, String> {
	public int addResult(Result result);

	public Page<ResultVo> showAllResultbyPage(ResultVo resultVo);

	public int set(Result result);

	public Result getInterview(Result result);

	public int check(Result result);// 检查是否下级已有result

	public Page<IntervieweeResultVo> selectIntervieweeByPage(ResultVo resultVo);

	public ExcelFile getInterviewSummary(String interviewId);
	// public int deleteAllNext(Result result);//不需要用

	public int remove(Result result);
}
