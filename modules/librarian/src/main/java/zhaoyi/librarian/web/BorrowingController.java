package zhaoyi.librarian.web;

import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import zhaoyi.librarian.db.Borrowing;
import zhaoyi.librarian.service.BorrowingService;

public class BorrowingController {
    @Inject
    BorrowingService _borrowingService;
    public void onConfirm(ActionRequest request, ActionResponse response){
        Borrowing borrowing=request.getContext().asType(Borrowing.class);
        response.setReadonly("borrowTime",true);
        _borrowingService.confirm(borrowing.getId());
        response.setNotify("赵义说：借阅已生效");
        response.setReload(true);
    }

    public void onBack(ActionRequest request,ActionResponse response){
        Borrowing borrowing=request.getContext().asType(Borrowing.class);
        _borrowingService.back(borrowing.getId());
        response.setNotify("赵义说：已成功还书");
        response.setReload(true);
    }

}
