package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

@Component
public class MgrMemberDAO {
	
	//��ü ȸ�� ��� ��ȸ
	public List<MgrMemberDomain> selectMember(MgrMemberVO mmVO){
		List<MgrMemberDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		list=session.selectList("potato.manager.mgrMemberMapper.memberList",mmVO);
		
		mbh.closeHandler(session);
		
		return list;
	}
	
	//Ż�� ȸ�� ��� ��ȸ
	public List<MgrMemberDomain> selectQuitMember(MgrMemberVO mmVO){
		List<MgrMemberDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		list=session.selectList("potato.manager.mgrMemberMapper.quitMemberList",mmVO);
		
		mbh.closeHandler(session);
		
		return list;
	}
	
	//���� ȸ�� ��� ��ȸ
	public List<MgrMemberDomain> selectBlockMember(MgrMemberVO mmVO){
		List<MgrMemberDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		list=session.selectList("potato.manager.mgrMemberMapper.blockMemberList",mmVO);
		
		mbh.closeHandler(session);
		
		return list;
	}
	
	//ȸ�� �� ���� �˾�â
	public MgrMemberDomain selectDetailInfo(String id) {
		MgrMemberDomain mmd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		mmd=session.selectOne("potato.manager.mgrMemberMapper.infoPopup",id);
		mbh.closeHandler(session);
		
		return mmd;
	}
	
	//���� �˾�â) ���� ���� �ҷ�����
	public List<MgrBlockReasonDomain> selectReason(){
		List<MgrBlockReasonDomain> list =null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		list=session.selectList("potato.manager.mgrMemberMapper.blockReason");
		
		mbh.closeHandler(session);
		
		return list;
	}
	
	//ȸ�� ����
	public int insertBlock(ManagerBlockVO mbVO) throws PersistenceException {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		int cnt=session.insert("potato.manager.mgrMemberMapper.blockMember",mbVO);
		if(cnt == 1) {
			session.commit();
		}
		
		mbh.closeHandler(session);
		
		return cnt;
	}
	
	//���� ����
	public int deleteBlock(String id) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		int cnt=session.delete("potato.manager.mgrMemberMapper.unblock",id);
		if(cnt!=0) {
			session.commit();
		}else {
		}
		
		mbh.closeHandler(session);
		return cnt;
	}
	
	//����¡(��ü ����� �� �ο���)
	public int selectTotalPages1(MgrMemberVO mmVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		cnt=session.selectOne("potato.manager.mgrMemberMapper.selectTotalPages1",mmVO);
		
		return cnt;
	}
	//����¡(Ż�� ȸ�� �� �ο���)
	public int selectTotalPages2(MgrMemberVO mmVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		cnt=session.selectOne("potato.manager.mgrMemberMapper.selectTotalPages2",mmVO);
		
		return cnt;
	}
	//����¡(�� �Խù� ��)
	public int selectTotalPages3(MgrMemberVO mmVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		cnt=session.selectOne("potato.manager.mgrMemberMapper.selectTotalPages3",mmVO);
		
		return cnt;
	}
}