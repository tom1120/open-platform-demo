package zhaoyi.librarian.service;

import com.axelor.auth.db.User;
import zhaoyi.librarian.db.Reader;

public interface ReaderService {
    User assignNewUser(Reader reader);
}
