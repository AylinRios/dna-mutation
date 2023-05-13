package adnmutation.service;

import adnmutation.dao.UserDAO;
import adnmutation.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService {

	private final UserDAO userDAO;

	public Optional<User> getByUserName(String username){
		return userDAO.findUserByUsername(username);
	}

	public boolean existsByUserName(String username){
		return userDAO.existsByUsername(username);
	}


}
