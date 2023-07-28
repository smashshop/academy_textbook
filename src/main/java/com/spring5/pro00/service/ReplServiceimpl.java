package com.spring5.pro00.service;

import org.springframework.stereotype.Service;

import com.spring5.pro00.common.paging.ReplPagingCreaterDTO;
import com.spring5.pro00.common.paging.ReplPagingDTO;
import com.spring5.pro00.domain.ReplVO;
import com.spring5.pro00.mapper.ReplMapper;

@Service
public class ReplServiceimpl implements ReplService{
	
	private ReplMapper rm;
	
	public ReplServiceimpl(ReplMapper rm) {
		this.rm = rm;
	}

	@Override
	public long getReplCnt(ReplPagingDTO pagingDTO) {
		return rm.selectReplTotCnt(pagingDTO);
	}

	@Override
	public ReplPagingCreaterDTO getReplList(ReplPagingDTO pagingDTO) {
		ReplPagingCreaterDTO replPagingCreaterDTO = 
				new ReplPagingCreaterDTO(rm.selectReplTotCnt(pagingDTO), 
						pagingDTO,
						rm.selectReplList(pagingDTO));
				
		return replPagingCreaterDTO;
	}

	@Override
	public long registerReplForBoard(ReplVO ReplVO) {
		return rm.insertReplForBoard(ReplVO);
	}

	@Override
	public long registerReplForRepl(ReplVO ReplVO) {
		return rm.insertReplForRepl(ReplVO);
	}

	@Override
	public ReplVO getRepl(long bno, long rno) {
		return rm.selectRepl(bno, rno);
	}

	@Override
	public boolean modifyReply(ReplVO replVO) {
		return rm.updateRepl(replVO) == 1;
	}

	@Override
	public boolean removeRepl(long bno, long rno) {
		return rm.deleteRepl(bno, rno) == 1;
	}
	
	
}
