package com.spring5.pro00.service;

import com.spring5.pro00.common.paging.ReplPagingCreaterDTO;
import com.spring5.pro00.common.paging.ReplPagingDTO;
import com.spring5.pro00.domain.ReplVO;

public interface ReplService {
	
	public long getReplCnt(ReplPagingDTO pagingDTO);
	
	public ReplPagingCreaterDTO getReplList(ReplPagingDTO pagingDTO);
	
	public long registerReplForBoard(ReplVO ReplVO);
	
	public long registerReplForRepl(ReplVO ReplVO);
	
	public ReplVO getRepl(long bno, long rno);
	
	public boolean modifyReply(ReplVO replVO);
	
	public boolean removeRepl(long bno, long rno);
	
	
}
