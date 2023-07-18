package zhaoyi.librarian.service;

import com.axelor.meta.CallMethod;
import zhaoyi.librarian.db.Borrowing;

public interface BorrowingService {
    @CallMethod
    String getCode();
    Borrowing confirm(Long id);
    Borrowing back(Long id);
}
