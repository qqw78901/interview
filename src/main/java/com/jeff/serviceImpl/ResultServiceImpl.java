package com.jeff.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.common.mConst;
import com.jeff.mapper.InterviewMapper;
import com.jeff.mapper.ResultMapper;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Result;
import com.jeff.service.ResultService;
import com.jeff.util.ExcelFile;
import com.jeff.vo.EnterRowVo;
import com.jeff.vo.InterviewResultVo;
import com.jeff.vo.IntervieweeResultVo;
import com.jeff.vo.ResultVo;

@Service
public class ResultServiceImpl extends BaseServiceImpl<Result, String> implements ResultService {


	@Autowired
	private ResultMapper resultMapper;
	@Autowired
	private InterviewMapper interviewMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(resultMapper);
	}

	@Override
	public int addResult(Result result) {
		return resultMapper.addResult(result);
	}

	@Override
	public Page<ResultVo> showAllResultbyPage(ResultVo resultVo) {
		return this.buildVoPage(resultMapper.showAllResultbyPage(resultVo));
	}

	@Override
	public int set(Result result) {
		int r;
		r = resultMapper.set(result);
		if (result.getResult().equals(mConst.STATE_T)) {// 若为通过
														// 则置T并加下一级interview
			String nextInterview = interviewMapper.getChild(result.getInterviewId());
			if (nextInterview != null) {
				Result checkResult = new Result();
				checkResult.setInterviewee(result.getInterviewee());
				checkResult.setInterviewId(nextInterview);// 用于判断是否已存在值需要的参数的赋值
				if (resultMapper.check(checkResult) == 0) {// 检查是否已经被通过了再通过
					Result next = new Result();
					next.setInterviewee(result.getInterviewee());// 同样的面试者
					next.setInterviewId(nextInterview);// 下一级的interview
					resultMapper.addResult(next);
				}
			}
		} else if (result.getResult().equals(mConst.STATE_F)) {// 若为不通过
																// 则置F并删除下级所有的interview
			resultMapper.deleteAllNext(result);
		}
		return r;
	}

	@Override
	public Result getInterview(Result result) {
		return resultMapper.getInterview(result);
	}

	@Override
	public int check(Result result) {
		return resultMapper.check(result);
	}

	@Override
	public Page<IntervieweeResultVo> selectIntervieweeByPage(ResultVo resultVo) {
		return this.buildVoPage(resultMapper.selectIntervieweeByPage(resultVo));
	}

	@Override
	public ExcelFile getInterviewSummary(String interviewId) {
		final int prefixSize = 3, suffixSize = 1;
		List<InterviewResultVo> interviewResults = resultMapper.getInterviewSummary(interviewId);
		if (interviewResults != null && !interviewResults.isEmpty()) {
			List<EnterRowVo> headers = interviewResults.get(0).getEnterRows();
			List<List<String>> table = new ArrayList<>(interviewResults.size());
			for (int i = 0; i != interviewResults.size(); ++i) {
				String row[] = new String[headers.size() + prefixSize + suffixSize];
				InterviewResultVo currResult = interviewResults.get(i);
				row[0] = currResult.getName();
				row[1] = currResult.getCard();
				row[2] = currResult.getPhone();
				row[row.length - 1] = mConst.MESSAGE_MAP.get(currResult.getResult());
				table.add(Arrays.asList(row));

			}
			for (int j = 0; j != headers.size(); ++j) {
				EnterRowVo header = headers.get(j);
				assert header.getQuestionType().equals("text");// TODO：处理内容分类
				for (int i = 0; i < table.size(); ++i) {
					EnterRowVo currRow = interviewResults.get(i).getEnterRows().get(j);
					assert currRow.getQuestion().equals(header.getQuestion());
					table.get(i).set(prefixSize + j, currRow.getAnswer());
				}
			}
			String headerStrs[] = new String[headers.size() + prefixSize + suffixSize];
			headerStrs[0] = "姓名";
			headerStrs[1] = "学号";
			headerStrs[2] = "手机号";
			for (int i = 0; i < headers.size(); i++) {
				headerStrs[i + prefixSize] = headers.get(i).getQuestion();
			}
			headerStrs[headerStrs.length - 1] = "结果";
			ExcelFile excelFile = new ExcelFile("summary", Arrays.asList(headerStrs), table);
			return excelFile;
		} else {
			return null;
		}
	}

	@Override
	public int remove(Result result) {
		return resultMapper.remove(result);
	}

}
