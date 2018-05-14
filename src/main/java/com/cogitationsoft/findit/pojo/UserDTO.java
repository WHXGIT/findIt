package com.cogitationsoft.findit.pojo;

import com.cogitationsoft.findit.common.enums.AuthorityEnum;
import com.cogitationsoft.findit.common.enums.SexEnum;
import com.cogitationsoft.findit.common.enums.StateEnum;
import com.cogitationsoft.findit.common.exception.UserDTOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author: Andy
 * @date: 5/8/2018 5:33 PM
 * @description: User data transport object
 * @version: 1.0
 */
public class UserDTO {

	private static final Logger logger = LogManager.getLogger(UserDTO.class);
	/**
	 * Method Description:
	 * 〈User view object translate to user data object〉
	 *
	 * @param:      UserDO
	 * @return:     UserVO
	 * @author:     Andy
	 * @date:       5/11/2018 12:22 PM
	 */
	public UserVO toUserVO(UserDO userDO) throws UserDTOException{
		UserVO userVO = new UserVO();
		userVO.setUserId(userDO.getUserId());
		userVO.setAge(userDO.getAge());
		userVO.setHeadImg(userDO.getHeadImg());
		userVO.setNickname(userDO.getNickname());
		userVO.setRegisterTime(userDO.getRegisterTime());
		userVO.setOtherConnect(userDO.getOtherConnect());
		userVO.setSex(SexEnum.getEnum(userDO.getSex()));
		userVO.setState(StateEnum.getEnum(userDO.getState()));
		userVO.setAuthority(AuthorityEnum.getEnum(userDO.getAuthority()));
		userVO.setUsername(userDO.getUsername());
		userVO.setPhone(userDO.getPhone());
		return userVO;
	}

	/**
	 * Method Description:
	 * 〈User data object translate to view object〉
	 *
	 * @param:      UserVO
	 * @return:     UserDO
	 * @author:     Andy
	 * @date:       5/11/2018 12:22 PM
	 */
	public UserDO toUserDO(UserVO userVO) throws UserDTOException{
		if(userVO == null){
			return null;
		}
		UserDO userDO = new UserDO();
		userDO.setUserId(userVO.getUserId());
		userDO.setAge(userVO.getAge());
		userDO.setHeadImg(userVO.getHeadImg());
		userDO.setNickname(userVO.getNickname());
		userDO.setRegisterTime(userVO.getRegisterTime());
		userDO.setOtherConnect(userVO.getOtherConnect());
		if(userVO.getSex() != null){
			userDO.setSex(userVO.getSex().getValue());
		}
		if(userVO.getState() != null){
			userDO.setState(userVO.getState().getValue());
		}
		if(userVO.getAuthority() != null){
			userDO.setAuthority(userVO.getAuthority().getValue());
		}
		userDO.setUsername(userVO.getUsername());
		userDO.setPhone(userVO.getPhone());
		return userDO;
	}
}
