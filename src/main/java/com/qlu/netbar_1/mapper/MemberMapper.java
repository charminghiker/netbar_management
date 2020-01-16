package com.qlu.netbar_1.mapper;

import com.qlu.netbar_1.pojo.Member;

import java.util.Date;
import java.util.List;

public interface MemberMapper {
        //查询全部会员信息
        List<Member> queryAll();

        //通过ID查询会员信息
        Member queryById(int memberId);

        //增加会员信息
        int insertMst(Member member);
        int insertDtl(Member member);

        //修改会员信息
        int update(Member member);

        //更新状态信息
        int updateStartById(int memberId, int addMoney);
        int updateEndById(int memberId, int memberAccount);
        int updateLastUse(int memberId, Date lastUse);

        //删除会员信息
        int deleteMst(int memberId);
        int deleteDtl(int memberId);

}
