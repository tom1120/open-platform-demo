package zhaoyi.librarian;

import com.axelor.app.AxelorModule;
import zhaoyi.librarian.service.BorrowingService;
import zhaoyi.librarian.service.ReaderService;
import zhaoyi.librarian.service.impl.BorrowingServiceImpl;
import zhaoyi.librarian.service.impl.ReaderServiceImpl;

public class LibrarianModule extends AxelorModule {

    @Override
    protected void configure() {
        bind(ReaderService.class).to(ReaderServiceImpl.class);
        bind(BorrowingService.class).to(BorrowingServiceImpl.class);
    }
}
