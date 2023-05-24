package com.ssafy.plan.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.notice.model.NoticeParameterDto;
import com.ssafy.plan.model.TripPlanDto;
import com.ssafy.plan.model.mapper.TripPlanMapper;

@Service
public class TripPlanServiceImpl implements TripPlanService {
	
	private TripPlanMapper tripPlanMapper;
	
	public TripPlanServiceImpl(TripPlanMapper tripPlanMapper) {
		super();
		this.tripPlanMapper = tripPlanMapper;
	}

	@Override
	@Transactional
	public void writePlan(TripPlanDto tripPlanDto) throws Exception {
		System.out.println("글입력 전 dto : " + tripPlanDto);
		tripPlanMapper.writePlan(tripPlanDto);
		System.out.println("글입력 후 dto : " + tripPlanDto);
		tripPlanMapper.writeContent(tripPlanDto);
//		tripPlanMapper.authPlan(tripPlanDto); -> 친구 추가 할때 넣을 예정

	}

	@Override
	public List<TripPlanDto> listPlan(NoticeParameterDto noticeParameterDto) throws Exception {
		return tripPlanMapper.listPlan(noticeParameterDto);
	}

	@Override
	public List<AttractionDto> getPlan(int planNo) throws Exception {
		return tripPlanMapper.getPlan(planNo);
	}

	@Override
	public void modifyPlan(TripPlanDto planNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePlan(int planNo) throws Exception {
		tripPlanMapper.deletePlanAttraction(planNo);
		tripPlanMapper.deleteAuthPlan(planNo);
		tripPlanMapper.deletePlan(planNo);
	}

	@Override
	public List<TripPlanDto> mylistPlan(String userId) throws Exception {
		return tripPlanMapper.mylistPlan(userId);
	}

}
