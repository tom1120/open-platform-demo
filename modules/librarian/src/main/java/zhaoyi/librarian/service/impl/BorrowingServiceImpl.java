package zhaoyi.librarian.service.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import zhaoyi.librarian.db.BorrowStatus;
import zhaoyi.librarian.db.Borrowing;
import zhaoyi.librarian.db.repo.BorrowingRepository;
import zhaoyi.librarian.service.BorrowingService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BorrowingServiceImpl implements BorrowingService {
    @Inject
    BorrowingRepository _borrowings;
    @Override
    public String getCode() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

    @Override
    @Transactional
    public Borrowing confirm(Long id) {
        Borrowing borrowing=_borrowings.find(id);
        borrowing.setReturnTime(borrowing.getBorrowTime().plusDays(borrowing.getDays()));
        borrowing.setStatus(BorrowStatus.WAIT);
        _borrowings.save(borrowing);
        return borrowing;
    }

    @Override
    @Transactional
    public Borrowing back(Long id) {
        Borrowing borrowing=_borrowings.find(id);
        borrowing.setBackTime(LocalDateTime.now());
        borrowing.setStatus(BorrowStatus.DONE);
        _borrowings.save(borrowing);
        return borrowing;
    }
}
