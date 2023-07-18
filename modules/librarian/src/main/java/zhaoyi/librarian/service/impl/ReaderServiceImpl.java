package zhaoyi.librarian.service.impl;

import com.axelor.auth.db.User;
import com.axelor.auth.db.repo.UserRepository;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import zhaoyi.librarian.db.Reader;
import zhaoyi.librarian.db.repo.ReaderRepository;
import zhaoyi.librarian.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Inject private UserRepository _users;
    @Inject private ReaderRepository _readers;
    @Override
    @Transactional
    public User assignNewUser(Reader reader) {
        User newUser=new User();
        newUser.setCode(reader.getMobile());
        newUser.setName("读者 "+reader.getName());
        newUser.setForcePasswordChange(true);
        newUser.setPassword("123456");
        newUser.setReader(reader);
        newUser=_users.save(newUser);
        reader.setUser(newUser);
        _readers.save(reader);
        return newUser;
    }
}
