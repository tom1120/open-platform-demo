package zhaoyi.librarian.db.repo;

import com.axelor.auth.db.User;
import com.axelor.auth.db.repo.UserRepository;
import zhaoyi.librarian.db.Reader;

import javax.inject.Inject;

public class ReaderRepository extends AbstractReaderRepository{
    @Inject
    private UserRepository _users;

    @Override
    public void remove(Reader entity) {
        if(entity.getUser()!=null){
            User user=_users.find(entity.getUser().getId());
            if(user!=null){
                user.setReader(null);
                _users.save(user);
                _users.remove(user);
            }
        }
        super.remove(entity);
    }
}
